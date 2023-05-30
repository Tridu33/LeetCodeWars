package com.tridu33.jvm.Storage;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
class EachBasicTypeSize {
    //堆上分配
    private String name;
    //方法区分配
    private static int age;
    private int getPigWeight() {
        //栈上分配
        int wieght = 100;
        return wieght;
    }
}


//引用类型除对象本身之外，还有一个指向这个对象的指针，在64位虚拟机环境下，这个指针通常占用4个字节，因为默认开启了指针压缩，如果不开启指针压缩的话就占用8个字节。存储位置还是看下面代码吧。
class ReferenceSize {
    //'name'和它指向的对象都存储在堆上
    private String name = new String();
    //'color'和它所指向的对象都存储在方法区上
    private static String color = new String();
    private void show() {
        //temp则在栈上，它所指向的对象可能在堆上也可能在栈上
        String temp = new String();
        System.out.println(temp);
    }
}
public class TestNotNull {
    // 24=空12 + 4引用地址 + 4 + 4内存对齐
    // 40=(实际空对象nullObject由16字节)+24
    private NullObject nullObject=new NullObject();// 4字节 引用地址
    private int a;// 4字节
    //byte（占用1字节）
    //short（占用2字节）
    //int（占用4字节）
    //long（占用8字节）
    //float（占用4字节）
    //double（占用8字节）
    //char（占用2字节）
    //boolean（占用1字节）
    public static void main(String[] args) {
        //打印实例的内存布局
        System.out.println(ClassLayout.parseInstance(new TestNotNull()).toPrintable());
        //打印对象的所有相关内存占用
        System.out.println(GraphLayout.parseInstance(new TestNotNull()).toPrintable());
        //打印对象的所有内存结果并统计
        System.out.println(GraphLayout.parseInstance(new TestNotNull()).toFootprint());
    }
}