package com.tridu33.mineOJ.Greedy;
/**
 * 
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc122 {
    public static void main(String[] args) {
        Solution sol = new lc122().new Solution();
        System.out.println(sol.maxProfit(new int[]{
                7,1,5,10,3,6,4
        }));
    }
    class Solution {
        public int maxProfit(int[] prices) {
            int res =0;
            for (int i = 1; i < prices.length; i++) {
                res += Math.max(0,prices[i] - prices[i-1]);
            }
            return res;
        }
    }

}
