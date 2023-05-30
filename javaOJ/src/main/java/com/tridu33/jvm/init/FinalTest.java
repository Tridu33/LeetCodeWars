package com.tridu33.jvm.init;

class Const2{
    public static final String NAME = "我是常量";
    static{
        System.out.println("初始化Const类");
    }
}

public class FinalTest{
    public static void main(String[] args){
        System.out.println(Const2.NAME);
    }
}