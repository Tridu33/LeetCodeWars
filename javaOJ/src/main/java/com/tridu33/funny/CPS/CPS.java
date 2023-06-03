package com.tridu33.funny.CPS;
//是否所有的循环都能用递归代替？ - 酱紫君的回答 - 知乎
//https://www.zhihu.com/question/29373492/answer/2963435728
public class CPS {
    public static final int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
    public static void body(int in){
        System.out.print(in);
    }
    public static void main(String[] args) {
        System.out.println("");
        for2while();
        System.out.println("");
        while2loop();
    }

    public static void for2while() {
        for (int i = 1; i <5 ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j+"\t");
            }
            System.out.println();
        }
        System.out.println("-------->");
        //转换成while循环
        int i = 1;
        while (i < 5){
            int j =1;
            while (j <= i){
                System.out.print(j+"\t");
                j++;
            }
            System.out.println();
            i++;
        }
        System.out.println("");

    }
    public static void while2loop() {
        System.out.println("while");
        //转换成while循环
        int w = 0;
        while (w+1 < 10){
            w++;
            body(arr[w]);
        }
        System.out.println("\nloop");
        System.out.println("-------->");
        int i = 0;
        LOOP: do {
            i++;
            if (i>=10) {
                break LOOP;  //跳出LOOP循环
            }
            body(arr[i]);
        } while(true);
    }
}
