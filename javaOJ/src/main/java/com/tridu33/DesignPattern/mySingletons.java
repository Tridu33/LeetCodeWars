package com.tridu33.DesignPattern;
import java.lang.*;

public class mySingletons {
    public static void main(String[] args) {
        Foo1 foo1 = new Foo1();// 饱汉简单但是并发问题
        Foo2 foo2 = new Foo2();// 饱汉式 synchronized

        Foo3 foo3 = new Foo3();//  饿汉
        DoubleLockSingleton DoubleLockSingleton1 = new DoubleLockSingleton();
        //如果性能是关注的重点，双重检查加锁可以大幅减少getInstance()的时间消耗成本。

        enumSingleton s1 = enumSingleton.INSTANCE;
        enumSingleton s2 = enumSingleton.INSTANCE;
        System.out.println(s1==s2);// 最简单的枚举单例类

        Singletonenum2 s11 = Singletonenum2.SingletonEnum.SINGLETON.getInstance();
        Singletonenum2 s12 = Singletonenum2.SingletonEnum.SINGLETON.getInstance();
        System.out.println(s11==s12);// 默认防反射、防反序列化的枚举单例，该方法作为单例模式的最佳实现方法。

        ////////////////////////////////// 还有很多很多的写法

    }

    public static class Foo1{
        /*
        在多线程环境下，当有多个线程并行调用 getInstance()，都认为uniqueInstance为null的时候，
        就会调用uniqueInstance = new Singleton();，这样就会创建多个Singleton实例，无法保证单例。
        * */
        private static Foo1 uniqueInstance;//私有静态变量

        //私有的构造器。这样别处的代码无法通过调用该类的构造函数来实例化该类的对象，只能通过该类提供的静态方法来得到该类的唯一实例。
        private Foo1(){}

        //静态方法
        public static Foo1 getInstance(){
            //如果不存在，利用私有构造器产生一个Singleton实例并赋值到uniqueInstance静态变量中。
            //如果我们不需要这个实例，他就永远不会产生。这叫做“延迟实例化（懒加载）“
            if(uniqueInstance == null){
                uniqueInstance = new Foo1();
            }
            return uniqueInstance;
        }
    }

    public static class Foo2{
        private static Foo2 uniqueInstance;//私有静态变量

        //私有构造器
        private Foo2() {}

        //synchronized同步方法
        public static synchronized Foo2 getInstance(){
            if(uniqueInstance == null){
                uniqueInstance = new Foo2();
            }
            return uniqueInstance;
        }
    }

    public static class Foo3{
        //饿汉式：在静态初始化器中创建单例，保证了线程安全性
        private static Foo3 uniqueInstance = new Foo3();

        private Foo3() {}

        public static Foo3 getInstance(){
            return uniqueInstance;
        }
    }

    public static class DoubleLockSingleton{
        //使用volatile关键字，确保当uniqueInstance变量被初始化成为Singleton实例时，多线程可以正确地处理uniqueInstance变量。
        private volatile static DoubleLockSingleton uniqueInstance;

        private DoubleLockSingleton() {}

        public static DoubleLockSingleton getInstance() {
            if(uniqueInstance == null){//第一次检查
                synchronized(DoubleLockSingleton.class){
                    if(uniqueInstance == null){//第二次检查
                        uniqueInstance = new DoubleLockSingleton();
                    }
                }
            }
            return uniqueInstance;
        }

    }

    public enum enumSingleton {
        INSTANCE;
        public void businessMethod() {
            System.out.println("我是一个单例！");
        }
    }//使用枚举实现单例的方法虽然还没有广泛采用，但是单元素的枚举类型已经成为实现Singleton的最佳方法。注意：如果Singleton必须拓展一个超类，而不是扩展Enum的时候，则不宜使用这个方法。

    public static class Singletonenum2 {
        private Singletonenum2(){
        }
        public static enum SingletonEnum {
            SINGLETON;
            private Singletonenum2 instance = null;
            private SingletonEnum(){
                instance = new Singletonenum2();
            }
            public Singletonenum2 getInstance(){
                return instance;
            }
        }
    }


}

