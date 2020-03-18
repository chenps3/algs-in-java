package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020-03-03
 */
public class Problem116 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connectV1(root);
    }

    //法2 拉链法，把完美二叉树劈成两半，先处理大的两半二叉树中间的左右连接，然后递归处理小的连接
    public static Node connectV2(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connectV2(root.left);
        connectV2(root.right);
        return root;
    }


    //法1：基于递归的层序遍历
    public static Node connectV1(Node root) {
        int depth = getDepth(root);
        for (int i = 1; i <= depth; i++) {
            levelOrderHelper(root, i);
            prevNode = null;
        }
        return root;
    }

    //基于递归的层序遍历
    //打印二叉树的第k层，可以看作以root->_left为根节点，打印它的k-1层，然后以root->_right为根节点，打印它的k-1层，直到k==1。
    private static void levelOrderHelper(Node node, int level) {
        if (node == null || level < 1) {
            return;
        }
        if (level == 1) {
            if (prevNode != null) {
                prevNode.next = node;
            }
            prevNode = node;
            return;
        }
        levelOrderHelper(node.left, level - 1);
        levelOrderHelper(node.right, level - 1);
    }

    private static Node prevNode = null;

    private static int getDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + max(getDepth(node.left), getDepth(node.right));
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}


