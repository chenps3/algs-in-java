package com.chenps3.algs.leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020-03-03
 */
public class Problem129 {


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(0);
        t1.left.left = new TreeNode(5);
        t1.left.right = new TreeNode(1);
        System.out.println(sumNumbersV2(t1));
    }

    //法2：dfs过程中累加
    public static int sumNumbersV2(TreeNode root) {
        return dfsHelperV2(root, new StringBuilder());
    }


    private static int dfsHelperV2(TreeNode node, StringBuilder pathSum) {
        if (node == null) {
            return 0;
        }
        pathSum.append(node.val);
        if (node.left == null && node.right == null) {
            return Integer.valueOf(pathSum.toString());
        }
        int sum = 0;
        sum += dfsHelperV2(node.left, new StringBuilder(pathSum));
        sum += dfsHelperV2(node.right, new StringBuilder(pathSum));
        return sum;
    }

    //法1：dfs找出所有叶子的路径
    public static int sumNumbersV1(TreeNode root) {
//        List<List<Integer>> allPaths = new ArrayList<>();
//        dfsHelper(root, new ArrayList<>(), allPaths);
        List<List<Integer>> allPaths = stackDfs(root);
        int sum = 0;
        for (List<Integer> list : allPaths) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i);
            }
            sum += Integer.valueOf(sb.toString());
        }
        return sum;
    }

    //使用递归实现dfs
    private static void dfsHelper(TreeNode node, List<Integer> path, List<List<Integer>> allPaths) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(path));
            return;
        }
        dfsHelper(node.left, new ArrayList<>(path), allPaths);
        dfsHelper(node.right, new ArrayList<>(path), allPaths);
    }

    //使用栈实现dfs
    private static List<List<Integer>> stackDfs(TreeNode root) {
        List<List<Integer>> allPaths = new LinkedList<>();
        if (root == null) {
            return allPaths;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<List<Integer>> pathStack = new Stack<>();
        nodeStack.push(root);
        List<Integer> rootPath = new ArrayList<>();
        rootPath.add(root.val);
        pathStack.push(rootPath);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            List<Integer> path = pathStack.pop();

            if (node.left == null && node.right == null) {
                allPaths.add(path);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                List<Integer> leftPath = new ArrayList<>(path);
                leftPath.add(node.left.val);
                pathStack.push(leftPath);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                List<Integer> rightPath = new ArrayList<>(path);
                rightPath.add(node.right.val);
                pathStack.push(rightPath);
            }
        }
        return allPaths;
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
