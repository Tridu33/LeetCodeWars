package com.tridu33.mineOJ.Greedy;
/**
 * @Date 4/11/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc134 {
    public static void main(String[] args) {
        Solution sol = new lc134().new Solution();
        System.out.println(sol.canCompleteCircuit(new int[]{
                1, 2, 3, 4, 5
        }, new int[]{
                3, 4, 5, 1, 2
        }));
    }

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int res = 0;
            int totalSum = 0, curSum = 0;
            for (int i = 0; i < gas.length; i++) {
                totalSum += gas[i] - cost[i];
                curSum += gas[i] - cost[i];
                if (curSum < 0) {
                    curSum = 0;
                    res = i + 1;
                }
            }
            if (totalSum < 0) {
                return -1;
            }
            return res;
        }
    }

}
