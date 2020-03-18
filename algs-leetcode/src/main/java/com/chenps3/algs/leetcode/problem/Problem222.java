package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020-03-05
 */
public class Problem222 {

    public static void main(String[] args) {

    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
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
