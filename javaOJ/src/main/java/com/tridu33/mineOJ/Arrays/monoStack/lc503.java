package com.tridu33.mineOJ.Arrays.monoStack;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

public class lc503 {

    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Deque<Integer> stk = new ArrayDeque<>();
            for (int i = 2 * n - 1; i >= 0; i--) {
                while (!stk.isEmpty() && stk.peek() <= nums[i % n]) {
                    stk.pop();
                }
                res[i % n] = stk.isEmpty() ? -1 : stk.peek();
                stk.push(nums[i % n]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc503().new Solution();
        System.out.println(Arrays.toString(sol.nextGreaterElements(
                new int[]{1, 2, 3, 4, 3}
        )));
        ;
    }
}
