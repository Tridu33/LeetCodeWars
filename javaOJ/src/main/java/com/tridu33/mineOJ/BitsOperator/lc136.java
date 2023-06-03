package com.tridu33.mineOJ.BitsOperator;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc136 {

    public static void main(String[] args) {
        Solution sol = new lc136().new Solution();
        System.out.println(sol.singleNumber(new int[]{2, 2, 1}));
    }

    class Solution {
        public int singleNumber(int[] nums) {
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                res = res ^ nums[i];
            }
            return res;
        }
    }
}