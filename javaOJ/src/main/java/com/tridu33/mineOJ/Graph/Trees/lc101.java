package com.tridu33.mineOJ.Graph.Trees;

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc101 {
    class Solution {
        /**
         * 递归法
         */
        public boolean isSymmetric1 (TreeNode root){
            return compare(root.left, root.right);
        }

        private boolean compare (TreeNode left, TreeNode right){

            if (left == null && right != null) {
                return false;
            }
            if (left != null && right == null) {
                return false;
            }

            if (left == null && right == null) {
                return true;
            }
            if (left.val != right.val) {
                return false;
            }
            // 比较外侧
            boolean compareOutside = compare(left.left, right.right);
            // 比较内侧
            boolean compareInside = compare(left.right, right.left);
            return compareOutside && compareInside;
        }

        /**
         * 迭代法
         * 使用双端队列，相当于两个栈
         */
        public boolean isSymmetric2 (TreeNode root){
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerFirst(root.left);
            deque.offerLast(root.right);
            while (!deque.isEmpty()) {
                TreeNode leftNode = deque.pollFirst();
                TreeNode rightNode = deque.pollLast();
                if (leftNode == null && rightNode == null) {
                    continue;
                }
//            if (leftNode == null && rightNode != null) {
//                return false;
//            }
//            if (leftNode != null && rightNode == null) {
//                return false;
//            }
//            if (leftNode.val != rightNode.val) {
//                return false;
//            }
                // 以上三个判断条件合并
                if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                    return false;
                }
                deque.offerFirst(leftNode.left);
                deque.offerFirst(leftNode.right);
                deque.offerLast(rightNode.right);
                deque.offerLast(rightNode.left);
            }
            return true;
        }

        /**
         * 迭代法
         * 使用普通队列
         */
        public boolean isSymmetric3 (TreeNode root){
            Queue<TreeNode> deque = new LinkedList<>();
            deque.offer(root.left);
            deque.offer(root.right);
            while (!deque.isEmpty()) {
                TreeNode leftNode = deque.poll();
                TreeNode rightNode = deque.poll();
                if (leftNode == null && rightNode == null) {
                    continue;
                }
//            if (leftNode == null && rightNode != null) {
//                return false;
//            }
//            if (leftNode != null && rightNode == null) {
//                return false;
//            }
//            if (leftNode.val != rightNode.val) {
//                return false;
//            }
                // 以上三个判断条件合并
                if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                    return false;
                }
                // 这里顺序与使用Deque不同
                deque.offer(leftNode.left);
                deque.offer(rightNode.right);
                deque.offer(leftNode.right);
                deque.offer(rightNode.left);
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Solution sol = new lc101().new Solution();
    }

}
