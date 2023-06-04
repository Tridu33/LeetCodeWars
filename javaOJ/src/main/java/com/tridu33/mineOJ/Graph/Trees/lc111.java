package com.tridu33.mineOJ.Graph.Trees;

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc111 {
    class Solution {
        /**
         * 递归法，相比求MaxDepth要复杂点
         * 因为最小深度是从根节点到最近**叶子节点**的最短路径上的节点数量
         */
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            if (root.left == null) {
                return rightDepth + 1;
            }
            if (root.right == null) {
                return leftDepth + 1;
            }
            // 左右结点都不为null
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
    class Solution2 {
        /**
         * 迭代法，层序遍历
         */
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            int depth = 0;
            while (!deque.isEmpty()) {
                int size = deque.size();
                depth++;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    if (poll.left == null && poll.right == null) {
                        // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                        return depth;
                    }
                    if (poll.left != null) {
                        deque.offer(poll.left);
                    }
                    if (poll.right != null) {
                        deque.offer(poll.right);
                    }
                }
            }
            return depth;
        }
    }
    public static void main(String[] args) {
        Solution sol = new lc111().new Solution();
    }

}
