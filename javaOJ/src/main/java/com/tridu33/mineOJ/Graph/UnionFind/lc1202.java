package com.tridu33.mineOJ.Graph.UnionFind;
/**
 * @Date 2/12/2023$.
 */

import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

/* @Desc:
示例 1:

输入：s = "dcab", pairs = [[0,3],[1,2]]
输出："bacd"
解释：
交换 s[0] 和 s[3], s = "bcad"
交换 s[1] 和 s[2], s = "bacd"
示例 2：

输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
输出："abcd"
解释：
交换 s[0] 和 s[3], s = "bcad"
交换 s[0] 和 s[2], s = "acbd"
交换 s[1] 和 s[2], s = "abcd"
示例 3：

输入：s = "cba", pairs = [[0,1],[1,2]]
输出："abc"
解释：
交换 s[0] 和 s[1], s = "bca"
交换 s[1] 和 s[2], s = "bac"
交换 s[0] 和 s[1], s = "abc"

 */
public class lc1202 {
    public static void main(String[] args) {
        Solution sol = new lc1202().new Solution();
        String s="dcab";
        int[][] input = new int[][]{{0,3},{1,2}};
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> arr0 = Arrays.stream(input[0]).boxed().collect(Collectors.toList());
        List<Integer> arr1 = Arrays.stream(input[1]).boxed().collect(Collectors.toList());
        pairs.add(arr0);
        pairs.add(arr1);
        System.out.println(sol.smallestStringWithSwaps(s,pairs));
    }
    class Solution {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            String res = "";
            int len = pairs.size();
            for (int i = 0; i < len; i++) {

            };
            return res;
        }
    }

}
