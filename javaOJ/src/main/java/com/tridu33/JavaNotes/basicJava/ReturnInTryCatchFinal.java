package com.tridu33.JavaNotes.basicJava;

import java.util.ArrayList;
import java.util.List;
/*
总结：https://www.cnblogs.com/pcheng/p/10968841.html

1、finally中的代码总会被执行。

2、当try、catch中有return时，也会执行finally。
return的时候，要注意返回值的类型，是否受到finally中代码的影响。

3、finally中有return时，会直接在finally中退出，导致try、catch中的return失效。

* */

public class ReturnInTryCatchFinal {
    public static void main(String[] args) {
        System.out.println(testReturn1());
        System.out.println(testReturn2().toString());
        System.out.println(testReturn3());
        System.out.println(testReturn3_5());
        System.out.println(testReturn4());
    }
    private static int testReturn1() {//基本类型
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }
    private static List<Integer> testReturn2() {//地址引用类型
        List<Integer> list = new ArrayList<>();
        try {
            list.add(1);
            System.out.println("try:" + list);
            return list;
        } catch (Exception e) {
            list.add(2);
            System.out.println("catch:" + list);
        } finally {
            list.add(3);
            System.out.println("finally:" + list);
        }
        return list;
    }
    private static int testReturn3() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            int x = i / 0 ;
            return 114;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
    }
    private static int testReturn3_5() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            int x = i / 0 ;
            return 114;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            return 514;//会覆盖try,catch中的return值
        }
    }
    private static int testReturn4() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            return 114514;//恶臭写法，编译器会给予警告，
            // 所以不推荐在finally中写return，这会破坏程序的完整性，
            // 一旦finally里出现异常，会导致catch中的异常被覆盖。
        }
    }
}
