package com.tridu33.mineOJ.Simulation;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc2679 {
    class Solution {
        public int matrixSum(int[][] nums) {
            int res = 0;
            if (nums.length <= 0 || nums[0].length <= 0) {
                return 0;
            }
            for (int i = 0; i < nums.length; i++) {
                Arrays.sort(nums[i]);
            }
            for (int j = 0; j < nums[0].length; j++) {
                int largestCurLine = Integer.MIN_VALUE;
                for (int i = 0; i < nums.length; i++) {
                    largestCurLine = Math.max(nums[i][j], largestCurLine);
                }
                res += largestCurLine;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc2679().new Solution();
        System.out.println(sol.matrixSum(new int[][]
                {{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}}));
    }

}
