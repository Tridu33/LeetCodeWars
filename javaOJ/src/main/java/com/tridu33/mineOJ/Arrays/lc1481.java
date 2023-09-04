package com.tridu33.mineOJ.Arrays;

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc1481 {
    class Solution {
        PriorityQueue<int[]> getPq(int[] arr) {
            Map<Integer, Integer> num2cnt = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                num2cnt.merge(arr[i], 1, Integer::sum);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> {
                        return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
                    }
            );
            for (Map.Entry<Integer, Integer> entry : num2cnt.entrySet()) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
            return pq;
        }

        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            if (k >= arr.length) {
                return 0;
            }
            PriorityQueue<int[]> pq = getPq(arr);
            while (k > 0) {
                int[] top = pq.peek();
                if (k - top[1] >= 0) {
                    k -= top[1];
                    pq.poll();
                } else {
                    top[1] = top[1] - k;
                    k = 0;
                }
            }
            return pq.size();
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc1481().new Solution();
        System.out.println(sol.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
    }

}
