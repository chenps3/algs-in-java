package com.chenps3.algs.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/3/16
 */
public class Offer36 {

    public static void main(String[] args) {
        Node t = new Node(4);
        t.left = new Node(2);
        t.right = new Node(5);
        t.left.left = new Node(1);
        t.left.right = new Node(3);
        Node s = treeToDoublyList(t);
        System.out.println();
    }

    //配合列表中序遍历
    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        inOrder(root, list);
        list.get(0).left = list.get(list.size() - 1);
        list.get(list.size() - 1).right = list.get(0);
        return list.get(0);
    }

    private static void inOrder(Node node, List<Node> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        if (list.size() > 0) {
            Node prev = list.get(list.size() - 1);
            prev.right = node;
            node.left = prev;
        }
        list.add(node);
        inOrder(node.right, list);
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
