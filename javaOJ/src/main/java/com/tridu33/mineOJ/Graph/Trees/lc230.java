package com.tridu33.mineOJ.Graph.Trees;

/**
 * 题目
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 */

import java.lang.*;
import java.util.*;

public class lc230 {
    public static void main(String[] args) {
        Solution sol = new lc230().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                --k;
                if (k == 0) {
                    break;
                }
                root = root.right;
            }
            return root.val;
        }
    }

}
