package com.tridu33.mineOJ.Graph.BFS;


import java.lang.*;
import java.util.*;

public class matrixBFS {
    public static void main(String[] args) {
        Solution sol = new matrixBFS().new Solution();
        System.out.println(sol.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    class Solution {
        public int orangesRotting(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int m = grid.length, n = grid[0].length;
            int cnt1 = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(i * n + j); // 将腐烂的橘子入队
                    } else if (grid[i][j] == 1) {
                        cnt1++; // 统计新鲜橘子的数量
                    }
                }
            }

            int time = 0;
            while (!queue.isEmpty() && cnt1 > 0) { // 当队列空了 或者 没有新鲜橘子了，停止循环
                time++; // 一层一层的传染，每传染一层，时间+1
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int p = queue.poll();
                    int x = p / n, y = p % n;
                    if (x - 1 >= 0 && grid[x - 1][y] == 1) { // 上
                        cnt1--; // 每传染一个，更新新鲜橘子的数量
                        grid[x - 1][y] = 2;
                        queue.offer((x - 1) * n + y);
                    }
                    if (x + 1 < m && grid[x + 1][y] == 1) { // 下
                        cnt1--;
                        grid[x + 1][y] = 2;
                        queue.offer((x + 1) * n + y);
                    }
                    if (y - 1 >= 0 && grid[x][y - 1] == 1) { // 左
                        cnt1--;
                        grid[x][y - 1] = 2;
                        queue.offer(x * n + y - 1);
                    }
                    if (y + 1 < n && grid[x][y + 1] == 1) { // 右
                        cnt1--;
                        grid[x][y + 1] = 2;
                        queue.offer(x * n + y + 1);
                    }
                }
            }

            return cnt1 == 0? time: -1;
        }
    }

}