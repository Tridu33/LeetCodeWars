package com.tridu33.mineOJ.Graph.Trees;

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc104 {
    class Solution {
        /**
         * 递归法
         */
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
    class Solution2 {
        /**
         * 递归法(求深度法)
         */
        //定义最大深度
        int maxnum = 0;

        public int maxDepth(TreeNode root) {
            ans(root,0);
            return maxnum;
        }

        //递归求解最大深度
        void ans(TreeNode tr,int tmp){
            if(tr==null) return;
            tmp++;
            maxnum = maxnum<tmp?tmp:maxnum;
            ans(tr.left,tmp);
            ans(tr.right,tmp);
            tmp--;
        }
    }
    class Solution3 {
        /**
         * 迭代法，使用层序遍历
         */
        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            int depth = 0;
            while (!deque.isEmpty()) {
                int size = deque.size();
                depth++;
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                }
            }
            return depth;
        }
    }
    public static void main(String[] args) {
        Solution sol = new lc104().new Solution();
    }

}
