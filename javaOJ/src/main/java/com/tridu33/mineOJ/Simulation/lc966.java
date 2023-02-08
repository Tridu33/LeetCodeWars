package com.tridu33.mineOJ.Simulation;
/**
 * @Date 1/17/2023.
 */

import java.lang.*;
import java.util.*;

/* @Desc:
示例 1：

输入：wordlist = ["KiTe","kite","hare","Hare"],
queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
输出：     ["kite","KiTe","KiTe","Hare","hare",  "",   "",    "KiTe",   "","KiTe"]
示例 2:

输入：wordlist = ["yellow"], queries = ["YellOw"]
输出：["yellow"]


给出一些查询 queries，返回一个单词列表 answer，其中 answer[i] 是由查询 query = queries[i] 得到的正确单词。

 */
public class lc966 {
    public static void main(String[] args) {
        Solution sol = new lc966().new Solution();
        String[] res = sol.spellchecker(
                new String[]{"KiTe", "kite", "hare", "Hare"},
                new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"}
        );
        System.out.println(Arrays.deepToString(res));
    }

    class Solution {
        private Set<String> theSame = new HashSet<>();
        private Map<String, String> lower2Origin = new HashMap<>();
        private Map<String, String> allVowelSkip = new HashMap<>();

        private boolean isVowel(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        }

        private String replaceVowelWithStar(String word) {
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (isVowel(word.charAt(i))) {
                    ret.append('*');
                } else {
                    ret.append(word.charAt(i));
                }
            }
            return ret.toString();
        }

        public String[] spellchecker(String[] wordlist, String[] queries) {
            for (String word :
                    wordlist) {
                theSame.add(word);
                lower2Origin.putIfAbsent(word.toLowerCase(), word);
                allVowelSkip.putIfAbsent(replaceVowelWithStar(word.toLowerCase()), word);
            }
            List<String> res = new ArrayList<>();
            for (String query : queries) {
                res.add(getRet(query));
            }
            return res.toArray(new String[res.size()]);
        }

        private String getRet(String query) {
            if (theSame.contains(query)) {
                return query;
            }
            if (lower2Origin.containsKey(query.toLowerCase())) {
                return lower2Origin.get(query.toLowerCase());
            }
            if (allVowelSkip.containsKey(replaceVowelWithStar(query.toLowerCase()))) {
                return allVowelSkip.get(replaceVowelWithStar(query.toLowerCase()));
            }
            return "";
        }

    }

}
