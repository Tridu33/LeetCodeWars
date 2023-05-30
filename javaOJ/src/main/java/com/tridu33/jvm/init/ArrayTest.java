package com.tridu33.jvm.init;
class Const{
    static{
        System.out.println("初始化Const类");
    }
}

public class ArrayTest{
    public static void main(String[] args){
        Const[] con = new Const[5];
    }
}
