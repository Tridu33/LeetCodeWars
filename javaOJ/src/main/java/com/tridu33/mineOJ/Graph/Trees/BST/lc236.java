package com.tridu33.mineOJ.Graph.Trees.BST;

import com.tridu33.mineOJ.Graph.Trees.TreeNode;

import java.lang.*;

/* @Desc:


 */
public class lc236 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) { // 递归结束条件
                return root;
            }

            // 后序遍历
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left == null && right == null) { // 若未找到节点 p 或 q
                return null;
            }else if(left == null && right != null) { // 若找到一个节点
                return right;
            }else if(left != null && right == null) { // 若找到一个节点
                return left;
            }else { // 若找到两个节点
                return root;
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new lc236().new Solution();
    }

}
