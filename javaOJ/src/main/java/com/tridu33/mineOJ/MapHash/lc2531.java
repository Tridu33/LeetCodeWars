package com.tridu33.mineOJ.MapHash;

/*题目
示例 1：

输入：word1 = "ac", word2 = "b"
输出：false
解释：交换任何一组下标都会导致第一个字符串中有 2 个不同的字符，而在第二个字符串中只有 1 个不同字符。
示例 2：

输入：word1 = "abcc", word2 = "aab"
输出：true
解释：交换第一个字符串的下标 2 和第二个字符串的下标 0 。之后得到 word1 = "abac" 和 word2 = "cab" ，各有 3 个不同字符。
示例 3：

输入：word1 = "abcde", word2 = "fghij"
输出：true
解释：无论交换哪一组下标，两个字符串中都会有 5 个不同字符

*/


 import java.lang.*;
 import java.util.*;

 public class lc2531 {
     public static void main(String[] args) {
         Solution sol = new lc2531().new Solution();
         System.out.println(sol.isItPossible("ac", "b"));
     }

class Solution {
    public boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.merge(word1.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < word2.length(); i++) {
            map2.merge(word2.charAt(i), 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> e1 : map1.entrySet()) {
            for (Map.Entry<Character, Integer> e2 : map2.entrySet()) {
                Character ch1 = e1.getKey(), ch2 = e2.getKey();
                int len1 = map1.size(), len2 = map2.size();
                if (ch1.equals(ch2)) {
                    if (len1 == len2) {
                        return true;
                    }
                } else {
                    int newLen1 = len1 + (e1.getValue() == 1 ? -1 : 0) + (map1.containsKey(ch2) ? 0 : 1);
                    int newLen2 = len2 + (e2.getValue() == 1 ? -1 : 0) + (map2.containsKey(ch1) ? 0 : 1);
                    if (newLen1 == newLen2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
 }

