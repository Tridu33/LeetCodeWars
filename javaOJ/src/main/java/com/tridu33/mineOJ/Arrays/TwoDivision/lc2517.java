package com.tridu33.mineOJ.Arrays.TwoDivision;

/* 题目

示例 1：

输入：price = [13,5,1,8,21,2], k = 3
输出：8
解释：选出价格分别为 [13,5,21] 的三类糖果。
礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
可以证明能够取得的最大甜蜜度就是 8 。
示例 2：

输入：price = [1,3,1], k = 2
输出：2
解释：选出价格分别为 [1,3] 的两类糖果。
礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
可以证明能够取得的最大甜蜜度就是 2 。
* */

 import java.lang.*;
 import java.util.*;

 public class lc2517 {
     public static void main(String[] args) {
         Solution sol = new lc2517().new Solution();
         System.out.println(sol.maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3));
     }

     class Solution2 {
         private boolean check(int mid, int k, int n, int[] price) {
             int cnt = 1, prev = price[0];
             for (int i = 1; i < n; ++i) {
                 if (price[i] - prev >= mid) {
                     ++cnt;
                     prev = price[i];
                 }
             }
             return cnt >= k;
         }

         public int maximumTastiness(int[] price, int k) {
             Arrays.sort(price);
             int l = 0, n = price.length, r = price[n - 1] - price[0], res = 0;
             while (l < r) {
                 int mid = l + r + 1 >> 1;
                 if (check(mid, k, n, price)) {
                     res = mid;
                     l = mid;
                 } else {
                     r = mid - 1;
                 }
             }
             return res;
         }
     }

class Solution {
    private boolean check(int mid, int k, int n, int[] price) {
        int cnt = 1, prev = price[0];
        for (int i = 1; i < n; ++i) {
            if (price[i] - prev >= mid) {
                ++cnt;
                prev = price[i];
            }
        }
        return cnt >= k;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int l = 0, n = price.length, r = price[n - 1] - price[0], res = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, k, n, price)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
 }