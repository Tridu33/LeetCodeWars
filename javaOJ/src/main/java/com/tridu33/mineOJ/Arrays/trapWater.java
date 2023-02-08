package com.tridu33.mineOJ.Arrays;

import java.lang.*;
import java.util.*;
// https://www.bilibili.com/video/BV1Qg411q7ia/
// 单调栈，前后缀分解，双向双指针 的模板题
public class trapWater {
    public static void main(String[] args) {
        Solution sol = new trapWater().new Solution();
        System.out.println(sol.method(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    class Solution1 {
        public int method(int[] height) {
            int res = 0;
            for (int i = 1; i < height.length - 1; i++) {
                int leftMax = 0, rightMax = 0;
                ;
                for (int j = 0; j < i; j++) {
                    leftMax = Math.max(leftMax, height[j]);
                }
                for (int j = i + 1; j < height.length; j++) {
                    rightMax = Math.max(rightMax, height[j]);
                }
                if (Math.min(leftMax, rightMax) > height[i]) {
                    // 左右最大的最小都取不到自己
                    res += (Math.min(leftMax, rightMax) - height[i]);
                }
            }
            return res;
        }
    }

    class Solution3 {
        public int method(int[] height) {
            int res = 0;
            for (int i = 1; i < height.length - 1; i++) {
                int leftMax = 0, rightMax = 0;
                // 左右最大的最小都取得到自己
                for (int j = 0; j <= i; j++) {
                    leftMax = Math.max(leftMax, height[j]);
                }
                for (int j = i; j < height.length; j++) {
                    rightMax = Math.max(rightMax, height[j]);
                }
                // 包含的情况
                res += (Math.min(leftMax, rightMax) - height[i]);
            }
            return res;
        }
    }

    class Solution4 {
        public int method(int[] height) {
            int res = 0, len = height.length;
            int dp[][] = new int[2][len];
            dp[0][0] = height[0];// leftMax
            dp[1][len - 1] = height[len - 1];// rightMax
            // 这里左右最高均包含i自己的高度
            for (int i = 1; i < len; i++) {
                dp[0][i] = Math.max(height[i], dp[0][i - 1]);
            }// leftMax
            for (int i = len - 2; i >= 0; i--) {
                dp[1][i] = Math.max(height[i], dp[1][i + 1]);
            }// rightMax
            System.out.println(Arrays.deepToString(dp));
            for (int i = 1; i < len - 1; i++) {
                res += Math.min(dp[0][i], dp[1][i]) - height[i];
            }
            return res;
        }
    }

    class Solution2 {
        public int method(int[] height) {
            int len = height.length, res = 0, leftMax = 0, rightMax = 0, left = 0, right = len - 1;
            while (left <= right) {
                if (leftMax <= rightMax) {
                    leftMax = Math.max(leftMax, height[left]);
                    res += leftMax - height[left++];
                } else {// leftMax > rightMax
                    rightMax = Math.max(rightMax, height[right]);
                    res += rightMax - height[right--];
                }
            }
            return res;
        }
    }

    class Solution {
        public int method(int[] height) {
            int BottomIdx = 0, len = height.length, res = 0;
            Deque<Integer> stk = new ArrayDeque<>();
            for (int idx = 0; idx < len; idx++) {
                while (!stk.isEmpty() && height[idx] > height[stk.peek()]) {
                    BottomIdx = stk.pop();
                    while (!stk.isEmpty() && height[stk.peek()] == height[BottomIdx]) {
                        stk.pop();
                    }
                    if (!stk.isEmpty()) {
                        // stack.peek()是此次接住的雨水的左边界的位置，右边界是当前的柱体，即i。
                        // Math.min(height[stack.peek()], height[i]) 是左右柱子高度的min，减去height[bottomIdx]就是雨水的高度。
                        // i - stack.peek() - 1 是雨水的宽度。
                        res += (idx - stk.peek() - 1) * (Math.min(height[idx], height[stk.peek()]) - height[BottomIdx]);
                    }
                }
                stk.push(idx);
            }
            return res;
        }
    }
}

