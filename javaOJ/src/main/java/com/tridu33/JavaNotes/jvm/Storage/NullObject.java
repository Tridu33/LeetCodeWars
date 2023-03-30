package com.tridu33.JavaNotes.jvm.Storage;

import org.openjdk.jol.info.ClassLayout;

public class NullObject {
    //一个Java对象究竟占多少内存空间?
    //https://zhuanlan.zhihu.com/p/393902077
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new NullObject()).toPrintable());
    }
    //12+4内存对齐
}