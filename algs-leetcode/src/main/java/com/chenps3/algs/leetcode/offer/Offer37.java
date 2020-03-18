package com.chenps3.algs.leetcode.offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author chenguanhong
 * @Date 2020/3/17
 */
public class Offer37 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.right.left = new TreeNode(4);
        t.right.right = new TreeNode(5);

        String s = serialize(t);
        TreeNode tt = deserialize(s);
        System.out.println();
    }


    //层序遍历序列化
    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t == null) {
                sb.append("null,");
            } else {
                sb.append(t.val).append(",");
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] list = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            node.left = getNode(list[i++]);
            node.right = getNode(list[i++]);
            queue.add(node.left);
            queue.add(node.right);
        }
        return root;
    }

    private static TreeNode getNode(String s) {
        if (s.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(s));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
