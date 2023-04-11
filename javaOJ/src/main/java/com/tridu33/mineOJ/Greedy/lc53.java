package com.tridu33.mineOJ.Greedy;
/**
 * @Date 4/11/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc53 {
    public static void main(String[] args) {
        Solution sol = new lc53().new Solution();
        System.out.println(sol.maxSubArray(new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int res = Integer.MIN_VALUE;
            int reducer = 0;
            for (int r = 0; r < nums.length; r++) {
                reducer += nums[r];
                if (reducer > res) {
                    res = reducer;
                }
                if (reducer < 0) {
                    reducer = 0;
                }
            }
            return res;
        }
    }

}
