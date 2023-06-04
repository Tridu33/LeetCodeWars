package com.tridu33.mineOJ.Arrays.monoStack;


import java.lang.*;
import java.util.*;

 /*题目 https://github.com/jiajunhua/labuladong-fucking-algorithm/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/%E5%8D%95%E8%B0%83%E6%A0%88.md
      不同题型变种，NextGreaterNumber模板
      [2,1,2,4,3]
      可以放下标，[3,2,3,-1,-1]
      还可以放值 [4,2,4,-1,-1]

  */


public class lc739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int len = temperatures.length;
            Deque<Integer> stk = new ArrayDeque<>();
            int[] res = new int[len];
            for (int i = len - 1; i >= 0; i--) {
                while (!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i]) {
                    stk.pop();
                }
                res[i] = stk.isEmpty() ? 0 : stk.peek() - i;
                stk.push(i);//下标
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc739().new Solution();
        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{
                73, 74, 75, 71, 69, 72, 76, 73})));
        // [1,1,4,2,1,1,0,0]
    }
}

