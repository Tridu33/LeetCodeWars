package com.tridu33.mineOJ.Arrays.TwoDivision;
/**
 * 
 */

import java.lang.*;
import java.util.*;

/* @Desc:

 */
public class lc704checkLess {
    public static void main(String[] args) {
        Solution sol = new lc704checkLess().new Solution();
        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    class Solution {
        // check是 nums[tryMid] < target， 用 [ooo,vxxx] 的模板
        private boolean checkLess(int tryMid, int[] nums, int target) {
            return nums[tryMid] < target;
        }

        public int search(int[] nums, int target) {
            // 选择其中一种写法即可
//            int i = closedLRInterval1(nums, target);
//            int i = closedLRInterval2(nums, target);
//            int i = closedLOpenRInterval(nums, target);
            int i = openLRInterval(nums, target);
            return i < nums.length && nums[i] == target ? i : -1;
        }

        // 闭区间写法 [left, right]
        private int closedLRInterval1(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;// 中间偏左  [left, mid-1]  [mid+1, right]
                if (checkLess(mid, nums, target))
                    left = mid + 1; // 范围缩小到 [mid+1, right]
                else
                    right = mid - 1; // 范围缩小到 [left, mid-1]
            }
            return left; // 或者 right+1
        }
        public int closedLRInterval2(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {//l==r时[l,r]跳出循环
                int mid = l + (r - l) / 2;
                if (checkLess(mid, nums, target)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }

        // 左闭右开区间 [left, right)
        private int closedLOpenRInterval(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) { // 区间不为空
                int mid = left + (right - left) / 2;
                if (checkLess(mid, nums, target))
                    left = mid + 1; // 范围缩小到 [mid+1, right)
                else
                    right = mid; // 范围缩小到 [left, mid)
            }
            return left; // 或者 right
        }

        // 开区间写法  (left, right)
        private int openLRInterval(int[] nums, int target) {
            int left = -1, right = nums.length;
            while (left + 1 < right) { // 区间不为空
                int mid = left + (right - left) / 2;
                if (checkLess(mid, nums, target))
                    left = mid; // 范围缩小到 (mid, right)
                else
                    right = mid; // 范围缩小到 (left, mid)
            }
            return right; // 或者 left+1
        }
    }
}

