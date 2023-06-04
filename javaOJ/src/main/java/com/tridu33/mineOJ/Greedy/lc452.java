package com.tridu33.mineOJ.Greedy;
/**
 * 
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc452 {
    public static void main(String[] args) {
        Solution sol = new lc452().new Solution();
        System.out.println(sol.findMinArrowShots(
                new int[][]{
//                        {10, 16}, {2, 8}, {1, 6}, {7, 12}
                        {-2147483646,-2147483645},
                        {2147483646,2147483647}
                }
        ));
    }

    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) {
                return 0;
            }
            int res = 1;
            // 使用Integer内置比较方法，不会溢出
            Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
//            Arrays.sort(points, (p1, p2) -> {
//                return p1[0] - p2[0];
//            });// 会溢出
//            System.out.println(Math.pow(2,31)-1);//2147483646
//            System.out.println(2147483646-(-2147483646));//-4
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > points[i - 1][1]) {
                    res++;
                } else {
                    points[i][1] = Math.min(points[i - 1][1], points[i][1]);
                }
            }
            return res;
        }
    }

}
