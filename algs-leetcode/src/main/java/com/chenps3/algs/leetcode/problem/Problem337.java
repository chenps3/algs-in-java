package com.chenps3.algs.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 * 树+动态规划
 *
 * @Author chenguanhong
 * @Date 2020/4/19
 */
public class Problem337 {

    public static void main(String[] args) {

    }

    //法2：使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
    //任何一个节点能偷到的最大钱的状态可以定义为
    //当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
    //当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
    public static int rob2(TreeNode root) {
        int[] res = robHelper2(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] robHelper2(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] res = new int[2];
        int[] left = robHelper2(node.left);
        int[] right = robHelper2(node.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + node.val;
        return res;
    }

    //法1：分解子问题+缓存中间结果
    public static int rob1(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return robHelper(root, map);
    }

    private static int robHelper(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        Integer val = map.get(node);
        if (val != null) {
            return val;
        }
        TreeNode n1 = null, n2 = null, n3 = null, n4 = null;
        if (node.left != null) {
            n1 = node.left.left;
            n2 = node.left.right;
        }
        if (node.right != null) {
            n3 = node.right.left;
            n4 = node.right.right;
        }
        int a = node.val + robHelper(n1, map) + robHelper(n2, map) + robHelper(n3, map) + robHelper(n4, map);
        int b = robHelper(node.left, map) + robHelper(node.right, map);
        val = Math.max(a, b);
        map.put(node, val);
        return val;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
