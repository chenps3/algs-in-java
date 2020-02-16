package com.chenps3.algs.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * bst
 *
 * @Author chenguanhong
 * @Date 2020-02-16
 */
public class Problem1038 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Integer[] input = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode bst = bst(input);
        levelOrder(bst, input.length);
        traversal(bst, 0);
        levelOrder(bst, input.length);
    }


    //根据输入构造bst
    private static TreeNode bst(Integer[] input) {
        TreeNode root = new TreeNode(input[0]);
        List<TreeNode> levelOrder = new LinkedList<>();
        levelOrder.add(root);
        for (int i = 1; i < input.length; i++) {
            TreeNode currNode = input[i] == null ? null : new TreeNode(input[i]);
            TreeNode parent = levelOrder.get((i - 1) / 2);
            if (parent != null) {
                if (i % 2 != 0) {
                    parent.left = currNode;
                } else {
                    parent.right = currNode;
                }
            }
            levelOrder.add(currNode);
        }
        return root;
    }

    //层序遍历输出
    private static void levelOrder(TreeNode root, int size) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = queue.poll();
        int k = size;
        while (k-- > 0) {
            if (node != null) {
                System.out.print(node.val);
                System.out.print("  ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null  ");
            }
            node = queue.poll();
        }
        System.out.println();
    }

    public TreeNode bstToGst(TreeNode root) {
        traversal(root,0);
        return root;
    }

    //按右中左的顺序遍历
    private static int traversal(TreeNode node, Integer accumulate) {
        if (node.right != null) {
            accumulate = traversal(node.right, accumulate);
        }
        int oldVal = node.val;
        node.val += accumulate;
        accumulate += oldVal;
        if (node.left != null) {
            accumulate = traversal(node.left, accumulate);
        }
        return accumulate;
    }

}
