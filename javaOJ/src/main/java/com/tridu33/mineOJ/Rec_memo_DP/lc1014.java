package com.tridu33.mineOJ.Rec_memo_DP;
/**
 * @Date 2/12/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:

示例 1：

输入：values = [8,1,5,2,6]
输出：11
解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
示例 2：

输入：values = [1,2]
输出：2
 */
public class lc1014 {
    public static void main(String[] args) {
        Solution sol = new lc1014().new Solution();
        System.out.println(sol.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int res = 0;

            return res;
        }
    }
}
