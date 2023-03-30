package com.tridu33.JavaNotes.generic;

import java.util.ArrayList;
import java.util.List;

//Lev 1
class Food{}
// Lev 2
class Fruit extends Food{}
class Meat extends Food{}
// Lev 3
class Apple extends Fruit{}
class Banana extends Fruit{}
class Pork extends Meat{}
class Beef extends Meat{}
// Lev 4
class RedApple extends Apple{}
class GreenApple extends Apple{}
class Plate<T>{
    private T item;
    public Plate(T t){item=t;}
    public void set(T t){item=t;}
    public T get(){return item;}
}
public class Extend {

    /*
    上界的list只能get，不能add（确切地说不能add出除null之外的对象，包括Object）（只能add null）
    下界的list只能add，不能get
    * */
    public static void main(String[] args) {
        Plate<? extends Fruit> p0=new Plate<Fruit>(new Fruit());// 实例化时类只能是T(Fruit)本身或它的子类
        Plate<? extends Fruit> p1=new Plate<Apple>(new Apple());// 实例化时类只能是T(Fruit)本身或它的子类
        //不能存入任何元素
        // 用extends上界 在变量赋值的时候就给它一个里面有东西的引用 比如构造函数初始化的时候就在里面放好东西
        List<? extends Fruit> list = new ArrayList<Fruit>(){{
            add(new Fruit()); // Fruit及其子类都可以放进去
            add(new Apple()); // Fruit及其子类都可以放进去
        }};
        List<? extends Fruit> list2= new ArrayList<Apple>(){{
//            add(new Fruit()); // 实例化时指定的T为Apple，放入Fruit对象会报错
            add(new Apple()); // Apple及其子类都可以放进去
        }};
//        p.set(new Fruit()); //Error
//        p.set(new Apple()); //Error
        // 读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit1=p1.get();
        Object newFruit2=p1.get();
//        Apple newFruit3=p1.get(); //Error

        Plate<? super Fruit> p2=new Plate<Fruit>(new Fruit());// 实例化时只能是T本身或它的父类
        List<? super Fruit> ls1 = new ArrayList<Fruit>(); // 可以
        List<? super Fruit> ls2 = new ArrayList<Food>(); // 可以
//        List<? super Fruit> ls3 = new ArrayList<Apple>();  // 报错
        //存入元素正常
        p2.set(new Fruit());
        p2.set(new Apple());
        // 读取出来的东西只能存放在Object类里。上界通配符get出来的对象默认是Object类型，可以做强制类型转换，可以add
//        Apple newFruit3=p2.get(); //Error
//        Fruit newFruit1=p2.get(); //Error
        Object newFruit22=p2.get();
        Fruit f = (Fruit)list2.get(0);
/*
上界 <? extend Fruit> ，表示所有继承Fruit的子类，但是具体是哪个子类，无法确定，所以调用add的时候，要add什么类型，谁也不知道。
但是get的时候，不管是什么子类，不管追溯多少辈，肯定有个父类是Fruit，所以，我都可以用最大的父类Fruit接着，也就是把所有的子类向上转型为Fruit。

下界 <? super Apple>，表示Apple的所有父类，包括Fruit，一直可以追溯到老祖宗Object 。那么当我add的时候，我不能add Apple的父类，
因为不能确定List里面存放的到底是哪个父类。但是我可以add Apple及其子类。
因为不管我的子类是什么类型，它都可以向上转型为Apple及其所有的父类甚至转型为Object 。
但是当我get的时候，Apple的父类这么多，我用什么接着呢，除了Object，其他的都接不住。

Java 泛型 <? super T> 中 super 怎么 理解？与 extends 有何不同？ - 胖君的回答 - 知乎
https://www.zhihu.com/question/20400700/answer/117464182
PECS（Producer Extends Consumer Super）原则：
- 频繁往外读取内容的，适合用上界Extends。
- 经常往里插入的，适合用下界Super。

所以，归根结底可以用一句话表示，那就是编译器可以支持向上转型，但不支持向下转型。
具体来讲，我可以把Apple对象赋值给Fruit的引用，
但是如果把Fruit对象赋值给Apple的引用就必须得用cast。
* */
        //上界
        List<? extends Fruit> flistTop = new ArrayList<Apple>();
        flistTop.add(null);
        //add Fruit对象会报错
        //flist.add(new Fruit());
        Fruit fruit1 = flistTop.get(0);

        //下界
        List<? super Apple> flistBottem = new ArrayList<Apple>();
        flistBottem.add(new Apple());
        //get Apple对象会报错
        //Apple apple = flistBottem.get(0);

        List <? super Fruit> appList = new ArrayList();
        appList.add(new Fruit());
        appList.add(new Apple());
        appList.add(new RedApple());
        // compile error
        // List <? extends Fruit> appList2 = new ArrayList();
        // appList2.add(new Fruit());
        // appList2.add(new Apple());
        // appList2.add(new RedApple());
    }
}
