package com.tridu33.mineOJ.Simulation;
/**
 * @Date 1/10/2023.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc1775 {
    public static void main(String[] args) {
        Solution sol = new lc1775().new Solution();
        int res = sol.minOperations(
                new int[]{6, 6},
                new int[]{1}
        );
        System.out.println(res);
    }

    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int sum1 = Arrays.stream(nums1).sum();
            int sum2 = Arrays.stream(nums2).sum();
            int[] bigger = nums1;
            int[] smaller = nums2;
            int bSum = sum1, sSum = sum2;
            if (sum2 >= sum1) {
                bigger = nums2;
                smaller = nums1;
                bSum = sum2;
                sSum = sum1;
            }
            int bLen = bigger.length;
            int sLen = smaller.length;
            Integer[] b2sDiff = new Integer[bLen];
            for (int i = 0; i < bLen; i++) {
                b2sDiff[i] = bigger[i] - 1;
            }
            Integer[] s2bDiff = new Integer[sLen];
            for (int i = 0; i < sLen; i++) {
                s2bDiff[i] = 6 - smaller[i];
            }
            Integer[] sbDiff = concatSB(b2sDiff, s2bDiff);
            Arrays.sort(sbDiff, (a, b) -> b - a);
            int originDiff = bSum - sSum;
            int sbSum = getSum(sbDiff);
            if (originDiff > sbSum) {
                return -1;
            }
            int cnt = 0;
            for (int i = 0; originDiff > 0 && i < sbDiff.length; i++) {
                originDiff -= sbDiff[i];
                cnt++;
            }
            return cnt;
        }

        private Integer[] concatSB(Integer[] b2sDiff, Integer[] s2bDiff) {
            Integer[] concat = new Integer[b2sDiff.length + s2bDiff.length];
            int idx = 0;
            for (int i = 0; i < b2sDiff.length; i++) {
                concat[idx++] = b2sDiff[i];
            }
            for (int i = 0; i < s2bDiff.length; i++) {
                concat[idx++] = s2bDiff[i];
            }
            return concat;
        }

        private int getSum(Integer[] array) {
            int sum = 0;
            for (Integer a :
                    array) {
                sum += a;
            }
            return sum;
        }
    }

}
