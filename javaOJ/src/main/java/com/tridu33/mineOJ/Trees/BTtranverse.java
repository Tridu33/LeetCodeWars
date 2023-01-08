package com.tridu33.mineOJ.Trees;

import java.util.*;
public class BTtranverse {
    public static void main(String[] args) {
        Solution sol = new BTtranverse().new Solution();
        TreeNode root = new TreeNode(5,new TreeNode(4 ,new TreeNode(1),new TreeNode(2)),new TreeNode(6));
        List<Integer> res = sol.preorderTraversal(root);
        List<Integer> res3 = sol.levelOrderTraverse(root);
//        List<Integer> res = sol.preorder(root);
//        List<Integer> res = sol.midOrder(root);
//        List<Integer> res = sol.posOrder(root);
        System.out.println(res);
    }
    static class TreeNode {
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
        // 统一的迭代法遍历树 - 前中后遍历 - 标记法= 修改4行的顺序即可
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            Stack<TreeNode> st = new Stack<>();
            if (root != null) st.push(root);
            while (!st.empty()) {
                TreeNode node = st.peek();
                if (node != null) {
                    st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中

                    if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                    if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
                    st.push(node);                          // 添加中节点
                    st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

                } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                    st.pop();           // 将空节点弹出
                    node = st.peek();    // 重新取出栈中元素
                    st.pop();
                    result.add(node.val); // 加入到结果集
                }
            }
            return result;
        }
        // levelOrderTraverse
        public List<Integer> levelOrderTraverse(TreeNode root){
            List<Integer> res = new LinkedList<>();
            Deque<TreeNode> q = new ArrayDeque<>();
            if(root  != null){
                q.offer(root);
            }
            while(!q.isEmpty()){
                TreeNode cur= q.poll();
                res.add(cur.val);
                if(cur.left != null){q.offer(cur.left);}
                if(cur.right != null){q.offer(cur.right);}
            }
            return res;
        }
        // preOrder
        public List<Integer> preorder(TreeNode root){
            List<Integer> res = new LinkedList<>();
            preorderHelper(root,res);
            return res;
        }
        public void preorderHelper(TreeNode root,List<Integer> res){
            if(root == null){return;}
            res.add(root.val);
            preorderHelper(root.left,res);
            preorderHelper(root.right,res);
        }
        // midOrder
        // preOrder
        public List<Integer> midOrder(TreeNode root){
            List<Integer> res = new LinkedList<>();
            midOrderHelper(root,res);
            return res;
        }
        public void midOrderHelper(TreeNode root,List<Integer> res){
            if(root == null){return;}
            midOrderHelper(root.left,res);
            res.add(root.val);
            midOrderHelper(root.right,res);
        }
        // posOrder
        public List<Integer> posOrder(TreeNode root){
            List<Integer> res = new LinkedList<>();
            posOrderHelper(root,res);
            return res;
        }
        public void posOrderHelper(TreeNode root,List<Integer> res){
            if(root == null){return;}
            posOrderHelper(root.left,res);
            posOrderHelper(root.right,res);
            res.add(root.val);
        }
    }
}
