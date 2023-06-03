package com.tridu33.mineOJ.BitsOperator;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */

public class lc318 {
    class Solution {
        public int maxProduct(String[] words) {
            int len = words.length;
            int[] mask = new int[len];// all 0
            for (int i = 0; i < len; i++) {
                String word = words[i];
                int wordLen = word.length();
                for (int j = 0; j < wordLen; j++) {
                    mask[i] |= 1 << (word.charAt(j) - 'a');
                }
            }
            int res = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if ((mask[i] & mask[j]) == 0) {
                        res = Math.max(res, words[i].length() * words[j].length());
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc318().new Solution();
        System.out.println(sol.maxProduct(new String[]{"abcd", "iyh"}));
    }
}
