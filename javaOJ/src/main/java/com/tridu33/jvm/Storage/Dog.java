package com.tridu33.jvm.Storage;

import org.openjdk.jol.info.ClassLayout;

public class Dog extends Animal {
    private String name;
    private Dog brother;
    private long createTime;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Dog.class).toPrintable());

    }
}