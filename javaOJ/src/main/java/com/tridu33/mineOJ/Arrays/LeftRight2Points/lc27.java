package com.tridu33.mineOJ.Arrays.LeftRight2Points;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;

/* @Desc:


 */

public class lc27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int slow = 0;
            for (int fast = 0; fast < nums.length; fast++) {
                if (val != nums[fast]) {
                    nums[slow++] = nums[fast];
                }
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc27().new Solution();
        System.out.println(sol.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
