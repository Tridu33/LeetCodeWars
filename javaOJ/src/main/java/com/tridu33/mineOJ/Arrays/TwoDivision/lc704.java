package com.tridu33.mineOJ.Arrays.TwoDivision;


/* 题目
https://www.acwing.com/blog/content/31/ 二分法模板
示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1

* */

 import java.lang.*;

 public class lc704 {
     public static void main(String[] args) {
         Solution sol = new lc704().new Solution();
         System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));

     }

// 这题是寻找等于，所以两种模板都能使用，对应的check函数不同。

// 一，比如下面的check是 nums[tryMid] < target，则[ooo,v,xxx]寻找满足check区间[ooo,v]的最大右边界v 的模板
class Solution {
    private boolean check(int tryMid, int[] nums, int target) {
        return nums[tryMid] < target;
    }

    public int search(int[] nums, int target) {
        int i = Bound(nums, target); // 选择其中一种写法即可
        return i < nums.length && nums[i] == target ? i : -1;
    }

    // lowerBound 返回最小的满足 nums[i] >= target 的 i
    // 如果数组为空，或者所有数都 < target，则返回 nums.length
    // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]

    // 闭区间写法
    private int Bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 闭区间 [left, right]
        while (left <= right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right+1] >= target
            int mid = left + (right - left) / 2;
            if (check(mid, nums, target))
                left = mid + 1; // 范围缩小到 [mid+1, right]
            else
                right = mid - 1; // 范围缩小到 [left, mid-1]
        }
        return left; // 或者 right+1
    }

    private int Bound2(int[] nums, int target) {
        int left = 0, right = nums.length; // 左闭右开区间 [left, right)
        while (left < right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (check(mid, nums, target))
                left = mid + 1; // 范围缩小到 [mid+1, right)
            else
                right = mid; // 范围缩小到 [left, mid)
        }
        return left; // 或者 right
    }

    // 开区间写法
    private int Bound3(int[] nums, int target) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (check(mid, nums, target))
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right; // 或者 left+1
    }
}

// 二，比如下面的check是 nums[tryMid] > target，则[ooo,v,xxx]寻找 满足check区间[v,xxx]的最小左边界v 的模板，
// TODO:
class Solution2 {
    private boolean check(int tryMid, int[] nums, int target) {
        return nums[tryMid] > target;
    }

    public int search(int[] nums, int target) {
        int i = Bound(nums, target); // 选择其中一种写法即可
        return i < nums.length && nums[i] == target ? i : -1;
    }

    // lowerBound 返回最小的满足 nums[i] >= target 的 i
    // 如果数组为空，或者所有数都 < target，则返回 nums.length
    // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]

    // 闭区间写法
    private int Bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 闭区间 [left, right]
        while (left <= right) { // 区间不为空
            // 循环不变量：
            //
            //
            int mid = left + (right - left) / 2;
            if (check(mid, nums, target))
                ; // 范围缩小到 [ ]
            else
                ; // 范围缩小到 [ ]
        }
        return left; // 或者 right+1
    }

    // 左闭右开区间写法
    private int Bound2(int[] nums, int target) {
        int left = 0, right = nums.length; // 左闭右开区间 [left, right)
        while (left < right) { // 区间不为空
            // 循环不变量：
            //
            //
            int mid = left + (right - left) / 2;
            if (check(mid, nums, target))
                left = mid + 1; // 范围缩小到 [)
            else
                right = mid; // 范围缩小到 [)
        }
        return left; // 或者 right
    }

    // 开区间写法
    private int Bound3(int[] nums, int target) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            //
            //
            int mid = left + (right - left) / 2;
            if (check(mid, nums, target))
                left = mid; // 范围缩小到 ()
            else
                right = mid; // 范围缩小到 ()
        }
        return right; // 或者 left+1
    }
}


//    链接：https://leetcode.cn/problems/binary-search/solutions/2023397/er-fen-cha-zhao-zong-shi-xie-bu-dui-yi-g-eplk/
// TODO： 好像是模板2的左闭右开区间写法
//     private int Bound1(int[] nums, int target) {
//         int left = 0, right = nums.length; // 左闭右开区间 [left, right)
//         while (left < right) { // 区间不为空
//             // 循环不变量：
//             // nums[left-1] < target
//             // nums[right] >= target
//             int mid = left + (right - left) / 2;
//             if (check(mid, nums, target))
//                 left = mid + 1; // 范围缩小到 [mid+1, right)
//             else
//                 right = mid; // 范围缩小到 [left, mid)
//         }
//         return left; // 或者 right
//     }
 }