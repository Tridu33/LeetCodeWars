package com.tridu33.JavaNotes.ridiculous;
/**
 * @Date 5/7/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class CountPlusPlus {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            count = count ++;
        }
        System.out.println(count);
    }

}
