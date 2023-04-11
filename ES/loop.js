function  continueLoop() {

    let i, j;
    loop1:
    for (i = 0; i < 3; i++) {      
        loop2:
        for (j = 0; j < 3; j++) {   
            if (i == 1 && j == 1) {
                continue loop1;
            }
            console.log("i = " + i + ", j = " + j);
        }
    }

}
function breakLoop() { 
    let i, j;

    loop1:
    for (i = 0; i < 3; i++) {      
        loop2:
        for (j = 0; j < 3; j++) {   
            if (i == 1 && j == 1) {
                break loop1;
            }
            console.log("i = " + i + ", j = " + j);
        }
    }

}
function while2loop() {
    const MAX = 3;

    console.log("for");
    for (let i = 0;i<MAX ;i++) { 
        console.log(i)
    };

    console.log("while");
    let j = 0;
    do {
        console.log(j);
        j++;
    } while (j < MAX);
 
    console.log("loop");
    let k = 0;
    loop:
    do {
        console.log(k);
        k++;
        if (k >= MAX) {
            break loop;
        }
        // else { continue loop}
    } while (true);
};
// fib CPS style CPS变换与CPS变换编译 - 梨梨喵的文章 - 知乎 https://zhuanlan.zhihu.com/p/22721931
const output = (input) => { 
    console.log(input);
};
const fib = (n) => { //direct style 的 A-Normal Form
    if (n <= 1) { return 1; }
    else {
        return fib(n-1) + fib(n-2);
    }
}
const fibCPS0 = (n, continuation) => {
    //A-Normalize 的过程等价于 CPS convert->Beta normalize->un-CPS convert，请参考 The Essence of Compiling with Continuation。
    //CPS 同 Static Single Assignment 也是同构的
    // 把『执行完一个函数之后要执行的代码』（称作「执行那个函数」这一动作的Continuation）封装成为一个函数k（k一般把该函数内部计算出的一些值作为参数），作为那个函数的参数进行传递。
    // 于是，就可以在那个函数体内，在执行完原有的动作之后，用函数内部新近计算好的相应的值作为参数，调用传进去的这个Continuation函数k，从而把所有过程的执行串联成一条线。
    if (n <= 1) { continuation(1); }
    else {
        fibCPS(
            n - 1,
            (v0) => {
                fibCPS(
                    n - 2,
                    (v1) => {
                        continuation(v0+v1);
                    }
                )
            }
        );
    }
}
const fibCPS = (n, continuation) => {
    console.log("fibCPS, n = ", n);
    console.log("outerContinuation = ", continuation.toString());
    if (n <= 1) { continuation(1); }
    else {
        const c1 = (v0) => {
            const c2 = (v1) => {
                console.log("innerContinuation = ",continuation.toString());
                console.log("v0+v1 = ",v0, "+", v1);
                continuation(v0 + v1);
            };
            fibCPS(
                n - 2,
                c2
            );
        };
        fibCPS(
            n - 1,
            c1
        );
    }
}
//CPS变换与CPS变换编译 - 梨梨喵的文章 - 知乎
// https://zhuanlan.zhihu.com/p/22721931



//===========================================================
const loop2unloop = () => { 
    ;
}














const main = () => {
    // breakLoop();
    // continueLoop();
    // while2loop();
    // console.log("")
    
    // console.log("怎样理解 Continuation-passing style? - https://www.zhihu.com/question/20259086/answer/141162748")//
    //CPS 就是把用于经典逻辑和直觉逻辑间命题转换的 Gödel–Gentzen 转换，经 Curry–Howard correspondence 应用到证明过程表示的自然结果，有什么难理解的？！
    // output(fib(3));// [1,1,2,3,5,8,13,21,34]
    // fibCPS(3, output);
    //为什么用cps：惰性求值、异步、流程控制......
    //续延传递变换可以将递归过程所用的栈空间转换为存储递归过程的堆空间
    //比如Promise, 协程，编译原理中间代码，纯函数编程
    // console.log("CPST(Continuation Passing Style Translator)")
    // console.log("是否所有的循环都能用递归代替？https://www.zhihu.com/question/29373492/answer/2963435728")
    





}
main();