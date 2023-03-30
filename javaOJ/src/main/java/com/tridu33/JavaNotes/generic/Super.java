package com.tridu33.JavaNotes.generic;

import java.util.ArrayList;
import java.util.List;

public class Super {
    public static void main(String[] args) {
        List<? super Integer> foo3 = new ArrayList<Integer>();// Integer是super class
        foo3.add(Integer.valueOf(1));
        List<? super Integer> foo4 = new ArrayList<Number>();// Integer是super class
        List<? super Integer> foo5 = new ArrayList<Object>();// Integer是super class
//        foo5.add(new Object());// wrong
        Object obj = foo3.get(0);
//        Integer integer = foo3.get(0);//wrong
        System.out.println((Integer)obj);
    }
}
