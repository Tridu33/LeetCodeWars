package com.tridu33.mineOJ.Arrays.LeftRight2Points;


import java.lang.*;
import java.util.*;

public class lc977 {
    class Solution {
        public int[] sortedSquares0(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            Arrays.sort(nums);
            return nums;
        }

        public int[] sortedSquares1(int[] nums) {
            Integer[] integerArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            Arrays.sort(integerArr, (a, b) -> {
                return Math.abs((int) a) - Math.abs((int) b);
            });
            nums = Arrays.stream(integerArr).mapToInt(Integer::valueOf).toArray();
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }

        public int[] sortedSquares2(int[] nums) {
            int n = nums.length;
            int negative = -1;
            for (int i = 0; i < n; ++i) {
                if (nums[i] < 0) {
                    negative = i;
                } else {
                    break;
                }
            }

            int[] ans = new int[n];
            int index = 0, i = negative, j = negative + 1;
            while (i >= 0 || j < n) {
                if (i < 0) {
                    ans[index] = nums[j] * nums[j];
                    ++j;
                } else if (j == n) {
                    ans[index] = nums[i] * nums[i];
                    --i;
                } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                    ans[index] = nums[i] * nums[i];
                    --i;
                } else {
                    ans[index] = nums[j] * nums[j];
                    ++j;
                }
                ++index;
            }

            return ans;
        }

        public int[] sortedSquares(int[] nums) {
            if (nums.length <= 0) {
                return nums;
            }
            int mid = 0, minAbs = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(nums[i]) < minAbs) {
                    minAbs = Math.abs(nums[i]);
                    mid = i;
                }
            }
            int l = mid, r = mid;
            int[] ret = new int[nums.length];
            ret[0] = nums[mid] * nums[mid];
            for (int i = 1; i < nums.length; i++) {
                if (l - 1 < 0 && r + 1 <= nums.length - 1) {
                    r++;
                    ret[i] = nums[r] * nums[r];
                    continue;
                }
                if (l - 1 >= 0 && r + 1 > nums.length - 1) {
                    l--;
                    ret[i] = nums[l] * nums[l];
                    continue;
                }
                if (Math.abs(nums[l - 1]) < Math.abs(nums[r + 1])) {
                    l--;
                    ret[i] = nums[l] * nums[l];
                } else {
                    r++;
                    ret[i] = nums[r] * nums[r];
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc977().new Solution();
        System.out.println(Arrays.toString(sol.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}