package com.tridu33.mineOJ.Rec_memo_DP;

/* 题目
示例 1：

输入：n = 8
输出：3
解释：8 -> 4 -> 2 -> 1
示例 2：

输入：n = 7
输出：4
解释：
   7 -> 8 -> 4 -> 2 -> 1
或 7 -> 6 -> 3 -> 2 -> 1
示例 3：

输入：n = 4
输出：2


* */

import java.lang.*;
import java.util.*;

public class lc397 {
    public static void main(String[] args) {
        Solution sol = new lc397().new Solution();
        System.out.println(sol.integerReplacement_rec(7));
        System.out.println(sol.integerReplacement(7));
    }

    class Solution {
        private Map<Integer, Integer> memo = new HashMap<>();

        public int integerReplacement(int n) {
            if (n == 1) {
                return 0;
            }
            if (!memo.containsKey(n)) {
                if (n % 2 == 0) {
                    memo.put(n, 1 + integerReplacement(n / 2));
                } else {
                    memo.put(n, 2 + Math.min(
                            integerReplacement(n / 2 + 1),
                            integerReplacement(n / 2)));
                }
            }
            return memo.get(n);
        }

        public int integerReplacement_rec(int n) {
            if (n == 1) {
                return 0;
            }
            if (n % 2 == 0) {
                return 1 + integerReplacement_rec(n / 2);
            }
            return 2 + Math.min(integerReplacement_rec(n / 2 + 1), integerReplacement_rec(n / 2));
        }

        public int integerReplacement_best(int n) {
            int ans = 0;
            while (n != 1) {
                if (n % 2 == 0) {
                    ++ans;
                    n /= 2;
                } else if (n % 4 == 1) {
                    ans += 2;
                    n /= 2;
                } else {
                    if (n == 3) {
                        ans += 2;
                        n = 1;
                    } else {
                        ans += 2;
                        n = n / 2 + 1;
                    }
                }
            }
            return ans;
        }

    }
}