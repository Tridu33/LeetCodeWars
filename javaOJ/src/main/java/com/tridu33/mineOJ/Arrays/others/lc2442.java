package com.tridu33.mineOJ.Arrays.others;


/* 题目

示例 1：

输入：nums = [1,13,10,12,31]
输出：6
解释：反转每个数字后，结果数组是 [1,13,10,12,31,1,31,1,21,13] 。
反转后得到的数字添加到数组的末尾并按斜体加粗表示。注意对于整数 10 ，反转之后会变成 01 ，即 1 。
数组中不同整数的数目为 6（数字 1、10、12、13、21 和 31）。
示例 2：

输入：nums = [2,2,2]
输出：1
解释：反转每个数字后，结果数组是 [2,2,2,2,2,2] 。
数组中不同整数的数目为 1（数字 2）。
*/

 import java.lang.*;
 import java.util.*;

 public class lc2442 {
     public static void main(String[] args) {
         Solution sol = new lc2442().new Solution();
         System.out.println(sol.countDistinctIntegers(new int[]{1, 13, 10, 12, 31}));
     }

class Solution {
    private int getReverse(int x) {
        int y = 0;
        for (int i = x; i > 0; i /= 10) {
            y = y * 10 + i % 10;
        }
        return y;
    }

    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        for (int x : nums) {
            set.add(getReverse(x));
        }
        return set.size();
    }
}
 }