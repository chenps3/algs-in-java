package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020-03-03
 */
public class Problem114 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }


    public static void flatten(TreeNode root) {
        flattenHelper(root);
    }

    //返回flatten的链表尾部
    private static TreeNode flattenHelper(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return node;
        }
        if (node.left == null) {
            return flattenHelper(node.right);
        }
        if (node.right == null) {
            node.right = node.left;
            node.left = null;
            return flattenHelper(node.right);
        }
        TreeNode newLeftTail = flattenHelper(node.left);
        TreeNode oldRight = node.right;
        node.right = node.left;
        node.left = null;
        newLeftTail.right = oldRight;
        return flattenHelper(node.right);
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
