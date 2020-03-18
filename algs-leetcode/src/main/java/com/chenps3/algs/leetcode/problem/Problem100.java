package com.chenps3.algs.leetcode.problem;


/**
 * https://leetcode-cn.com/problems/same-tree/submissions/
 *
 * 树
 * @Author chenguanhong
 * @Date 2020-02-21
 */
public class Problem100 {

    public static void main(String[] args) {
        Problem100 p = new Problem100();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(4);

        System.out.println(p.isSameTree(t1, t2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
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
