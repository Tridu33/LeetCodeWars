package com.tridu33.JavaNotes.jvm.Storage;

import org.openjdk.jol.info.ClassLayout;

class Animal2 extends Object {
    private int size;
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
        System.out.println(ClassLayout.parseClass(Animal.class).toPrintable());
    }

}
public class DogGC extends Animal2 {
    private String name;
    private DogGC brother;
    private long createTime;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            newDog();
        }
        System.out.println("消耗时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private static void newDog() {
        new DogGC();
    }
}