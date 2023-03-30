package com.tridu33.JavaNotes.jvm.Storage;

import org.openjdk.jol.info.ClassLayout;
//一个Java对象到底占用多大内存
//https://zhuanlan.zhihu.com/p/222135897
public class Animal extends Object {
    private int size;
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
        System.out.println(ClassLayout.parseClass(Animal.class).toPrintable());
    }

}