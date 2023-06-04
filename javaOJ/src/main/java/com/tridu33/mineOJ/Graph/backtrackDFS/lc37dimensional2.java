package com.tridu33.mineOJ.Graph.backtrackDFS;

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc37dimensional2 {
    class Solution {
        public void solveSudoku(char[][] board) {
            solveSudokuHelper(board);
        }

        private boolean solveSudokuHelper(char[][] board){
            //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
            // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！」
            for (int i = 0; i < 9; i++){ // 遍历行
                for (int j = 0; j < 9; j++){ // 遍历列
                    if (board[i][j] != '.'){ // 跳过原始数字
                        continue;
                    }
                    for (char k = '1'; k <= '9'; k++){ // (i, j) 这个位置放k是否合适
                        if (isValidSudoku(i, j, k, board)){
                            board[i][j] = k;
                            if (solveSudokuHelper(board)){ // 如果找到合适一组立刻返回
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    // 9个数都试完了，都不行，那么就返回false
                    return false;
                    // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                    // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
                }
            }
            // 遍历完没有返回false，说明找到了合适棋盘位置了
            return true;
        }

        /**
         * 判断棋盘是否合法有如下三个维度:
         *     同行是否重复
         *     同列是否重复
         *     9宫格里是否重复
         */
        private boolean isValidSudoku(int row, int col, char val, char[][] board){
            // 同行是否重复
            for (int i = 0; i < 9; i++){
                if (board[row][i] == val){
                    return false;
                }
            }
            // 同列是否重复
            for (int j = 0; j < 9; j++){
                if (board[j][col] == val){
                    return false;
                }
            }
            // 9宫格里是否重复
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            for (int i = startRow; i < startRow + 3; i++){
                for (int j = startCol; j < startCol + 3; j++){
                    if (board[i][j] == val){
                        return false;
                    }
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Solution sol = new lc37dimensional2().new Solution();
    }

}
