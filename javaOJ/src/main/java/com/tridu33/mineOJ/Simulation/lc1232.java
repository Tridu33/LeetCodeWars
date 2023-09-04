package com.tridu33.mineOJ.Simulation;

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc1232 {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates.length == 2) return true;
            for (int i = 0; i <= (coordinates.length - 3); i++) {
                if (!isLine(coordinates[i], coordinates[i + 1], coordinates[i + 2])) {
                    return false;
                }
            }
            return true;
        }

        boolean isLine(int[] p1, int[] p2, int[] p3) {
            return (p3[1] - p2[1]) * (p2[0] - p1[0]) == (p2[1] - p1[1]) * (p3[0] - p2[0]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc1232().new Solution();
        System.out.println(sol);
    }

}
