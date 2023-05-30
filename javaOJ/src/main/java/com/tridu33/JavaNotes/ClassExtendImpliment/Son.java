package com.tridu33.JavaNotes.ClassExtendImpliment;
public class Son extends father{
    private String name;

    static{
        System.out.println("--子类的静态代码块--");
    }

    {
        System.out.println("--子类的非静态代码块--");
    }

    Son(){
        System.out.println("--子类的无参构造函数--");
    }

    Son(String name){
        this.name=name;
        System.out.println("--子类的有参构造函数--"+this.name);
    }

    @Override
    public void speak(){
        System.out.println("--子类Override了父类的方法--");
    }

    public static void main(String[] args) {
        /*
        子类继承父类各部分执行顺序为：父静态代码块--子静态代码块--父非静态代码--父无参构造函数--子静态代码块--子构造函数--方法。
        注意：
        创建子类对象调用子类的构造方法的时候,会先调用父类的构造方法，
        在子类的构造方法中调用父类的构造方法是用super()，
        如果没有写super()，则默认调用父类的无参构造方法。
        * */
        System.out.println("--子类主程序--");

        Son son=new Son("儿子的名字");
        son.speak();
    }

}