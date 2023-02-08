package com.tridu33.mineOJ.Parser;
/*

输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：

输入：root = [1,2]
输出：[1,2]

* */
public class CodecLL1Parser{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }


        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static  void main(String[] args) {
        Codec sol = new CodecLL1Parser().new Codec();
        /*
                                  1
                               #      3
                                     # #
        */
        System.out.println(sol.serialize(sol.deserialize("(#)1((#)3(#))")));
        System.out.println(sol.serialize(new TreeNode(1,null, new TreeNode(3))));

        // 递归下降需要输入的字符串有种Lisp的括号感
        /*
                                  1
                               2     3
                              # #  4   5
                                  # # # #
        */
        System.out.println(sol.serialize(sol.deserialize(
                "((#)2(#))1(((#)4(#))3((#)5(#)))"
        )));
    }
    private class Codec {
        public String serialize(TreeNode root) {
            if (root == null) {
                return "#";
            }
            String left = "(" + serialize(root.left) + ")";
            String right = "(" + serialize(root.right) + ")";
            return left + root.val + right;
        }

        public TreeNode deserialize(String data) {
            int[] ptr = {0};
            return parse(data, ptr);
        }

        public TreeNode parse(String data, int[] ptr) {
            if (data.charAt(ptr[0]) == '#') {
                ++ptr[0];
                return null;
            }
            TreeNode cur = new TreeNode(0);
            cur.left = parseSubtree(data, ptr);
            cur.val = parseInt(data, ptr);
            cur.right = parseSubtree(data, ptr);
            return cur;
        }

        public TreeNode parseSubtree(String data, int[] ptr) {
            ++ptr[0]; // 跳过左括号
            TreeNode subtree = parse(data, ptr);
            ++ptr[0]; // 跳过右括号
            return subtree;
        }

        public int parseInt(String data, int[] ptr) {
            int x = 0, sgn = 1;
            if (!Character.isDigit(data.charAt(ptr[0]))) {
                sgn = -1;
                ++ptr[0];
            }
            while (Character.isDigit(data.charAt(ptr[0]))) {
                x = x * 10 + data.charAt(ptr[0]++) - '0';
            }
            return x * sgn;
        }
    }
}
