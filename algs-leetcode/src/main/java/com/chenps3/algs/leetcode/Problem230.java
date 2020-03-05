package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * <p>
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-28
 */
public class Problem230 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(4);
        t1.left.right = new TreeNode(2);
        System.out.println(kthSmallest(t1, 1) == 1);

        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(6);
        t2.left.left = new TreeNode(2);
        t2.left.right = new TreeNode(4);
        t2.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest(t2, 3) == 3);
    }

    public static int kthSmallest(TreeNode root, int k) {
        TreeNode node = select(root, k - 1);
        return node.val;
    }

    //求排行第k+1的节点
    private static TreeNode select(TreeNode node, int k) {
        if (node == null) {
            return null;
        }
        int t = size(node.left);
        if (t == k) {
            return node;
        } else if (t > k) {
            return select(node.left, k);
        } else if (t < k) {
            return select(node.right, k - t - 1);
        }
        return null;
    }

    private static int size(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
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
