package com.tridu33.mineOJ.Graph.Trees;

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc617 {
    class Solution {
        // 递归
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) return root2;
            if (root2 == null) return root1;

            root1.val += root2.val;
            root1.left = mergeTrees(root1.left,root2.left);
            root1.right = mergeTrees(root1.right,root2.right);
            return root1;
        }
    }
    class Solution2 {
        // 使用栈迭代
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root2);
            stack.push(root1);
            while (!stack.isEmpty()) {
                TreeNode node1 = stack.pop();
                TreeNode node2 = stack.pop();
                node1.val += node2.val;
                if (node2.right != null && node1.right != null) {
                    stack.push(node2.right);
                    stack.push(node1.right);
                } else {
                    if (node1.right == null) {
                        node1.right = node2.right;
                    }
                }
                if (node2.left != null && node1.left != null) {
                    stack.push(node2.left);
                    stack.push(node1.left);
                } else {
                    if (node1.left == null) {
                        node1.left = node2.left;
                    }
                }
            }
            return root1;
        }
    }
    class Solution3 {
        // 使用队列迭代
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) return root2;
            if (root2 ==null) return root1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root1);
            queue.offer(root2);
            while (!queue.isEmpty()) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                // 此时两个节点一定不为空，val相加
                node1.val = node1.val + node2.val;
                // 如果两棵树左节点都不为空，加入队列
                if (node1.left != null && node2.left != null) {
                    queue.offer(node1.left);
                    queue.offer(node2.left);
                }
                // 如果两棵树右节点都不为空，加入队列
                if (node1.right != null && node2.right != null) {
                    queue.offer(node1.right);
                    queue.offer(node2.right);
                }
                // 若node1的左节点为空，直接赋值
                if (node1.left == null && node2.left != null) {
                    node1.left = node2.left;
                }
                // 若node1的右节点为空，直接赋值
                if (node1.right == null && node2.right != null) {
                    node1.right = node2.right;
                }
            }
            return root1;
        }
    }
    public static void main(String[] args) {
        Solution sol = new lc617().new Solution();
    }

}
