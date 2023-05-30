package com.tridu33.mineOJ.Graph.backtrackDFS;
/* 题目
示例 1：

输入：students = [[1,1,0],[1,0,1],[0,0,1]], mentors = [[1,0,0],[0,0,1],[1,1,0]]
输出：8
解释：按下述方式分配学生和导师：
- 学生 0 分配给导师 2 ，兼容性评分为 3 。
- 学生 1 分配给导师 0 ，兼容性评分为 2 。
- 学生 2 分配给导师 1 ，兼容性评分为 3 。
最大兼容性评分和为 3 + 2 + 3 = 8 。
示例 2：

输入：students = [[0,0],[0,0],[0,0]], mentors = [[1,1],[1,1],[1,1]]
输出：0
解释：任意学生与导师配对的兼容性评分都是 0

* */

import java.lang.*;
import java.util.*;

public class lc1947 {
    public static void main(String[] args) {
        int[][] students = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 1}};
        int[][] mentors = new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        Solution sol = new lc1947().new Solution();
        System.out.println(sol.maxCompatibilitySum(students, mentors));
    }

    class Solution {
        private List<Integer> path = new ArrayList<>();// 存放当前结果
        private int maxSum = 0;

        // 存放示例 1最终结果: [2 0 1]
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            int m = students.length;
            if (m == 0) {
                return 0;
            }
            boolean[] used = new boolean[m];
            Arrays.fill(used, false);
            backtracking(used, students, mentors);
            return maxSum;
        }

        void backtracking(boolean[] used, int[][] students, int[][] mentors) {
            int m = students.length, n = students[0].length;
            if (path.size() == m) {// 每次遍历出口
                System.out.println(Arrays.toString(path.toArray()));
                int curSum = getCurSum(students, mentors);
                maxSum = Math.max(maxSum, curSum);
                return;
            }
            for (int i = 0; i < m; i++) {
                if (used[i] == false) {
                    path.add(i);
                    used[i] = true;
                    backtracking(used, students, mentors);// 回溯
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }

        private int getCurSum(int[][] students, int[][] mentors) {
            int res = 0;
            for (int i = 0; i < path.size(); i++) {
                int s = i, m = path.get(i);
                for (int j = 0; j < students[0].length; j++) {
                    if (students[s][j] == mentors[m][j]) {
                        res++;
                    }
                }
            }
            return res;
        }

    }

}
