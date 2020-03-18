package com.chenps3.algs.leetcode.problem;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020-03-05
 */
public class Problem173 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(7);
        t.left = new TreeNode(3);
        t.right = new TreeNode(15);
        t.right.left = new TreeNode(9);
        t.right.right = new TreeNode(20);
        Problem173 p = new Problem173(t);
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.next());
    }

    public Problem173(TreeNode root) {
        inorder(root);
        iterator = queue.iterator();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return iterator.next();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        queue.add(node.val);
        inorder(node.right);
    }

    private Queue<Integer> queue = new LinkedList<>();

    private Iterator<Integer> iterator;

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
