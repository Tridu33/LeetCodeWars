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

public class lc704dual4 {
    // 参考 https://www.acwing.com/blog/content/31/
    public static void main(String[] args) {
        lc704dual4.Solution1 sol = new lc704dual4().new Solution1();
        System.out.println(sol.search1(new int[]{-1, 0, 3, 5, 9, 12}, 5));
        System.out.println(sol.search2(new int[]{-1, 0, 3, 5, 9, 12}, 5));
        lc704dual4.Solution2 sol2 = new lc704dual4().new Solution2();
        System.out.println(sol2.search1(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(sol2.search2(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    // BinarySearch 都可以先实现 统一的[l,r], 然后 (l,r),[l,r),(l,r]。
    class Solution1 {// check不包含目标值v本身

        // [ooo,vxxx]分割[l,mid]在中间偏左，[mid+1,r]是右区间
        private boolean checkLess(int tryMid, int[] nums, int target) {
            return nums[tryMid] < target;
        }

        public int search1(int[] nums, int target) {
            int i = BinarySearch1(nums, target); // 选择其中一种开闭区间约定写法即可
            return i < nums.length && nums[i] == target ? i : -1;
        }

        public int BinarySearch1(int[] nums, int target) {
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

        // checkGeq [xxx,vooo] 和 checkLess对偶[ooo,vxxx],等价写法，二分类函数check的if-else刚好相反
        private boolean checkGeq(int tryMid, int[] nums, int target) {
            return nums[tryMid] >= target;
        }

        public int search2(int[] nums, int target) {
            int i = BinarySearch2(nums, target); // 选择其中一种开闭区间约定写法即可
            return i < nums.length && nums[i] == target ? i : -1;
        }

        public int BinarySearch2(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {//l==r时[l,r]跳出循环
                int mid = l + (r - l) / 2;//中间偏左
                if (checkGeq(mid, nums, target)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }

    class Solution2 {// check包含目标值v本身

        // [xxxv,ooo]，[l,mid-1]中间偏右是mid，即[mid,r]是右区间
        private boolean checkGreater(int tryMid, int[] nums, int target) {
            return nums[tryMid] > target;
        }

        public int search1(int[] nums, int target) {
            int i = BinarySearch1(nums, target); // 选择其中一种开闭区间约定写法即可
            return i < nums.length && nums[i] == target ? i : -1;
        }

        public int BinarySearch1(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + ((r - l + 1) >> 1);//中间偏右
                if (checkGreater(mid, nums, target)) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            return l;
        }

        // checkLeq [ooov,xxx]和 checkLess对偶[xxxv,ooo]
        private boolean checkLeq(int tryMid, int[] nums, int target) {
            return nums[tryMid] <= target;
        }

        public int search2(int[] nums, int target) {
            int i = BinarySearch2(nums, target); // 选择其中一种开闭区间约定写法即可
            return i < nums.length && nums[i] == target ? i : -1;
        }

        public int BinarySearch2(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + ((r - l + 1) >> 1);//中间偏右
                if (checkLeq(mid, nums, target)) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }
}