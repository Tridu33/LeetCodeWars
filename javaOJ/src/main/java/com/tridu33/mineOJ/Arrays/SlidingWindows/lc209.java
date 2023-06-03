package com.tridu33.mineOJ.Arrays.SlidingWindows;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */

public class lc209 {
    //滑动窗口
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int res = Integer.MAX_VALUE, l = 0, sum = 0;
            for (int r = 0; r < nums.length; ) {
                sum += nums[r];
                while (sum >= target) {
                    sum -= nums[l];
                    res = Math.min(res, r - l + 1);
                    l++;
                }
                r++;
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc209().new Solution();
        System.out.println(sol.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
