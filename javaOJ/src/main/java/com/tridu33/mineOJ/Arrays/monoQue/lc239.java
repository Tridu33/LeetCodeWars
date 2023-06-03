package com.tridu33.mineOJ.Arrays.monoQue;


import java.util.*;

public class lc239 {
    class MonotonicQueue {
        // 这题可以用值也可以用下标
        Deque<Integer> q = new ArrayDeque<>();

        // <= big head  <= little tail
        public int maxHead() {
            return q.getFirst();
        }

        public void pop(int left) {
            if (!q.isEmpty() && q.peek() == left) {
                q.pollFirst();
            }
        }

        public void push(int right) {
            while (!q.isEmpty() && q.getLast() < right) {
                // 不排除等号，是因为窗口内部可以相等，区别于单调栈NextGreaterNumber排除等号
                q.pollLast();
            }
            q.offerLast(right);
        }
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            List<Integer> res = new ArrayList<>();
            MonotonicQueue windows = new MonotonicQueue();
            for (int i = 0; i <= k - 1 - 1; i++) {
                windows.push(nums[i]);
            }
            int left = 0;
            for (int right = k - 1; right <= len - 1; right++) {
                windows.push(nums[right]);
                res.add(windows.maxHead());
                windows.pop(nums[left++]);
            }
            int[] array = Arrays.stream(res.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
            return array;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc239().new Solution();
        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]
                {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
