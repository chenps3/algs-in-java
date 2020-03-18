package com.chenps3.algs.leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020-03-05
 */
public class Problem199 {

    public static void main(String[] args) {

    }

    //层序遍历后取每层的最右边
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> levelOrder = levelOrder(root);
        for (List<Integer> list : levelOrder) {
            res.add(list.get(list.size() - 1));
        }
        return res;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> thisLevel = new ArrayList<>();
            while (levelSize-- > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    thisLevel.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (thisLevel.size() > 0) {
                res.add(thisLevel);
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
