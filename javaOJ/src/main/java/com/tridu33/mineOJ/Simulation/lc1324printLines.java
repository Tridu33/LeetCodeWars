package com.tridu33.mineOJ.Simulation;

/* 题目

示例 1：

输入：s = "HOW ARE YOU"
输出：["HAY","ORO","WEU"]
解释：每个单词都应该竖直打印。
 "HAY"
 "ORO"
 "WEU"
示例 2：

输入：s = "TO BE OR NOT TO BE"
输出：["TBONTB","OEROOE","   T"]
解释：题目允许使用空格补位，但不允许输出末尾出现空格。
"TBONTB"
"OEROOE"
"   T"
* */

import java.lang.*;
import java.util.*;

public class lc1324printLines {
    public static void main(String[] args) {
        Solution sol = new lc1324printLines().new Solution();
        String s = "HOW ARE YOU";
        System.out.println(sol.printVertically(s));

    }

    class Solution {
        public List<String> printVertically(String s) {
            List<String> res = new ArrayList<>();
            String[] split = s.trim().split(" ");
            int maxLen = Arrays.stream(split).mapToInt(String::length).max().orElse(0);
            for (int i = 0; i < maxLen; i++) {
                StringBuilder sb = new StringBuilder();
                for (String s1 : split) {
                    sb.append(i < s1.length() ? s1.charAt(i) : " ");
                }
                res.add(stripTrailing(sb));
            }
            return res;
        }

        private String stripTrailing(StringBuilder sb) {
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    }

}
