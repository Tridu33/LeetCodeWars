package com.tridu33.mineOJ.Trees;

/*题目
输入：root = 层级遍历[1,2,3,2,null,2,4], target = 2
输出：[1,null,3,null,4]
解释：
上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。

*/

 import java.lang.*;
 
 public class lc1325 {
     public static void main(String[] args) {
         Solution sol = new lc1325().new Solution();
         TreeNode res = sol.removeLeafNodes(new TreeNode(1,
                         new TreeNode(2,
                                 new TreeNode(2,null,null), null),
                         new TreeNode(3,
                                 new TreeNode(2,null,null), new TreeNode(4,null,null))
                 ), 2);
         return;
     }

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target &&
                root.left == null &&
                root.right == null) {
            return null;
        } else {
            return root;
        }
    }
}
 }