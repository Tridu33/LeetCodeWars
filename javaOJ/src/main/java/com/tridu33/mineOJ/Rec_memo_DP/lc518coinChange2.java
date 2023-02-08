package com.tridu33.mineOJ.Rec_memo_DP;

/**
 * @Date 2/8/2023.
 */

import java.lang.*;
import java.util.*;
/* @Desc:
示例 1：

输入：amount = 5, coins = [1, 2, 5]
输出：4
解释：有四种方式可以凑成总金额：
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
示例 2：

输入：amount = 3, coins = [2]
输出：0
解释：只用面额 2 的硬币不能凑成总金额 3 。
示例 3：

输入：amount = 10, coins = [10]
输出：1

 */
public class lc518coinChange2 {
    public static void main(String[] args) {
        Solution sol = new lc518coinChange2().new Solution();
        System.out.println(sol.change(10,new int[] {10}));
    }
    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }
    }



}

