package com.tridu33.mineOJ.Greedy;

/* 题目
这样的贪心思路，871题最低加油次数和630课程表III也有体现。

两种贪心策略均可：

- 优先使用梯子，梯子不够时选取差值最小的出堆改用砖头。(小根堆) 解法一的理论复杂度应该是最低的。
- 优先使用砖头，砖头不够时选取消耗最大的出堆改用梯子。(大根堆)


输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
输出：4
解释：从建筑物 0 出发，你可以按此方案完成旅程：
- 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
- 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
- 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
- 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
无法越过建筑物 4 ，因为没有更多砖块或梯子。
示例 2：

输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
输出：7
示例 3：

输入：heights = [14,3,19,3], bricks = 17, ladders = 0
输出：3
链接：https://leetcode.cn/problems/furthest-building-you-can-reach/solutions/469774/javasan-chong-jie-fa-yu-shi-jian-fu-za-du-fen-xi-b/
* */

import java.lang.*;
import java.util.*;

public class lc1642 {
 public static void main(String[] args) {
     Solution sol = new lc1642().new Solution();
     System.out.println(sol.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
     System.out.println(sol.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
     System.out.println(sol.furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0));
 }

class Solution {
public int furthestBuilding(int[] heights, int bricks, int ladders) {
    int n = heights.length, costBricks = 0;
    PriorityQueue<Integer> dqLadders = new PriorityQueue<>();
    for (int i = 1; i < heights.length; i++) {
        Integer diff = heights[i] - heights[i - 1];
        if (diff > 0) {//优先使用梯子，
            dqLadders.add(diff);
            if (dqLadders.size() > ladders) {
                //梯子不够时选取差值最小的出堆改用砖头。
                costBricks += dqLadders.peek();
                dqLadders.poll();
            }
            if (costBricks > bricks) {
                return i - 1;
            }
        }
    }
    return n - 1;// 砖头有剩下的
}
}
}
