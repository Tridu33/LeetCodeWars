package com.tridu33.mineOJ.Arrays.SlidingWindows;

//https://leetcode.cn/problems/max-consecutive-ones-iii/solutions/608931/zui-da-lian-xu-1de-ge-shu-iii-by-leetcod-hw12/?orderBy=most_votes
import java.lang.*;


public class lc1004 {
    public static void main(String[] args) {
        Solution sol = new lc1004().new Solution();
        System.out.println(sol.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
        Solution2 sol2 = new lc1004().new Solution2();
        System.out.println(sol2.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
        Solution3 sol3 = new lc1004().new Solution3();
        System.out.println(sol3.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }


    class Solution2 {
        public int longestOnes(int[] nums, int k) {
            int res = 0, cnt = 0;// 窗口内1的计数
            for (int l = 0, r = 0; r < nums.length; ) {
                if (nums[r] == 1) {
                    ++cnt;
                }
                while ((r - l + 1) - cnt > k) {
                    if (nums[l++] == 1) {
                        --cnt;
                    }
                }
                res = Math.max(res, r - l + 1);
                ++r;
            }
            return res;
        }
    }

    class Solution {
        // 最长滑动窗口变体标准写法
        // 窗口内包含<=k个零的子串
        public int longestOnes(int[] nums, int k) {
            int cnt = 0, res = 0;
            // 计数区间内0的数量，窗口不能超出k个0
            for (int l = 0, r = 0; r < nums.length; ) {
                if (nums[r] == 0) {
                    cnt++;
                }
                while (cnt > k) {
                    if (nums[l] == 0) {
                        cnt--;
                    }
                    l++;
                }
                res = Math.max(res, r - l + 1);
                r++;
            }
            return res;
        }
    }

    class Solution3 {
        // 最长包含<=2个零的子串
        public int longestOnes(int[] nums, int k) {
            int n = nums.length;
            int left = 0, lsum = 0, rsum = 0;
            int ans = 0;
            for (int right = 0; right < n; ) {
                rsum += 1 - nums[right];
                while (lsum < rsum - k) {
                    lsum += 1 - nums[left];
                    ++left;
                }
                ans = Math.max(ans, right - left + 1);
                ++right;
            }
            return ans;
        }
    }
}

