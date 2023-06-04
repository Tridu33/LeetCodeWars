package com.tridu33.mineOJ.BitsOperator;


import java.lang.*;
import java.util.*;

/* @Desc:


 */

public class lc137 {

    public static void main(String[] args) {
        Solution sol = new lc137().new Solution();
        System.out.println(sol.singleNumber(new int[]{1, 1, 1, 3}));
    }

    class Solution {
        public int singleNumber(int[] nums) {
            int[] cnt = new int[32];
            for (int x :
                    nums) {
                for (int i = 0; i < 32; i++) {
                    if (((x >> i) & 1) == 1) {
                        cnt[i]++;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < 32; i++) {
                if (((cnt[i] % 3 & 1) == 1)) {
                    res += (1 << i);
                }
            }
            return res;
        }
    }
}


