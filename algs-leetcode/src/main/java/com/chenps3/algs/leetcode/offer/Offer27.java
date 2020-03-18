package com.chenps3.algs.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020/3/12
 */
public class Offer27 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
        mirrorTree(t);
        System.out.println();
    }

    public static TreeNode mirrorTree(TreeNode root) {
        preOrder(root);
        return root;
    }

    //遍历+逐个交换
    private static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        preOrder(node.left);
        preOrder(node.right);
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
