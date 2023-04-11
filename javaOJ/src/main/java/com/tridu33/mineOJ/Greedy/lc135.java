package com.tridu33.mineOJ.Greedy;
/**
 * @Date 4/11/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc135 {
    public static void main(String[] args) {
        Solution sol = new lc135().new Solution();
        System.out.println(sol.candy(new int[]{
                1, 2, 2, 5, 4, 3, 2
        }));
    }

    class Solution {
        public int candy(int[] ratings) {
            int res = 0;
            int[] candies = new int[ratings.length];
            candies[0] = 1;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i - 1] < ratings[i]) {
                    candies[i] = candies[i - 1] + 1;
                } else {
                    candies[i] = 1;
                }
            }
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }
            res = Arrays.stream(candies).sum();
            return res;
        }
    }

}
