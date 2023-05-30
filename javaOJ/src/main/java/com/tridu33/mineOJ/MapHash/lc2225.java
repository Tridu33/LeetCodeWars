package com.tridu33.mineOJ.MapHash;


/*题目,输入记录，寻找八冠王柯洁...

示例 1：

输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
输出：[[1,2,10],[4,5,7,8]]
解释：
玩家 1、2 和 10 都没有输掉任何比赛。
玩家 4、5、7 和 8 每个都输掉一场比赛。
玩家 3、6 和 9 每个都输掉两场比赛。
因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。

示例 2：

输入：matches = [[2,3],[1,3],[5,4],[6,4]]
输出：[[1,2,5,6],[]]
解释：
玩家 1、2、5 和 6 都没有输掉任何比赛。
玩家 3 和 4 每个都输掉两场比赛。
因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。

*/

 import java.lang.*;
 import java.util.*;

 public class lc2225 {
     public static void main(String[] args) {
         Solution sol = new lc2225().new Solution();
         System.out.println(sol.findWinners(new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}}));
     }
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> lost0 = new HashSet<>();
        Set<Integer> lost1 = new HashSet<>();//去重
        Map<Integer, Integer> lostTimes4Loser = new HashMap<>();
        for (int[] match : matches) {
            lost0.add(match[0]);
            lostTimes4Loser.put(match[1], lostTimes4Loser.getOrDefault(match[1], 0) + 1);
        }
        for (int key : lostTimes4Loser.keySet()) {
            if (lostTimes4Loser.get(key) == 1) {
                lost1.add(key);
            }
            lost0.remove(key);// 输过则去除
        }
        List<Integer> list0 = new ArrayList<>(lost0);
        Collections.sort(list0);
        res.add(list0);
        List<Integer> list1 = new ArrayList<>(lost1);
        Collections.sort(list1);
        res.add(list1);
        return res;
    }
}
 }