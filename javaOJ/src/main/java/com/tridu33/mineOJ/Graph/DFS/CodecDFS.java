package com.tridu33.mineOJ.Graph.DFS;

import com.tridu33.mineOJ.Graph.Trees.TreeNode;

import java.util.*;

public class CodecDFS {
    public static void main(String[] args) {
        CodecDFS sol = new CodecDFS();
        System.out.println(sol.serialize(sol.deserialize("1,2,3,null,null,4,5")));
    }

    public String serialize(com.tridu33.mineOJ.Graph.Trees.TreeNode root) {
        StringBuilder sb = new StringBuilder(); // 利用StringBuilder拼接
        return toStr(root, sb).toString();
    }

    private StringBuilder toStr(com.tridu33.mineOJ.Graph.Trees.TreeNode node, StringBuilder sb) { // 序列化dfs
        if (node == null) sb.append("null,");
        else {
            sb.append(Integer.toString(node.val) + ",");
            sb = toStr(node.left, sb);
            sb = toStr(node.right, sb);
        }
        return sb;
    }

    public com.tridu33.mineOJ.Graph.Trees.TreeNode deserialize(String data) {
        String[] strNodes = data.split(",");
        List<String> nodes = new LinkedList<>(Arrays.asList(strNodes)); // 涉及头节点的操作，用LinkedList效率高
        return toTree(nodes);
    }

    private com.tridu33.mineOJ.Graph.Trees.TreeNode toTree(List<String> nodes) { // 反序列化dfs
        if (nodes.size() == 0) {
            return null;
        }
        if (nodes.get(0).equals("null")) {
            nodes.remove(0); // 对此结点（null）完成反序列化，及时从nodes中去除
            return null;
        }
        com.tridu33.mineOJ.Graph.Trees.TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0); // 对此结点完成反序列化，及时从nodes中去除
        root.left = toTree(nodes);
        root.right = toTree(nodes);
        return root;
    }
}