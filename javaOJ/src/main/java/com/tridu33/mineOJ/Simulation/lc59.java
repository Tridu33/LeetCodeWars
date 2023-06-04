package com.tridu33.mineOJ.Simulation;


import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc59 {
    class Solution {
        public int[][] generateMatrix(int n) {
            //大神解法的解读
            int left = 0, right = n-1, top = 0, bottom = n-1;
            int count = 1, target = n * n;
            int[][] res = new int[n][n];
            //for循环中变量定义成i或j的细节：按照通常的思维，i代表行，j代表列
            //这样，就可以很容易区分出来变化的量应该放在[][]的第一个还是第二个
            //对于变量的边界怎么定义：
            //从左向右填充：填充的列肯定在[left,right]区间
            //从上向下填充：填充的行肯定在[top,bottom]区间
            //从右向左填充：填充的列肯定在[right,left]区间
            //从下向上填充：填充的行肯定在[bootom,top]区间
            //通过上面的总结会发现边界的起始和结束与方向是对应的
            while(count <= target){
                //从左到右填充，相当于缩小上边界
                for(int j = left; j <= right; j++) res[top][j] = count++;
                //缩小上边界
                top++;
                //从上向下填充，相当于缩小右边界
                for(int i = top; i <=bottom; i++) res[i][right] = count++;
                //缩小右边界
                right--;
                //从右向左填充，相当于缩小下边界
                for(int j = right; j >= left; j--) res[bottom][j] = count++;
                //缩小下边界
                bottom--;
                //从下向上填充，相当于缩小左边界
                for(int i = bottom; i >= top; i--) res[i][left] = count++;
                //缩小左边界
                left++;
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Solution sol = new lc59().new Solution();
        System.out.println(Arrays.deepToString(sol.generateMatrix(8)));
    }

}
