package com.tridu33.mineOJ.Simulation;

/* 题目
示例 1：

输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
输出："bobistwoyearsold"
解释：
键 "name" 对应的值为 "bob" ，所以将 "(name)" 替换为 "bob" 。
键 "age" 对应的值为 "two" ，所以将 "(age)" 替换为 "two" 。
示例 2：

输入：s = "hi(name)", knowledge = [["a","b"]]
输出："hi?"
解释：由于不知道键 "name" 对应的值，所以用 "?" 替换 "(name)" 。
示例 3：

输入：s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
输出："yesyesyesaaa"
解释：相同的键在 s 中可能会出现多次。
键 "a" 对应的值为 "yes" ，所以将所有的 "(a)" 替换为 "yes" 。
注意，不在括号里的 "a" 不需要被替换。

* */

 import java.lang.*;
 import java.util.*;

 public class lc1807 {
     public static void main(String[] args) {
         Solution sol = new lc1807().new Solution();
         String s = "(name)is(age)yearsold";
         List<List<String>> knowledge = new ArrayList<>();
         List<String> temp1 = new ArrayList<>();
         temp1.add("name");
         temp1.add("blob");
         knowledge.add(temp1);
         List<String> temp2 = new ArrayList<>();
         temp2.add("age");
         temp2.add("two");
         knowledge.add(temp2);

         System.out.println(sol.evaluate(s, knowledge));

     }

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<String, String>();
        for (List<String> kd : knowledge) {
            dict.put(kd.get(0), kd.get(1));
        }
        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                addKey = true;
            } else if (c == ')') {
                if (dict.containsKey(key.toString())) {
                    res.append(dict.get(key.toString()));
                } else {
                    res.append('?');
                }
                addKey = false;
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}
}
