package com.chenps3.algs.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/3/14
 */
public class Offer34 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return result;
    }

    private static void helper(TreeNode node, int sum, List<Integer> list) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<>(list));
                return;
            } else {
                return;
            }
        }
        helper(node.left, sum, new ArrayList<>(list));
        helper(node.right, sum, new ArrayList<>(list));
    }

    private static List<List<Integer>> result = new ArrayList<>();

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
