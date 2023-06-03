package com.tridu33.mineOJ.Trees.DFS;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc2265 {
    class Solution {
        int res = 0;

        public int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int sum = left[0] + right[0] + root.val;
            int num = left[1] + right[1] + 1;
            if (sum / num == root.val) {
                res++;
            }
            return new int[]{sum, num};
        }

        public int averageOfSubtree(TreeNode root) {
            dfs(root);
            return res;
        }

    }

    public static void main(String[] args) {
        Solution sol = new lc2265().new Solution();
    }
}
