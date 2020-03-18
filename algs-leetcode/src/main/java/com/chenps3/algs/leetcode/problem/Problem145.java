package com.chenps3.algs.leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * <p>
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020-03-05
 */
public class Problem145 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);
        t.right.left = new TreeNode(3);
        print(postorderTraversalV2(t));
    }

    private static void print(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    //法2：迭代实现，利用addFirst，倒着输出，即中右左addFirst
    public static List<Integer> postorderTraversalV2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
            list.addFirst(node.val);
        }
        return list;
    }

    //法1：递归实现
    public static List<Integer> postorderTraversalV1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postHelper(root, list);
        return list;
    }

    private static void postHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postHelper(node.left, list);
        postHelper(node.right, list);
        list.add(node.val);
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
