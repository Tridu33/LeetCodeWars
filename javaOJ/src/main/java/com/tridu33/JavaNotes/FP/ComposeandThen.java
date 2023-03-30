package com.tridu33.JavaNotes.FP;

import java.util.Objects;
import java.util.function.IntUnaryOperator;

public class ComposeandThen {

    private static IntUnaryOperator mul ( int value){
        return (x) -> x * value;
    }

    private static IntUnaryOperator add ( int value){
        return (x) -> x + value;
    }
    public static final IntUnaryOperator mul4 = mul(4);

    public static final IntUnaryOperator add2 = add(2);
    public static void main(String[] args) {
        int val1 = mul4.compose(add2).applyAsInt(8);
        int val2 = add2.andThen(mul4).applyAsInt(8);

        System.out.println(val1);
        System.out.println(val2);


        Function<Integer, Integer> times2 = i -> i * 2;
        Function<Integer, Integer> squared = i -> i * i;

        System.out.println(times2.apply(4));

        System.out.println(squared.apply(4));

        //32                先4×4然后16×2,
        // 先执行apply(4)，在times2的apply(16),先执行参数，再执行调用者。
        System.out.println(times2.compose(squared).apply(4));

        //64               先4×2,然后8×8,
        // 先执行times2的函数，在执行squared的函数。
        System.out.println(times2.andThen(squared).apply(4));

        //16
        System.out.println(Function.identity().compose(squared).apply(4));

    }

}
