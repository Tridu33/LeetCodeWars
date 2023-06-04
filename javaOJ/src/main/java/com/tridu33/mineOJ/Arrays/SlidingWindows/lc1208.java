package com.tridu33.mineOJ.Arrays.SlidingWindows;


import java.lang.*;
import java.util.*;

/* @Desc:


 */

public class lc1208 {
    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int costSum = 0, len = s.length(), l = 0, res = Integer.MIN_VALUE;
            // 最长字串变体
            for (int r = 0; r < len; ) {
                costSum += Math.abs(s.charAt(r) - t.charAt(r));
                while (costSum > maxCost) {
                    costSum -= Math.abs(s.charAt(l) - t.charAt(l));
                    l++;
                }
                res = Math.max(res, r - l + 1);
                r++;
            }
            return res == Integer.MIN_VALUE ? 0 : res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc1208().new Solution();
        System.out.println(sol.equalSubstring("abca", "zcdz", 2));
    }
}
