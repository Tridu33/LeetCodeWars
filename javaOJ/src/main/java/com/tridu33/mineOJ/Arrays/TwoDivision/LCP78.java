package com.tridu33.mineOJ.Arrays.TwoDivision;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class LCP78 {
    class Solution {

        public boolean check(int[][] rampart, int midTry) {
            int preRightEdge = rampart[0][1];
            for (int i = 1; i < rampart.length - 1; i++) {
                int curRightEdge = rampart[i][1];
                int REST = midTry - (rampart[i][0] - preRightEdge); // 尽量扩展左边的剩余量
                if (REST > 0) {
                    curRightEdge += REST;
                    if (curRightEdge > rampart[i + 1][0]) { // 不可以超出右边界
                        return false;
                    }
                }
                preRightEdge = curRightEdge;
            }
            return true;
        }

        public int rampartDefensiveLine(int[][] rampart) {
            return template1_1(rampart);
        }

        public int template1_1(int[][] rampart) {
            int left = 0, right = rampart[rampart.length - 1][0] - rampart[0][1];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // 奇数正中间 [1 ... (mid=)k ... 2k+1]
                // 偶数偏左边 [1 ... (mid=)k k+1 ... 2k]
                if (check(rampart, mid)) {
                    left = mid + 1;// [mid+1,right]
                } else {
                    right = mid - 1;// [left,mid-1]
                }
            }
            // left > right,距离为1，故
            return right;//return left-1
        }
    }

    public static void main(String[] args) {
        Solution sol = new LCP78().new Solution();
        System.out.println(sol.rampartDefensiveLine(new int[][]
                {{0, 3}, {4, 5}, {7, 9}}));
    }

}
