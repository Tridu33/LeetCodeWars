package com.tridu33.mineOJ.Graph.Trees;

import java.lang.*;
import java.util.*;

/* @Desc:

https://www.programmercarl.com/0450.%E5%88%A0%E9%99%A4%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E8%8A%82%E7%82%B9.html#%E6%99%AE%E9%80%9A%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E5%88%A0%E9%99%A4%E6%96%B9%E5%BC%8F
 */
public class lc450 {
    class Solution1 {
        public TreeNode deleteNode(TreeNode root, int key) {
            root = delete(root,key);
            return root;
        }

        private TreeNode delete(TreeNode root, int key) {
            if (root == null) return null;

            if (root.val > key) {
                root.left = delete(root.left,key);
            } else if (root.val < key) {
                root.right = delete(root.right,key);
            } else {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                TreeNode tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                root.val = tmp.val;
                root.right = delete(root.right,tmp.val);
            }
            return root;
        }
    }
    // 解法2
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return root;//第一种情况：没找到删除的节点，遍历到空节点直接返回了
            if (root.val == key) {
                // 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
                // 第三种情况：其左孩子为空，右孩子不为空，删除节点，右孩子补位 ，返回右孩子为根节点
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    // 第四种情况：其右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
                    return root.left;
                } else {
                    // 第五种情况：左右孩子节点都不为空，则将删除节点的左子树放到删除节点的右子树的最左面节点的左孩子的位置
                    // 并返回删除节点右孩子为新的根节点。
                    TreeNode cur = root.right;
                    while (cur.left != null) {
                        cur = cur.left;// 找右子树最左面的节点
                    }
                    cur.left = root.left;
                    root = root.right;
                    return root;
                }
            }
            if (root.val > key) root.left = deleteNode(root.left, key);
            if (root.val < key) root.right = deleteNode(root.right, key);
            return root;
        }
    }
    public static void main(String[] args) {
        Solution sol = new lc450().new Solution();
    }

}
