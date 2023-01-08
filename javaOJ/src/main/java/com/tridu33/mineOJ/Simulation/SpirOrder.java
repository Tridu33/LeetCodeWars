package com.tridu33.mineOJ.Simulation;
import java.util.*;
import java.lang.*;
public class SpirOrder {
    public static void main(String[] args) {
        SpirOrder.Sol sol = new SpirOrder().new Sol();
        System.out.println(sol.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
    class Sol {
        public List<Integer> spiralOrder(int[][] matrix) {
            // ans：保存结果序列
            List<Integer> ans = new ArrayList<>();
            // m、n分别表示矩阵的行数、列数
            int m = matrix.length, n = matrix[0].length;
            // 分别表示左、右、上、下边界
            int left = 0, right = n - 1, top = 0, bottom = m - 1;
            // 总共需要读取的矩阵元素数量
            int total = m * n;

            // total > 0表示尚有元素未被读取
            while (total > 0) {
                // 向右遍历
                for (int i = left; i <= right && total > 0; i++) {
                    // 保存当前位置元素至序列
                    ans.add(matrix[top][i]);
                    // 剩余读取数量-1
                    total --;
                }
                // 当前最上方的行已被读取完，矩阵范围向下移动一行
                top ++;

                // 向下遍历
                for (int i = top; i <= bottom && total > 0; i++) {
                    ans.add(matrix[i][right]);
                    total --;
                }
                right --;

                // 向左遍历
                for (int i = right; i >= left && total > 0; i--) {
                    ans.add(matrix[bottom][i]);
                    total --;
                }
                bottom --;

                // 向上遍历
                for (int i = bottom; i >= top && total > 0; i--) {
                    ans.add(matrix[i][left]);
                    total --;
                }
                left ++;
            }

            return ans;
        }
    }
}

