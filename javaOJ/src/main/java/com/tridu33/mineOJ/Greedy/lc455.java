package com.tridu33.mineOJ.Greedy;
/**
 * 
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc455 {
    public static void main(String[] args) {
        Solution sol = new lc455().new Solution();
        System.out.println(sol.findContentChildren(
                new int[]{1, 2}, new int[]{1, 2, 3})
        );
    }

    class Solution {
        public int findContentChildren0(int[] g, int[] s) {
            int res = 0;
            int idx4s = s.length - 1;
            Arrays.sort(g);
            Arrays.sort(s);
            for (int i = g.length - 1; i >= 0; i--) {
                if (idx4s >= 0 && s[idx4s] >= g[i]) {
                    idx4s--;
                    res++;
                }
            }
            return res;
        }
        public int findContentChildren(int[] g, int[] s) {
            int res = 0;
            int idx4g = 0;
            Arrays.sort(g);
            Arrays.sort(s);
            for (int i = 0; i < s.length; i++) {
                if (idx4g < g.length && s[i] >= g[idx4g] ) {
                    res++;
                    idx4g++;
                }
            }
            return res;
        }
    }

}
