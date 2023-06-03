package com.tridu33.funny.CPS;

class Test {

    public static long plus(int i1, int i2) {
        return i1 + i2;
    }
    public static void normal() {
        System.out.println(plus(1, 2));
    }
}

class TestCPS {
    interface Continuation {
        void next(int result);
    }
    public static void plus(int i1, int i2, Continuation continuation) {
        continuation.next(i1 + i2);
    }
    public static void CPSform() {
        //函数的结果通过回调来传递, 协程里通过在CPS的Continuation回调里结合状态机流转，来实现协程挂起-恢复的功能.
        Continuation continuationCallBackFunc = result -> System.out.println(result);
        plus(1, 2, continuationCallBackFunc);
    }
}

public class CPSStyple {
    public static void main(String[] args) {
        Test.normal();
        TestCPS.CPSform();
    }
}


///////////////////////////

class fib {
    public  static  int fib(int n){
        if(n==0){return 0;}
        else if(n==1){return 1;}
        else{
            return fib(n-1)+fib(n-2);
        }
    }
    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println();;
    }
}
class fibCPS {
    interface Continuation {
        void next(int result);
    }
    public static void fib(int n, Continuation continuation) {
        if(n==0){return ;}
        else if(n==1){return ;}
        else{
            continuation.next(n);
        }
    }
    public static void CPSform() {
        //函数的结果通过回调来传递, 协程里通过在CPS的Continuation回调里结合状态机流转，来实现协程挂起-恢复的功能.
        Continuation continuationCallBackFunc = result -> System.out.println(result);
        fib(3, continuationCallBackFunc);
    }
}
