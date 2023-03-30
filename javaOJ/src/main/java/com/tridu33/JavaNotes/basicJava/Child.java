package com.tridu33.JavaNotes.basicJava;
class Base{
    public int id = 114;
    public void doSomething(){System.out.println("Base");}
}
public class Child extends Base{
    public int id = 514;
    @Override
    public void doSomething(){System.out.println("Child");}

    public static void main(String[] args) {
        Base base = new Child();
        System.out.println(base.id);
        base.doSomething();
    }
}
