package com.tridu33.jvm.init;

class Father{
    //静态成员属性的初始化早于静态代码块；
    //静态代码块是指的类的初始化操作，初始化早于对象的创建；
    //类静态域的只会初始化一次。
    public static int m = 33;
    static{
        System.out.println("父类被初始化");
    }
}

class Child extends Father{
    static{
        System.out.println("子类被初始化");
    }
}

class StaticTest{
    public static void main(String[] args){
        System.out.println(Child.m);
        System.out.println(new Child());
    }
}