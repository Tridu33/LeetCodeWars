package com.tridu33.mineOJ.Greedy;
/**
 * 
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc56 {
    public static void main(String[] args) {
        Solution sol = new lc56().new Solution();
        System.out.println(Arrays.deepToString(
                sol.merge(new int[][]{
                        {1,3},{2,6},{8,10},{15,18}
                })
        ));
    }

    /**
     时间复杂度 ： O(NlogN) 排序需要O(NlogN)
     空间复杂度 ： O(logN)  java 的内置排序是快速排序 需要 O(logN)空间

     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new LinkedList<>();
            //按照左边界排序
            Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
            //initial start 是最小左边界
            int start = intervals[0][0];
            int rightmostRightBound = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                //如果左边界大于最大右边界
                if (intervals[i][0] > rightmostRightBound) {
                    //加入区间 并且更新start
                    res.add(new int[]{start, rightmostRightBound});
                    start = intervals[i][0];
                    rightmostRightBound = intervals[i][1];
                } else {
                    //更新最大右边界
                    rightmostRightBound = Math.max(rightmostRightBound, intervals[i][1]);
                }
            }
            res.add(new int[]{start, rightmostRightBound});
            return res.toArray(new int[res.size()][]);
        }
    }

}
