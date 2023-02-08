package com.tridu33.mineOJ.String;
/**
 * @Date 2/8/2023.
 */

import java.lang.*;
import java.util.*;

/* @Desc:
一个人能能走的多远不在于他在顺境时能走的多快，而在于他在逆境时多久能找到曾经的自己。
                                                        ————KMP
Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 */
public class lc459KMP {
    public static void main(String[] args) {
        Solution sol = new lc459KMP().new Solution();
        boolean res = sol.repeatedSubstringPattern("abcabcabcabc");
        System.out.println(res);
    }
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            return kmp(s + s, s);
        }

        public boolean kmp(String query, String pattern) {
            int n = query.length();
            int m = pattern.length();
            int[] fail = new int[m];
            Arrays.fill(fail, -1);
            for (int i = 1; i < m; ++i) {
                int j = fail[i - 1];
                while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                    j = fail[j];
                }
                if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                    fail[i] = j + 1;
                }
            }
            int match = -1;
            for (int i = 1; i < n - 1; ++i) {
                while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                    match = fail[match];
                }
                if (pattern.charAt(match + 1) == query.charAt(i)) {
                    ++match;
                    if (match == m - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }



}
