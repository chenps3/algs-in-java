package com.chenps3.algs.leetcode.problem;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author chenguanhong
 * @Date 2020-02-22
 */
public class Problem103 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> levelOrder = zigzagLevelOrder(root);
        for (List<Integer> list : levelOrder) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (level % 2 == 0) {
                    //偶数层新元素直接插到队首，从而逆序
                    list.addFirst(node.val);
                }else{
                    list.add(node.val);
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() > 0) {
                result.add(list);
                level++;
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
