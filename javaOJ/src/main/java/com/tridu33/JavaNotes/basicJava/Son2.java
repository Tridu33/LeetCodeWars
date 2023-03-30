package com.tridu33.JavaNotes.basicJava;
public class Son2 extends father{
    private String name;

    static{
        System.out.println("--子类的静态代码块--");
    }

    {
        System.out.println("--子类的非静态代码块--");
    }

    Son2(){
        System.out.println("--子类的无参构造函数--");
    }

    Son2(String name){
        this.name=name;
        System.out.println("--子类的有参构造函数--"+this.name);
    }

    @Override
    public void speak(){
        System.out.println("--子类Override了父类的方法--");
    }
    public static void main() {
        System.out.println("--子类主程序--");

        Son2 son=new Son2("儿子的名字");
        son.speak();

        father father=new father("父亲的名字");
        father.speak();

    }
}