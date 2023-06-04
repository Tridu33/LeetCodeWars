package com.tridu33.mineOJ.Greedy;
/*题目

 */

import java.lang.*;
import java.util.*;

public class flashlightRiverCross {
    class Solution {
        public int crossRiver(int[] t) {
            int n = t.length, res = 0;
            Arrays.sort(t);
            while (n > 3) {
                int cost = Math.min(2 * t[0] + t[n - 1] + t[n - 2], 2 * t[1] + t[n - 1] + t[0]);
                res += cost;
                System.out.println(cost);
                n -= 2;
            }
            if (n == 1) {
                res += t[0];
            } else if (n == 2) {
                res += t[1];
            } else {// n == 3
                res += t[2] + t[1] + t[0];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new flashlightRiverCross().new Solution();
        System.out.println(sol.crossRiver(new int[]{1, 2, 5, 10}));
        ;
    }
}
