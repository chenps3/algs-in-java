package com.chenps3.algs.leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * <p>
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020-03-05
 */
public class Problem144 {

    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(3);
//        t1.right = new TreeNode(1);
//        t1.right.left = new TreeNode(2);
//        print(preorderTraversalV2(t1));

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        print(preorderTraversalV2(t2));
    }

    private static void print(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    //法2:迭代实现
    public static List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    //法1:递归实现
    public static List<Integer> preorderTraversalV1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preHelper(root, list);
        return list;
    }

    private static void preHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preHelper(node.left, list);
        preHelper(node.right, list);
    }


    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
