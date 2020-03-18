package com.chenps3.algs.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * <p>
 * 树
 *
 * @Author chenguanhong
 * @Date 2020-02-19
 */
public class Problem501 {

    private List<Integer> list = new ArrayList<>();

    private int cur = 1;

    private int max = 0;

    TreeNode pre;

    public static void main(String[] args) {
        Problem501 p = new Problem501();
        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
        int[] k = p.findMode(root);
        for (int i = 0; i < k.length; i++) {
            System.out.println(k[i]);
        }
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        traversal(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void traversal(TreeNode curr) {
        if (curr == null) {
            return;
        }
        traversal(curr.left);
        if (pre != null) {
            if (curr.val == pre.val) {
                cur++;
            } else {
                cur = 1;
            }
        }
        if (cur > max) {
            max = cur;
            list.clear();
            list.add(curr.val);
        } else if (cur == max) {
            list.add(curr.val);
        }

        pre = curr;

        traversal(curr.right);
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
