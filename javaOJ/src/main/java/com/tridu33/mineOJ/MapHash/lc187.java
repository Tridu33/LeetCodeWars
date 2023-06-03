package com.tridu33.mineOJ.MapHash;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */

public class lc187 {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res = new ArrayList<String>();
            Map<String, Integer> cnt = new HashMap<>();
            int n = s.length();
            for (int i = 0; i <= s.length() - 10; i++) {
                String sub = s.substring(i, i + 10);
                cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
                if (cnt.get(sub) == 2) {
                    res.add(sub);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc187().new Solution();
        System.out.println(sol.findRepeatedDnaSequences("AAAAAAAAAAAAAAAAAAAAAAAAAAA"));
    }
}
