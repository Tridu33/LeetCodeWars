package com.tridu33.mineOJ.Arrays;

import java.math.BigInteger;
/* 题目

示例 1：

输入：nums = [1,3,0,0,2,0,0,4]
输出：6
解释：
子数组 [0] 出现了 4 次。
子数组 [0,0] 出现了 2 次。
不存在长度大于 2 的全 0 子数组，所以我们返回 6 。
示例 2：

输入：nums = [0,0,0,2,0,0]
输出：9
解释：
子数组 [0] 出现了 5 次。
子数组 [0,0] 出现了 3 次。
子数组 [0,0,0] 出现了 1 次。
不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
示例 3：

输入：nums = [2,10,2019]
输出：0
解释：没有全 0 子数组，所以我们返回 0


难点在于cpp有long long怎么写都不越界，java long如果不用动态规划或者直接相加的方法，面对超长的0000字符串输入会越界。可以尝试BigInteger
* */

import java.lang.*;
import java.math.BigInteger;
import java.util.*;

public class lc2348 {
    public static void main(String[] args) {
        Solution sol = new lc2348().new Solution();
        System.out.println(sol.zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
    }

    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            BigInteger res = new BigInteger("0");
            int n = nums.length;
            BigInteger len0 = new BigInteger("0");
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0 && i != n - 1) {
                    len0 = len0.add(new BigInteger("1"));
                } else if (nums[i] == 0 && i == n - 1) {
                    len0 = len0.add(new BigInteger("1"));
                    res = res.add(len0.multiply(len0.add(new BigInteger("1"))).divide(new BigInteger("2")));
                    len0 = new BigInteger("0");
                } else if (nums[i] != 0 && !len0.equals(new BigInteger("0"))) {
                    res = res.add(len0.multiply(len0.add(new BigInteger("1"))).divide(new BigInteger("2")));
                    len0 = new BigInteger("0");
                }
            }
            return res.longValue();
        }
    }

    class Solution2 {
        public long zeroFilledSubarray(int[] nums) {
            long ans = 0;
            long tag = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    ans += tag;
                    tag++;
                } else {
                    tag = 1;
                }
            }
            return ans;
        }
    }

    class Solution3 {
        public long zeroFilledSubarray(int[] nums) {
            long ans = 0;
            long cur = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    cur++;
                } else {
                    cur = 0;
                }
                ans += cur;
            }
            return ans;
        }
    }
}
