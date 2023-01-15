package com.tridu33.mineOJ.Greedy;


/* 题目
示例 1：

输入：groupSizes = [3,3,3,3,3,1,3]
输出：[[5],[0,1,2],[3,4,6]]
解释：
第一组是 [5]，大小为 1，groupSizes[5] = 1。
第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] = groupSizes[2] = 3。
第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] = groupSizes[6] = 3。
其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
示例 2：

输入：groupSizes = [2,1,3,3,3,2]
输出：[[1],[0,5],[2,3,4]]

 * */

import java.lang.*;
import java.util.*;

public class lc1282 {
    public static void main(String[] args) {
        Solution sol = new lc1282().new Solution();
        System.out.println(sol.groupThePeople(new int[]{3, 3, 3, 2, 2, 1}));

    }

    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            Map<Integer, List<Integer>> groups = new HashMap<Integer, List<Integer>>();
            int n = groupSizes.length;
            for (int i = 0; i < n; i++) {
                int size = groupSizes[i];
                groups.putIfAbsent(size, new ArrayList<Integer>());
                groups.get(size).add(i);
            }
            List<List<Integer>> groupList = new ArrayList<List<Integer>>();
            for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
                int size = entry.getKey();
                List<Integer> people = entry.getValue();
                int groupCount = people.size() / size;
                for (int i = 0; i < groupCount; i++) {
                    List<Integer> group = new ArrayList<Integer>();
                    int start = i * size;
                    for (int j = 0; j < size; j++) {
                        group.add(people.get(start + j));
                    }
                    groupList.add(group);
                }
            }
            return groupList;
        }
    }
}
