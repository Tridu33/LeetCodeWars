package com.tridu33.mineOJ.Arrays.TwoDivision;
/*

假设有一个总区间，经由我们的 check 函数判断后，可分成两部分，
这边以o作 true，.....作 false 示意较好识别

如果我们的目标是下面这个v，那麽就必须使用模板 1

................vooooooooo

假设经由 check 划分后，整个区间的属性与目标v如下，则我们必须使用模板 2

oooooooov...................

所以下次可以观察 check 属性再与模板1 or 2 互相搭配就不会写错啦

链接：https://www.acwing.com/blog/content/31/
* */
/* 题目

示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：

输入：nums = [1], target = 0
输出：-1
* */
 import java.lang.*;

public class lc33_2div {
     public static void main(String[] args) {
         Solution sol = new lc33_2div().new Solution();
         System.out.println(sol.search(new int[]{4,5,6,7,0,1,2}, 0));
     }
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}

 }

