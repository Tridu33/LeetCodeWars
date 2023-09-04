package com.tridu33.mineOJ.Graph.BST;

import java.lang.*;

/* @Desc:


 */
public class lc235 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
            if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
            return root;
        }
    }
    public static void main(String[] args) {
        Solution sol = new lc235().new Solution();
    }

}
