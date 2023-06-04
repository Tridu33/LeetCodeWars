package com.tridu33.mineOJ.Graph.Trees;

import java.util.*;


/*题目
输入：edges = [[0,1],[1,2],[1,3],[3,4]], bob = 3, amount = [-2,4,2,-4,6]
输出：6
解释：
上图展示了输入给出的一棵树。游戏进行如下：
- Alice 一开始在节点 0 处，Bob 在节点 3 处。他们分别打开所在节点的门。
  Alice 得分为 -2 。
- Alice 和 Bob 都移动到节点 1 。
  因为他们同时到达这个节点，他们一起打开门并平分得分。
  Alice 的得分变为 -2 + (4 / 2) = 0 。
- Alice 移动到节点 3 。因为 Bob 已经打开了这扇门，Alice 得分不变。
  Bob 移动到节点 0 ，并停止移动。
- Alice 移动到节点 4 并打开这个节点的门，她得分变为 0 + 6 = 6 。
现在，Alice 和 Bob 都不能进行任何移动了，所以游戏结束。
Alice 无法得到更高分数。

*/
import java.lang.*;

public class lc2467 {
    public static void main(String[] args) {
        Solution sol = new lc2467().new Solution();
        System.out.println(sol.mostProfitablePath(
                new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}},
                3,
                new int[]{-2, 4, 2, -4, 6})
        );
    }

    class Solution {
        int len, bob, maxRes;
        boolean reachedBob;
        int[] amount;
        Queue<Integer> pathBob2Zero;
        List<Integer>[] ambigram;

        public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
            reachedBob = false;
            maxRes = Integer.MIN_VALUE;
            len = amount.length;
            this.amount = amount;
            this.bob = bob;
            ambigram = new List[len];
            pathBob2Zero = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                ambigram[i] = new ArrayList<>();
            }
            for (int[] e : edges) {
                ambigram[e[0]].add(e[1]);
                ambigram[e[1]].add(e[0]);
            }
            dfs(0, 0);// 从0到bob
            pathBob2Zero.offer(0);
            bfs();
            return maxRes;
        }

        public void dfs(int k, int s) {
            for (int t : ambigram[k]) {
                if (t == s) continue;
                dfs(t, k);
                if (t == bob || reachedBob) {
                    reachedBob = true;
                    pathBob2Zero.offer(t);
                    break;
                }
            }
        }

        public void bfs() {
            Set<Integer> hashTime4pathBob2Zero = new HashSet<>();
            boolean[] v = new boolean[len];
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, amount[0]});
            v[0] = true;
            int curNodeInPathBob2Zero = pathBob2Zero.poll();
            hashTime4pathBob2Zero.add(curNodeInPathBob2Zero);
            while (!q.isEmpty()) {
                int size = q.size();
                if (!pathBob2Zero.isEmpty()) {
                    curNodeInPathBob2Zero = pathBob2Zero.poll();
                }
                while (size != 0) {
                    int[] x = q.poll();
                    if (x[0] != 0 && ambigram[x[0]].size() == 1) {
                        maxRes = Math.max(maxRes, x[1]);
                    } else {
                        for (int t : ambigram[x[0]]) {
                            if (v[t]) continue;
                            v[t] = true;
                            int grade = x[1];
                            if (!hashTime4pathBob2Zero.contains(t)) {
                                if (curNodeInPathBob2Zero == t) {
                                    grade += amount[t] / 2;
                                } else {
                                    grade += amount[t];
                                }
                            }
                            q.offer(new int[]{t, grade});
                        }
                    }
                    size--;
                }
                hashTime4pathBob2Zero.add(curNodeInPathBob2Zero);
            }
        }
    }

}
