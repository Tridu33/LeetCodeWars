package com.tridu33.mineOJ.Arrays.others;

/* 题目

示例 1：

输入：arr = [2,3,4,7,11], k = 5
输出：9
解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
示例 2：

输入：arr = [1,2,3,4], k = 2
输出：6
解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
* */

import java.lang.*;

public class lc1539 {
    public static void main(String[] args) {
        Solution sol = new lc1539().new Solution();
        System.out.println(sol.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));

    }

    class Solution {
        public int findKthPositive(int[] arr, int k) {
            if (arr[0] > k) {
                return k;
            }

            int l = 0, r = arr.length;
            while (l < r) {
                int mid = (l + r) >> 1;
                int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
                if (x - mid - 1 >= k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
        }
    }


}
