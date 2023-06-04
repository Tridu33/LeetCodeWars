package com.tridu33.mineOJ.Arrays.others;


import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc2576 {
    class Solution {
        public int maxNumOfMarkedIndices(int[] nums) {
            Arrays.sort(nums);
            int i = 0, n = nums.length;
            for (int j = (n + 1) / 2; j < n; ++j)
                if (nums[i] * 2 <= nums[j]){
                    ++i;
                }
            return i * 2;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc2576().new Solution();
        System.out.println(sol.maxNumOfMarkedIndices(new int[]
                {3,5,2,4}));
    }

}
