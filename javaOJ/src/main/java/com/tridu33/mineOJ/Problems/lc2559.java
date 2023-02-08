package com.tridu33.mineOJ.Problems;

/*题目

- 示例 1：

输入：words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
输出：[2,3,0]
解释：以元音开头和结尾的字符串是 "aba"、"ece"、"aa" 和 "e" 。
查询 [0,2] 结果为 2（字符串 "aba" 和 "ece"）。
查询 [1,4] 结果为 3（字符串 "ece"、"aa"、"e"）。
查询 [1,1] 结果为 0 。
返回结果 [2,3,0] 。

- 示例 2：

输入：words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
输出：[3,2,1]
解释：每个字符串都满足这一条件，所以返回 [3,2,1] 。

*/

 import java.lang.*;
 import java.util.*;

 public class lc2559 {
     public static void main(String[] args) {
         Solution sol = new lc2559().new Solution();
         System.out.println(Arrays.toString(sol.vowelStrings(
                 new String[]{"aba", "bcb", "ece", "aa", "e"},
                 new int[][]{{0, 2}, {1, 4}, {1, 1}}
         )));
     }

class Solution {
    private boolean isBeginEndWithVow(String s) {
        HashSet<Character> vows = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        if (vows.contains(s.charAt(0))
                && vows.contains(s.charAt(s.length() - 1))) {
            return true;
        } else {
            return false;
        }
    }

    private int[] getSumArray(int[] flags) {
        int[] flagsSum = new int[flags.length];
        flagsSum[0] = flags[0];
        for (int i = 1; i < flags.length; i++) {
            flagsSum[i] = flags[i] + flagsSum[i - 1];
        }
        return flagsSum;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (isBeginEndWithVow(words[i])) {
                flags[i] = 1;
            } else {
                flags[i] = 0;
            }
        }
        int[] res = new int[queries.length];
        int[] flagsSum = getSumArray(flags);// 前缀和
        for (int i = 0; i < queries.length; i++) {
            int begin = queries[i][0], end = queries[i][1];
            res[i] = flagsSum[end] - flagsSum[begin] + flags[begin];
        }
        return res;
    }
}
 }

