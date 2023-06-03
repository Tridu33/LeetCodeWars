package com.tridu33.mineOJ.Arrays.others;


/* 题目
还有多少只兔子与你（指被提问的兔子）颜色相同?

示例 1：

输入：answers = [1,1,2]
输出：5
解释：
两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
设回答了 "2" 的兔子为蓝色。
此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
因此森林中兔子的最少数量是 5 只：3 只回答的和 2 只没有回答的。
示例 2：

输入：answers = [10,10,10]
输出：11
* */

import java.lang.*;
import java.util.*;

 public class lc781 {
     public static void main(String[] args) {
         Solution sol = new lc781().new Solution();
         System.out.println(sol.numRabbits(new int[]{1, 1, 2}));
         System.out.println(sol.numRabbits(new int[]{10, 10, 10}));
         boolean a = 20 < 45 ? true : false;
         System.out.println(a);
     }

class Solution {
    public int numRabbits(int[] answers) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ans :
                answers) {
            int cur = map.getOrDefault(ans + 1, 0);
            if (cur < ans + 1) {
                res += (cur == 0) ? (ans + 1) : 0;
                map.put(ans + 1, cur + 1);
            }
            if (cur == ans + 1) {
                res += (ans + 1);
                map.put(ans + 1, 1);
            }
        }
        return res;
    }
}

 }