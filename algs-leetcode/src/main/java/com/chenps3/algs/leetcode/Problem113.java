package com.chenps3.algs.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @Author chenguanhong
 * @Date 2020-03-02
 */
public class Problem113 {

    public static void main(String[] args) {

    }

    //法2：基于递归的dfs
    public static List<List<Integer>> pathSumV2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> rootPathVal = new ArrayList<>();
        dfsHelper(res, root, sum, rootPathVal);
        return res;
    }

    private static void dfsHelper(List<List<Integer>> res, TreeNode node, int sum, List<Integer> pathVal) {
        sum -= node.val;
        pathVal.add(node.val);
        if (isLeaf(node)) {
            if (sum == 0) {
                res.add(new ArrayList<>(pathVal));
            }
            pathVal.remove(pathVal.size() - 1);     //回到递归上一层之前删除当前节点的值，不然也可以在xx处复制一份pathVal
            return;
        }
        if (node.left != null) {
            dfsHelper(res, node.left, sum, pathVal);        //xx
        }
        if (node.right != null) {
            dfsHelper(res, node.right, sum, pathVal);       //xx
        }
        pathVal.remove(pathVal.size() - 1);        //回到递归上一层之前删除当前节点的值，不然也可以在xx处复制一份pathVal
    }

    //法1：基于栈的dfs
    public static List<List<Integer>> pathSumV1(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreePath> allPath = new ArrayList<>();
        nodeStack.push(root);
        List<Integer> pathVal = new ArrayList<>();
        pathVal.add(root.val);
        pathStack.push(new TreePath(pathVal, root.val));
        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.pop();
            TreePath currPath = pathStack.pop();
            if (isLeaf(currNode)) {
                allPath.add(currPath);
            } else {
                if (currNode.left != null) {
                    nodeStack.push(currNode.left);
                    List<Integer> nextPathVal = new ArrayList<>(currPath.pathVal);
                    nextPathVal.add(currNode.left.val);
                    pathStack.push(new TreePath(nextPathVal, currPath.sum + currNode.left.val));
                }
                if (currNode.right != null) {
                    nodeStack.push(currNode.right);
                    List<Integer> nextPathVal = new ArrayList<>(currPath.pathVal);
                    nextPathVal.add(currNode.right.val);
                    pathStack.push(new TreePath(nextPathVal, currPath.sum + currNode.right.val));
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (TreePath i : allPath) {
            if (i.sum == sum) {
                res.add(i.pathVal);
            }
        }
        return res;
    }


    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static Stack<TreeNode> nodeStack = new Stack<>();
    private static Stack<TreePath> pathStack = new Stack<>();


    private static class TreePath {
        List<Integer> pathVal;
        int sum;

        public TreePath(List<Integer> pathVal, int sum) {
            this.pathVal = pathVal;
            this.sum = sum;
        }
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
