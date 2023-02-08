package com.tridu33.mineOJ.Simulation;
/**
 * @Date 2/8/2023.
 */

import java.lang.*;
import java.util.*;
/* @Desc:

输入：
["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
输出：
[null, null, null, null, 1, 0, null, 2]

解释：
DetectSquares detectSquares = new DetectSquares();
detectSquares.add([3, 10]);
detectSquares.add([11, 2]);
detectSquares.add([3, 2]);
detectSquares.count([11, 10]); // 返回 1 。你可以选择：
                               //   - 第一个，第二个，和第三个点
detectSquares.count([14, 8]);  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
detectSquares.add([11, 2]);    // 允许添加重复的点。
detectSquares.count([11, 10]); // 返回 2 。你可以选择：
                               //   - 第一个，第二个，和第三个点
                               //   - 第一个，第三个，和第四个点

 */
public class lc2013 {
    public static void main(String[] args) {
        DetectSquares sol = new lc2013().new DetectSquares();
    }
    class DetectSquares {
        Map<Integer, Map<Integer, Integer>> cnt;

        public DetectSquares() {
            cnt = new HashMap<Integer, Map<Integer, Integer>>();
        }

        public void add(int[] point) {
            int x = point[0], y = point[1];
            cnt.putIfAbsent(y, new HashMap<Integer, Integer>());
            Map<Integer, Integer> yCnt = cnt.get(y);
            yCnt.put(x, yCnt.getOrDefault(x, 0) + 1);
        }

        public int count(int[] point) {
            int res = 0;
            int x = point[0], y = point[1];
            if (!cnt.containsKey(y)) {
                return 0;
            }
            Map<Integer, Integer> yCnt = cnt.get(y);
            Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = cnt.entrySet();
            for (Map.Entry<Integer, Map<Integer, Integer>> entry : entries) {
                int col = entry.getKey();
                Map<Integer, Integer> colCnt = entry.getValue();
                if (col != y) {
                    // 根据对称性，这里可以不用取绝对值
                    int d = col - y;
                    res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x + d, 0) * colCnt.getOrDefault(x + d, 0);
                    res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x - d, 0) * colCnt.getOrDefault(x - d, 0);
                }
            }
            return res;
        }
    }
}
