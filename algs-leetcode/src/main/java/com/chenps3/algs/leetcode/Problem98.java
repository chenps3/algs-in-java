package com.chenps3.algs.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * <p>
 * tree
 *
 * @Author chenguanhong
 * @Date 2020-02-18
 */
public class Problem98 {

    public static void main(String[] args) {
        Problem98 p = new Problem98();
        Integer[] input = {1, 1};
        TreeNode t = p.construct(input);
        System.out.println(p.isValidBST(t));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && min >= node.val) {       //or  min > node.val?
            return false;
        }
        if (max != null && max <= node.val) {       //or  max < node.val?
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    private TreeNode construct(Integer[] input) {
        if (input.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(input[0]);
        List<TreeNode> nodeArr = new ArrayList<>();
        nodeArr.add(root);
        for (int i = 1; i < input.length; i++) {
            TreeNode curr = input[i] == null ? null : new TreeNode(input[i]);
            TreeNode parent = nodeArr.get((i - 1) / 2);
            if (parent != null) {
                if (i % 2 != 0) {
                    parent.left = curr;
                } else {
                    parent.right = curr;
                }
            }
            nodeArr.add(curr);
        }
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
