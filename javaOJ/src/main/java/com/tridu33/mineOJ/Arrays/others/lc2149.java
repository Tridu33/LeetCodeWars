package com.tridu33.mineOJ.Arrays.others;


/* 题目
示例 1：

输入：nums = [3,1,-2,-5,2,-4]
输出：[3,-2,1,-5,2,-4]
解释：
nums 中的正整数是 [3,1,2] ，负整数是 [-2,-5,-4] 。
重排的唯一可行方案是 [3,-2,1,-5,2,-4]，能满足所有条件。
像 [1,-2,2,-5,3,-4]、[3,1,2,-2,-5,-4]、[-2,3,-5,1,-4,2] 这样的其他方案是不正确的，因为不满足一个或者多个条件。
示例 2：

输入：nums = [-1,1]
输出：[1,-1]
解释：
1 是 nums 中唯一一个正整数，-1 是 nums 中唯一一个负整数。
所以 nums 重排为 [1,-1] 。

*/

 import java.lang.*;
 import java.util.*;

 public class lc2149 {
     public static void main(String[] args) {
         Solution sol = new lc2149().new Solution();
         System.out.println(Arrays.toString(sol.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
     }

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0, neg = 0;
        List<Integer> res = new ArrayList<>();
        int k = nums.length / 2;
        while (k-- > 0) {
            while (nums[pos] < 0) {
                pos++;
            }
            res.add(nums[pos++]);
            while (nums[neg] > 0) {
                neg++;
            }
            res.add(nums[neg++]);
        }
        return Arrays.stream(res.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }
}
     public int[] rearrangeArray2(int[] nums) {
         int n = nums.length;
         int pos = 0, neg = 0;
         List<Integer> res = new ArrayList<>();
         for (int i = 0; i + i < n; ++i) {
             while (nums[pos] < 0) {
                 ++pos;
             }
             res.add(nums[pos]);
             ++pos;
             while (nums[neg] > 0) {
                 ++neg;
             }
             res.add(nums[neg]);
             ++neg;
         }
         return Arrays.stream(res.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
     }
 }
