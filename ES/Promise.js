const isFunction = function(fun) {
  return typeof fun === 'function';
};
const isObject = function(value) {
  return value !== null && typeof value === 'object';
};

// [[Resolve]](promise, x): 是promise的解决过程，判断x的值的类型以及它和promise实例的关系
// 需要进行 [[Resolve]](promise, x)的地方有：
// 1. then中的onFulfilled和onRejected的返回值res：[[Resolve]](promise, res)
// 2. _promiseResolve中，x为Promise的情况，对改promise的值y进行[[Resolve]](promise, y)
// 3. _promiseResolve中，x有then且then为函数的情况，该then的第一个参数是函数resolvePromise接收一个y为参数，对y进行[[Resolve]](promise, y)
class MyPromise {
  constructor(handle) {
      if (!isFunction(handle)) {
          throw new TypeError('MyPromise resolver is not a function');
      }
      // 当前promise的状态
      this._status = 'PENDING';
      // 当前promise的值
      this._value = undefined;
      // promise状态为'FULFILLED'时需要执行的注册事件队列
      this._fulfilledQueue = [];
      // promise状态为'REJECTED'时需要执行的注册事件队列
      this._rejectedQueue = [];
      // promise创建后，同步执行handle
      // 如果handle执行出错，则将promise的状态改为'REJECTED'
      try {
          handle(this._resolve.bind(this), this._reject.bind(this));
      } catch(err) {
          this._reject(err);
      }
  }
  _resolve(value) {
      if (this._status !== 'PENDING') {
          return;
      }
      const resolveHandle = (val) => {
          this._status = 'FULFILLED';
          this._value = val;
          while(this._fulfilledQueue.length) {
              const cb = this._fulfilledQueue.shift();
              cb(val);
          }
      }
      const rejectHandle = (reason) => {
          this._status = 'REJECTED';
          this._value = reason;
          while(this._rejectedQueue.length) {
              const cb = this._rejectedQueue.shift();
              cb(reason);
          }
      }
      // 判断resolve传入的是不是一个promise
      // 如果是，需要等待该promise的状态改变，新promise的状态和该状态相同
      // 注意：Promise/A+规范并没有这个规定
      if (value instanceof MyPromise) {
          if (value === this) {
              return rejectHandle(new TypeError(''));
          }
          value.then(resolveHandle, rejectHandle);
      } else {
          // 执行_fulfilledQueue中的任务
          // 所有 onFulfilled 需按照其注册顺序依次回调
          resolveHandle(value);
      }
  }
  _reject(reason) {
      if (this._status !== 'PENDING') {
          return;
      }
      this._status = 'REJECTED';
      this._value = reason;
      // 执行_rejectedQueue中的任务
      // 所有的 onRejected 需按照其注册顺序依次回调
      while(this._rejectedQueue.length) {
          const cb = this._rejectedQueue.shift();
          cb(reason);
      }
  }
  // Promise解决过程
  // [[Resolve]](promise, x)
  _promiseResolve(promise, x, resolve, reject) {
      // x与promise相等
      // 如果promise和x指向同一对象，以TypeError为reason执行reject
      if (x === promise) {
          return reject(new TypeError(''));
      }
      // x为Promise
      // 如果 x 为 Promise ，则使 promise 接受 x 的状态
      if (x instanceof MyPromise) {
          // x的value为y, 运行[[Resolve]](promise, y)：this._promiseResolve(promise, y, resolve, reject);
          // 有可能是一个promise，所以需要调用解决过程
          x.then(
              y => {
                  this._promiseResolve(promise, y, resolve, reject);
              },
              reject
          );
          return;
      }
      // x为对象或函数
      if (isFunction(x) || isObject(x)) {
          let isCalled  = false;
          let then;
          // 如果取 x.then 的值时抛出错误 e ，则以e为reason执行reject(e)
          try {
              then = x.then;
          } catch(e) {
              return reject(e);
          }
        
          // 如果 then 是函数，将 x 作为函数的作用域 this 调用之。传递两个回调函数作为参数，第一个参数叫做 resolvePromise ，第二个参数叫做 rejectPromise:
          // 如果 resolvePromise 以 y 为参数被调用，则运行 [[Resolve]](promise, y): this._promiseResolve(promise, y, resolve, reject);
          // 如果 rejectPromise 以 r 为参数被调用，则执行reject(r);
          // 如果 resolvePromise 和 rejectPromise 均被调用，或者被同一参数调用了多次，则优先采用首次调用并忽略剩下的调用
          if (isFunction(then)) {
              const resolvePromise = y => {
                  if (isCalled) {
                      return;
                  }
                  isCalled = true;
                  this._promiseResolve(promise, y, resolve, reject);
              }
              const rejectPromise = (r) => {
                  if (isCalled) {
                      return;
                  }
                  isCalled = true;
                  reject(r);
              }
              // 如果调用 then 方法抛出了异常 e
              // 如果 resolvePromise 或 rejectPromise 已经被调用，则忽略之
              // 否则以 e 为reason执行reject(e);
              try {
                  then.call(x, resolvePromise, rejectPromise);
              } catch(e) {
                  if (isCalled) {
                      return;
                  }
                  reject(e);
              }
          // 如果 then 不是函数（包括没有then的情况），以 x 为参数执行resolve(x);
          } else {
              resolve(x);
          }
          return;
      }
      // 如果 x 不为对象或者函数，以 x 为参数执行resolve(x);
      resolve(x);
  }
  then(onFulfilled, onRejected) {
      const promise = new MyPromise((resolveNext, rejectedNext) => {
          const fulfilledHandle = (value) => {
              queueMicrotask(() => {
                  if (!isFunction(onFulfilled)) {
                      resolveNext(value);
                  } else {
                      try {
                          const res = onFulfilled(value);
                          // 执行promise的解决过程
                          this._promiseResolve(promise, res, resolveNext, rejectedNext);
                      } catch(err) {
                          rejectedNext(err);
                      }
                  }
              });
              
          };
          const rejectedHandle = (reason) => {
              queueMicrotask(() => {
                  if (!isFunction(onRejected)) {
                      rejectedNext(reason);
                  } else {
                      try {
                          const res = onRejected(reason);
                          // 执行promise的解决过程
                          this._promiseResolve(promise, res, resolveNext, rejectedNext);
                      } catch(err) {
                          rejectedNext(err);
                      }
                  }
              });
          };

          switch(this._status) {
              // 状态为"PENDING'时，将任务加入到队列中等待promise的状态改变时执行
              case 'PENDING':
                  this._fulfilledQueue.push(fulfilledHandle);
                  this._rejectedQueue.push(rejectedHandle);
                  break;
              case 'FULFILLED':
                  fulfilledHandle(this._value);
                  break;
              case 'REJECTED':
                  rejectedHandle(this._value);
                  break;
              default:
          }
      });
      return promise;
  }
  catch(onRejected) {
      return this.then(undefined, onRejected);
  }
  // finally返回的新promise的状态取决于调用finally的promise的状态
  // finally方法总是会返回原来的值
  // 如果cb返回的是一个promise， 会等待该promise的状态改变
  finally(cb) {
      return this.then(
          (value) => MyPromise.resolve(cb()).then(() => value),
          (err) => MyPromise.resolve(cb()).then(() => { throw err })
      );
  }
  static resolve(p) {
      if (p instanceof MyPromise) {
          return p;
      }
      return new MyPromise((resolve) => {
          resolve(p);
      });
  }
  // MyPromise.reject()方法的参数，会原封不动地作为reject的理由, 不会处理传入promise的情况
  static reject(p) {
      return new MyPromise((resolve, reject) => {
          reject(p);
      });
  }
  // 如果不是传入的数组某一项不是MyPromise实例，就会先调用MyPromise.resolve()方法，将参数转为MyPromise实例，再进一步处理
  static all(promiseList) {
      return new MyPromise((resolve, reject) => {
          let list;
          // 如果promiseList不是iterator，会报错，直接reject
          try {
              list = [...promiseList];   
          } catch(err) {
              reject(new TypeError(`${promiseList} is not iterable (cannot read property Symbol(Symbol.iterator))`));
              return;
          }

          const len = list.length;
          // promiseList为空数组，resolve
          if (len === 0) {
               resolve([]);
          }
          
          let fulfilledCount = 0;
          const res = [];
          for (const [i, p] of list.entries()) {
              MyPromise.resolve(p)
                  .then((value) => {
                      res[i] = value;
                      fulfilledCount++;
                      if (fulfilledCount === len) {
                          resolve(res);
                      }
                  }, (err) => {
                      reject(err);
                  });
          }
      });
  }
  // 如果不是传入的数组某一项不是MyPromise实例，就会先调用MyPromise.resolve()方法，将参数转为MyPromise实例，再进一步处理
  static race(promiseList) {
      return new MyPromise((resolve, reject) => {
          let list;
          // 如果promiseList不是iterator，会报错，直接reject
          try {
              list = [...promiseList];   
          } catch(err) {
              reject(new TypeError(`${promiseList} is not iterable (cannot read property Symbol(Symbol.iterator))`));
              return;
          }
          // 会等待第一个改变状态的promise，如果promiseList为空数组，则会一直是pending状态
          for (const p of list) {
              MyPromise.resolve(p)
                  .then((value) => {
                      resolve(value);
                  }, (err) => {
                      reject(err);
                  });
          }
      });
  }
  // MyPromise.allSettled()方法接受一组Promise实例作为参数，f返回一个新的Promise实例，且新实例的状态只可能变成fulfilled
  // 只有等到所有这些参数实例都返回结果，不管是fulfilled还是rejected，包装实例才会结束。该方法由 ES2020 引入。
  /** 返回新的promise的结果
   * [
      { status: 'fulfilled', value: 42 },
      { status: 'rejected', reason: -1 }
      ]
   */
  static allSettled(promiseList) {
      return new MyPromise((resolve, reject) => {
          let list;
          // 如果promiseList不是iterator，会报错，直接reject
          try {
              list = [...promiseList];   
          } catch(err) {
              reject(new TypeError(`${promiseList} is not iterable (cannot read property Symbol(Symbol.iterator))`));
              return;
          }

          let unsettledCount = list.length;
          // promiseList为空数组，resolve
          if (unsettledCount === 0) {
               resolve([]);
          }
          
          const res = [];
          for (const [i, p] of list.entries()) {
              MyPromise.resolve(p)
                  .then(value => {
                      res[i] = {status: 'fulfilled', value};
                  }, reason => {
                      res[i] = {status: 'rejected', reason};
                  }).finally(() => {
                      unsettledCount--;
                      if (unsettledCount === 0) {
                          resolve(res);
                      }
                  });
          }
      });
  }
  // 与Promise.all相反，如果有一个为fulfilled，返回的新promise就是fulfilled，否则就是rejected
  // 数组为空或者所有promise都是rejected状态，返回一个AggregateError：new AggregateError(errors, 'All promises were rejected')
  // errors数组保存每个失败的原因，如果数组为空，则errors为空
  static any(promiseList) {
      return new MyPromise((resolve, reject) => {
          let list;
          // 如果promiseList不是iterator，会报错，直接reject
          try {
              list = [...promiseList];   
          } catch(err) {
              reject(new TypeError(`${promiseList} is not iterable (cannot read property Symbol(Symbol.iterator))`));
              return;
          }

          const len = list.length;
          const errors = [];
          // promiseList为空数组，表示没有一个promise会是fulfilled状态，所以结果为rejected
          if (len === 0) {
              reject(new AggregateError(errors, 'All promises were rejected'));
          }
          let rejectedCount = 0;

          for (const [i, p] of list.entries()) {
              MyPromise.resolve(p)
                  .then(
                      value => {
                          resolve(value);
                      },
                      err => {
                          errors[i] = err;
                          rejectedCount++;
                          if (rejectedCount === len) {
                             reject(new AggregateError(errors, 'All promises were rejected'));
                          }
                      }
                  );
          }
      });
  }
}

// 测试代码
// MyPromise.deferred = function() {
//     var result = {};
//     result.promise = new MyPromise(function(resolve, reject){
//       result.resolve = resolve;
//       result.reject = reject;
//     });

//     return result;
// }


// var promisesAplusTests = require("promises-aplus-tests");
// const { reject } = require("underscore");

// promisesAplusTests(MyPromise, function (err) {
//     console.log(err);
//     // All done; output is in the console. Or check `err` for number of failures.
// });


// 链接：https://juejin.cn/post/7112639843871490061/
