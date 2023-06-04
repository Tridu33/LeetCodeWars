package com.tridu33.mineOJ.Arrays.others;


import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class LCP77 {
    class Solution {
        public int runeReserve(int[] runes) {
            Arrays.sort(runes);
            int ans = 1, cnt = 1;
            for (int i = 1; i < runes.length; i++) {
                if (runes[i] - runes[i - 1] > 1) {
                    cnt = 1;
                } else {
                    ++cnt;
                    ans = Math.max(ans, cnt);
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution sol = new LCP77().new Solution();
        System.out.println(sol.runeReserve(new int[]{1,3,5,4,1,7}));
    }

}
