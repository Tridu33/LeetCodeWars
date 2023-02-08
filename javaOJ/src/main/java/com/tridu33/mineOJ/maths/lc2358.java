package com.tridu33.mineOJ.maths;

public class lc2358 {
    class Solution {
        public int maximumGroups(int[] grades) {
            // 1,2,3,...,n 有 n*(n+1)/2 <= length
            // 求根公式有个负数增根不用管，返回正数的整数根
            return (int)(-1+Math.sqrt(1+8*grades.length)) /2;
        }
    }
}
