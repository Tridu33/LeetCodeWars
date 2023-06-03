package com.tridu33.mineOJ.Arrays.monoStack;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;


public class lc496 {
    class Solution {
        public int[] nextGreaterElementValue(int[] nums2) {
            int[] res = new int[nums2.length];
            Deque<Integer> stk = new ArrayDeque<>();
            for (int i = nums2.length - 1; i >= 0; i--) {
                while (!stk.isEmpty() && stk.peek() <= nums2[i]) {
                    stk.pop();
                }
                res[i] = stk.isEmpty() ? -1 : stk.peek();
                stk.push(nums2[i]);//存值
            }
            return res;
        }

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int[] nextGreaterNumberValue4nums2 = nextGreaterElementValue(nums2);
            int[] res = new int[m];
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums2.length; i++) {
                map.put(nums2[i], i);
            }
            for (int i = 0; i < nums1.length; i++) {
                int idx = map.get(nums1[i]);
                res[i] = nextGreaterNumberValue4nums2[idx];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc496().new Solution();
        System.out.println(Arrays.toString(sol.nextGreaterElement(
                new int[]{2, 4}, new int[]{1, 2, 3, 4}
                //                new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}
        )));
    }
}
