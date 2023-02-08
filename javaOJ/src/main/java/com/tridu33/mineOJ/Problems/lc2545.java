package com.tridu33.mineOJ.Problems;

import java.util.Arrays;

public class lc2545 {
    class Solution {
        public int[][] sortTheStudents(int[][] score, int k) {
            Arrays.sort(score, (a, b) -> b[k] - a[k]);
            return score;
        }
    }
}
