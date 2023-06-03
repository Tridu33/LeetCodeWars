package com.tridu33.mineOJ.Arrays.others;


/* 题目
示例 1:

输入: nums = [1,2,3,4]
输出: [24,12,8,6]
示例 2:

输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]

* */

 import java.lang.*;
 import java.util.*;

 public class lc238 {
     public static void main(String[] args) {
         Solution sol = new lc238().new Solution();
         System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1, 2, 3, 4})));
     }

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }
}

 }