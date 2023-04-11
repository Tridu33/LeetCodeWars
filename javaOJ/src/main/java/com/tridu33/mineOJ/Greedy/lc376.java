package com.tridu33.mineOJ.Greedy;
/**
 * @Date 4/11/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc376 {
    public static void main(String[] args) {
        Solution sol = new lc376().new Solution();
        System.out.println(sol.wiggleMaxLength(new int[]{
                1,17,5,10,13,15,10,5,16,8
        }));
    }

    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int segment = 0;
            int preDiff = 0, curDiff = 0;
            for (int i = 1; i < nums.length; i++) {
                curDiff = nums[i] - nums[i - 1];
                if (curDiff > 0 && preDiff <= 0 ||
                        curDiff < 0 && preDiff >= 0) {
                    segment++;
                    preDiff = curDiff;
                }
            }
            return segment + 1;
        }
    }

}
