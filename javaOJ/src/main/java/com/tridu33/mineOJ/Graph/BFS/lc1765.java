package com.tridu33.mineOJ.Graph.BFS;

/* 题目
输入：isWater = [[0,1],[0,0]]
输出：[[1,0],[2,1]]
解释：上图展示了给各个格子安排的高度。
蓝色格子是水域格，绿色格子是陆地格。
输入：isWater = [[0,0,1],[1,0,0],[0,0,0]]
输出：[[1,1,0],[0,1,1],[1,2,2]]
解释：所有安排方案中，最高可行高度为 2 。
任意安排方案中，只要最高高度为 2 且符合上述规则的，都为可行方案。
* */

import java.lang.*;
import java.util.*;

public class lc1765 {
    public static void main(String[] args) {
        Solution sol = new lc1765().new Solution();

        System.out.println(Arrays.deepToString(sol.highestPeak(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}})));
        System.out.println(Arrays.deepToString(sol.highestPeak(new int[][]{{0, 1}, {0, 1}})));

    }

    class Solution {
        public int[][] highestPeak(int[][] isWater) {
            int m = isWater.length;
            if (m <= 0) {
                return new int[0][0];
            }
            int n = isWater[0].length;
            Deque<int[]> dq = new ArrayDeque();
            int[][] ans = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isWater[i][j] == 1) {
                        dq.addLast(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            multipleSourcesBFS(m, n, ans, dq, visited);
            return ans;
        }

        private void multipleSourcesBFS(int m, int n, int[][] ans, Deque<int[]> dq, boolean[][] visited) {
            while (!dq.isEmpty()) {
                int[] cur = dq.pollFirst();
                int x = cur[0];
                int y = cur[1];
                visited[x][y] = true;
                int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] dir : dirs) {
                    if (x + dir[0] >= 0
                            && x + dir[0] <= m - 1
                            && y + dir[1] >= 0
                            && y + dir[1] <= n - 1
                            && visited[x + dir[0]][y + dir[1]] == false
                    ) {
                        visited[x + dir[0]][y + dir[1]] = true;
                        ans[x + dir[0]][y + dir[1]] = ans[x][y] + 1;
                        dq.addLast(new int[]{x + dir[0], y + dir[1]});
                    }
                }
            }
        }
    }
}
