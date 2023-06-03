package com.tridu33.mineOJ.MapHash;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */

public class lc3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int res = Integer.MIN_VALUE, l = 0;
            Set<Character> set = new HashSet<>();
            for (int r = 0; r < s.length(); ) {
                while (set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(r));
                res = Math.max(res, r - l + 1);
                r++;
            }
            return res == Integer.MIN_VALUE ? 0 : res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc3().new Solution();
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
    }
}
