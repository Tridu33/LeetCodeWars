package com.tridu33.mineOJ.Arrays.PriorityDeQue;

/*题目

示例 1：

输入：nums = [10,10,10,10,10], k = 5
输出：50
解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
示例 2：

输入：nums = [1,10,3,3,3], k = 3
输出：17
解释：可以执行下述操作：
第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
第 2 步操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
第 3 步操作：选中 i = 2 ，nums 变为 [1,1,1,3,3] 。分数增加 3 。
最后分数是 10 + 4 + 3 = 17 。
*/

 import java.lang.*;
 import java.util.*;

 public class lc2530 {
     public static void main(String[] args) {
         Solution sol = new lc2530().new Solution();
         System.out.println(sol.maxKelements(new int[]{10, 10, 10, 10, 10}, 5));
     }

class Solution {
    public long maxKelements(int[] nums, int k) {
        long res = 0L;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (Integer n : nums) {
            q.offer(n);
        }
        while (k-- > 0) {
            Integer curMax = q.poll();
            res += curMax;
            q.offer((curMax + 3 - 1) / 3);
        }
        return res;
    }
}

 }

