package com.tridu33.mineOJ.Trees;
/**
 *@Date 2/8/2023.
 */
 
import java.lang.*;
import java.util.*;
/* @Desc:


 */
public class lc865 {
    public static void main(String[] args) {
        Solution sol = new lc865().new Solution();
    }
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    class Solution {
        // 思路：从每个树开始，获得当前节点的左右子树的最大深度
        // 深度相同，说明最深的节点在这个节点两边，那这个节点就是结果
        // 如果深度不相同，则去深度大的子树继续判断，最终就能得到结果
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if (root == null) return root;

            // 获取当前节点的左右子树的最大深度
            int leftMaxDepth = getMaxDepth(root.left);
            int rightMaxDepth = getMaxDepth(root.right);

            // 如果两边最大深度相同，则这个节点就是结果
            if (leftMaxDepth == rightMaxDepth) return root;

            // 不相等，那就去深度大的子树那边继续找
            if (leftMaxDepth > rightMaxDepth){
                return subtreeWithAllDeepest(root.left);
            }

            return subtreeWithAllDeepest(root.right);
        }

        public int getMaxDepth(TreeNode root){
            if (root == null) return 0;

            return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
        }
    }


}
