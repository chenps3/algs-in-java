package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/hot-100-9er-cha-shu-de-zhi-jing-python3-di-gui-ye-/
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020-03-10
 */
public class Problem543 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(t1));
        t1.left.left.left = new TreeNode(6);
        t1.left.left.left.left = new TreeNode(9);
        t1.left.right.right = new TreeNode(7);
        t1.left.right.right.right = new TreeNode(8);
        System.out.println(diameterOfBinaryTree(t1));

    }

    private static int diameter = 0;

    //直径一定等于某个节点的左子树深度+右子树深度
    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        diameter = max(diameter, left + right);
        return 1 + max(left, right);
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
