package com.tridu33.mineOJ.Trees;
/**
 * @Date 2/8/2023.
 */

import java.lang.*;
import java.util.*;

/* @Desc:
层次遍历多叉树
[
     [1],
     [3,2,4],
     [5,6]
]
 lc590 N叉树的后序遍历
 lc589 N叉树的前序遍历
 https://leetcode.cn/problems/encode-n-ary-tree-to-binary-tree/
 https://leetcode.cn/problems/clone-n-ary-tree/

 */
public class lc429nForksTree {
    public static void main(String[] args) {
        Solution sol = new lc429nForksTree().new Solution();
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {

        List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue <Node> que = new ArrayDeque<>();
            if (root == null) return res;
            que.offer(root);
            while (!que.isEmpty()) {
                int size = que.size();
                List<Integer> vec = new ArrayList<>();
                while (size-- > 0) {
                    Node tmp = que.poll();
                    vec.add(tmp.val);
                    for (Node child : tmp.children) {
                        if (child != null) {
                            que.offer(child);
                        }
                    }
                }
                res.add(vec);
            }
            return res;
        }
    }
}
