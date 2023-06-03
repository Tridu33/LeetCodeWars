package com.tridu33.mineOJ.BitsOperator;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
 public class lc260 {
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        // xorsum != 0,is 'x1 xor x2'
        int xorSum = 0;
        for (int x :
                nums) {
            xorSum = xorSum ^ x;
        }
        int mask = (xorSum == Integer.MIN_VALUE) ? xorSum :
                xorSum & (-xorSum);// 负数=反码+1=补码，找出最右的1，第mask位1
        int type1 = 0, type2 = 0;
        for (int x : nums) {
            if ((x & mask) != 0) {//第mask位为1，不是零
                type1 ^= x;
            } else {
                type2 ^= x;
            }
        }
        return new int[]{type1, type2};
    }
}

     public static void main(String[] args) {
         Solution sol = new lc260().new Solution();
         System.out.println(Arrays.toString(sol.singleNumber(new int[]{-1,0})));
     }
 }