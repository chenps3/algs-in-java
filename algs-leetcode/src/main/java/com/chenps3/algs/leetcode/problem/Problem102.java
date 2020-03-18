package com.chenps3.algs.leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
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

    //基于队列的层序遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currLevelSize = queue.size();       //重点
            List<Integer> currLevelVal = new ArrayList<>();
            while (currLevelSize-- > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    currLevelVal.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (currLevelVal.size() > 0) {
                res.add(currLevelVal);
            }
        }
        return res;
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
