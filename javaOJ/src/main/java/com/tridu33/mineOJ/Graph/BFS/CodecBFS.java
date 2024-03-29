package com.tridu33.mineOJ.Graph.BFS;
import com.tridu33.mineOJ.Graph.Trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringJoiner;

public class CodecBFS {
    public static void main(String[] args) {
        CodecBFS sol = new CodecBFS();
        System.out.println(sol.serialize(sol.deserialize("1,2,3,null,null,4,5")));
    }
    public String serialize(com.tridu33.mineOJ.Graph.Trees.TreeNode root) {
        if(root == null) return "";
        Queue<com.tridu33.mineOJ.Graph.Trees.TreeNode> q = new ArrayDeque<>();
        StringJoiner sj = new StringJoiner(",");
        q.add(root);
        sj.add(Integer.toString(root.val));
        while(!q.isEmpty()){
            com.tridu33.mineOJ.Graph.Trees.TreeNode head = q.remove();
            if(head.left != null){
                q.add(head.left);
                sj.add(Integer.toString(head.left.val));
            }
            else sj.add("null");
            if(head.right != null){
                q.add(head.right);
                sj.add(Integer.toString(head.right.val));
            }
            else sj.add("null");
        }
        return sj.toString();
    }
    public com.tridu33.mineOJ.Graph.Trees.TreeNode deserialize(String data) {
        if(data.length() == 0) return null; // 特判：data == ""
        String[] nodes = data.split(",");
        Queue<com.tridu33.mineOJ.Graph.Trees.TreeNode> q = new ArrayDeque<>();
        com.tridu33.mineOJ.Graph.Trees.TreeNode root = new com.tridu33.mineOJ.Graph.Trees.TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        int idx = 1, n = nodes.length;
        while(idx < n){ // 不必以!q.isEmpty()作为判断条件
            com.tridu33.mineOJ.Graph.Trees.TreeNode head = q.remove();
            if(!nodes[idx].equals("null")){
                com.tridu33.mineOJ.Graph.Trees.TreeNode left = new com.tridu33.mineOJ.Graph.Trees.TreeNode(Integer.parseInt(nodes[idx]));
                head.left = left; // left挂接到head
                q.add(left);
            }
            idx++;
            if(idx < n && !nodes[idx].equals("null")){
                com.tridu33.mineOJ.Graph.Trees.TreeNode right = new TreeNode(Integer.parseInt(nodes[idx]));
                head.right = right; // right挂接到head
                q.add(right);
            }
            idx++;
        }
        return root;
    }
}