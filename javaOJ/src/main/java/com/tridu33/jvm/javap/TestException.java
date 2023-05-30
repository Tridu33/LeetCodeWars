package com.tridu33.jvm.javap;

public class TestException {
    public TestException(){}

    public static void main(String[] args) {
        System.out.println("start");
        test();
        System.out.println("end");
    }
    private static void test(){
        throw new IllegalArgumentException("exception");
    }
}
