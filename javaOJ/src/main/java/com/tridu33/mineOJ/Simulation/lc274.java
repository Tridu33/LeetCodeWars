package com.tridu33.mineOJ.Simulation;
/* 题目

示例 1：

输入：citations = [3,0,6,1,5]
输出：3
解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
示例 2：

输入：citations = [1,3,1]
输出：1

* */

 import java.lang.*;
 import java.util.*;

 public class lc274 {
     public static void main(String[] args) {
         Solution sol = new lc274().new Solution();
         System.out.println(sol.hIndex(new int[]{3, 0, 6, 1, 5}));
         System.out.println(sol.hIndex(new int[]{1, 3, 1}));
         System.out.println(sol.hIndex(new int[]{0, 0, 0}));

     }

class Solution {

    public int hIndex(int[] citations) {
        int hFinal = 0;
        Integer nums[] = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            int h = i + 1;
            if (nums[i] >= h) {
                hFinal = h;
            }
        }
        return hFinal;
    }
}

 }
