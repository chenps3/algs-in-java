package com.chenps3.algs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author chenguanhong
 * @Date 2020-02-21
 */
public class Problem102 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> levelOrder = levelOrder(root);
        for (List<Integer> list : levelOrder) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        queue.add(root);
        levelQueue.add(1);
        List<Integer> list = new ArrayList<>();
        result.add(list);
        int listLevel = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer level = levelQueue.poll();
            if (node != null && level != null) {
                queue.add(node.left);
                levelQueue.add(level + 1);
                queue.add(node.right);
                levelQueue.add(level + 1);

                if (level == listLevel) {
                    list.add(node.val);
                } else {
                    list = new ArrayList<>();
                    result.add(list);
                    list.add(node.val);
                    listLevel++;
                }
            }
        }
        return result;
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
