package com.tridu33.mineOJ.Graph.Trees;

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc226 {


    class Solution {
//        void swap(TreeNode l, TreeNode r) {
//            TreeNode temp = l;
//            l = r;
//            r = temp;
//        }//java不是cpp，这样传递引用是错的交换写法

        private void swapChildren(TreeNode root) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }

        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
//            swap(root.left, root.right);// wrong
            swapChildren(root);
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
    class SolutionBFS {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {return null;}
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                while (size-- > 0) {
                    TreeNode node = deque.poll();
                    swap(node);
                    if (node.left != null) deque.offer(node.left);
                    if (node.right != null) deque.offer(node.right);
                }
            }
            return root;
        }

        public void swap(TreeNode root) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
    public static void main(String[] args) {
        Solution sol = new lc226().new Solution();
    }

}
