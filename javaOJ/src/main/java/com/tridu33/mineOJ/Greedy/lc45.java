package com.tridu33.mineOJ.Greedy;
/**
 * 
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc45 {
    public static void main(String[] args) {
        Solution sol = new lc45().new Solution();
        System.out.println(sol.jump(new int[]{
                2, 3, 1, 1, 4
        }));
    }

    class Solution {
        public int jump(int[] nums) {
            int res = 0;
            int preMaxIdx = 0, curmaxIdx = 0;
            for (int j = 0; j < nums.length - 1; j++) {
                curmaxIdx = Math.max(nums[j] + j, curmaxIdx);
                if (preMaxIdx == j) {
                    preMaxIdx = curmaxIdx;
                    res++;
                }
            }
            return res;
        }
    }

}
