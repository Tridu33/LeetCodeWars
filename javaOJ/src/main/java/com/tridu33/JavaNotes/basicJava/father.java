package com.tridu33.JavaNotes.basicJava;

public class father {

    private String name;

    father(){
        System.out.println("--父类的无参构造函数--");
    }

    static{
        System.out.println("--父类的静态代码块--");
    }

    {
        System.out.println("--父类的非静态代码块--");
    }


    father(String name){
        this.name=name;
        System.out.println("--父类的有参构造函数--"+this.name);
    }
    public void speak(){
        System.out.println("--父类的方法--");
    }

    public static void main(String[] args) {
        //new一个类对象，类中各部分执行顺序：静态代码块—非静态代码块—构造函数—一般方法。
        System.out.println("--父类主程序--");
        father father=new father("父亲的名字");
        father.speak();
    }

}