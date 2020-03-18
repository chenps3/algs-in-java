package com.chenps3.algs.leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * <p>
 * 树
 *
 * @Author chenguanhong
 * @Date 2020-02-21
 */
public class Problem101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
        root.right.left = new TreeNode(5);

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        Integer[] arr = treeToArray(root);
        for (int i = 1; i < arr.length; i++) {
            int symmetricIndex = getSymmetricIndex(i);
            if (symmetricIndex >= arr.length) {
                if (arr[i] != null) {
                    return false;
                } else {
                    continue;
                }
            }
            if (arr[symmetricIndex] == null && arr[i] == null) {
                continue;
            }
            if (arr[symmetricIndex] == null || arr[i] == null) {
                return false;
            }
            if (!arr[symmetricIndex].equals(arr[i])) {
                return false;
            }
        }
        return true;
    }


    //解法1递归
    private static boolean sulution1(TreeNode root) {
        return false;
    }

    //解法2迭代
    private static boolean solution2(TreeNode root) {
        return false;
    }

    //k的对称坐标，从1开始计算
    private static int getSymmetricIndex(int k) {
        //确定k是第几层
        int level = getLevel(k);
        int left = power(level - 1);
        int right = power(level) - 1;
        return right - (k - left);
    }

    private static int power(int n) {
        int x = 1;
        while (n-- > 0) {
            x *= 2;
        }
        return x;
    }

    private static int getLevel(int k) {
        int i = 0;
        while (k > 0) {
            k = k / 2;
            i++;
        }
        return i;
    }

    //对称二叉树一定是个完全二叉树
    //层序遍历
    private static Integer[] treeToArray(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node != null) {
                values.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                values.add(null);
            }
        }
        Integer[] result = new Integer[values.size() + 1];
        for (int i = 1; i < values.size() + 1; i++) {
            result[i] = values.get(i - 1);
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
