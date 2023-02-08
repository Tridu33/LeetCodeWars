package com.tridu33.mineOJ.Trees;

/**
 * 题目
 * <p>
 * 输入：root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
 * 输出："UURL"
 * 解释：最短路径为：3 → 1 → 5 → 2 → 6 。
 * <p>
 * 输入：root = [2,1], startValue = 2, destValue = 1
 * 输出："L"
 * 解释：最短路径为：2 → 1 。
 */

 import java.lang.*;
 import java.util.HashMap;

public class lc2096 {
     public static void main(String[] args) {
         Solution sol = new lc2096().new Solution();
         TreeNode root1 = new TreeNode(5,
                 new TreeNode(1, new TreeNode(3), null),
                 new TreeNode(2, new TreeNode(6), new TreeNode(4)));
 //        System.out.println(sol.getDirections(root1, 3, 6));
         TreeNode root2 = new TreeNode(2, new TreeNode(1), null);
         System.out.println(sol.getDirections(root2, 2, 1));
     }

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

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
    StringBuilder s2common = new StringBuilder();
    StringBuilder e2common = new StringBuilder();
    TreeNode sNode = null;
    TreeNode eNode = null;
    HashMap<TreeNode, TreeNode> father4nodes = new HashMap<>();

    private TreeNode theClosestCommonAncestor_dfsPos(TreeNode root, int s, int e) {
        if (root == null) {
            return null;
        }
        if (root.left != null) father4nodes.put(root.left, root);
        if (root.right != null) father4nodes.put(root.right, root);
        TreeNode left = theClosestCommonAncestor_dfsPos(root.left, s, e);
        TreeNode right = theClosestCommonAncestor_dfsPos(root.right, s, e);

        if (root.val == s) {
            sNode = root;
            return root;
        }
        if (root.val == e) {
            eNode = root;
            return root;
        }
        return getRet(left, right, root);
    }

    private TreeNode getRet(TreeNode left, TreeNode right, TreeNode root) {
        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return root;
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode commonAncestor = theClosestCommonAncestor_dfsPos(root, startValue, destValue);
        TreeNode cur = sNode;
        while (cur != null && cur != commonAncestor) {
            s2common.append("U");
            cur = father4nodes.get(cur);
        }
        cur = eNode;
        while (cur != null && cur != commonAncestor) {
            TreeNode curFather = father4nodes.get(cur);
            if (curFather.left == cur) e2common.append("L");
            if (curFather.right == cur) e2common.append("R");
            cur = curFather;
        }
        return s2common.append(e2common.reverse()).toString();
    }
}

 }