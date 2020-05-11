package com.chenps3.algs.leetcode.problem;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @Author chenguanhong
 * @Date 2020/5/10
 */
public class Problem236 {

    public static void main(String[] args) {

    }

    //法2：递归
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return answer;
    }

    private static TreeNode answer = null;

    //二叉树tree是否包含节点p或q
    private static boolean dfs(TreeNode tree, TreeNode p, TreeNode q) {
        if (tree == null) {
            return false;
        }
        boolean left = dfs(tree.left, p, q);
        boolean right = dfs(tree.right, p, q);
        //left && right： p q 都在tree 的子树
        //(tree == p || tree == q) && (left || right): p q其中一个就是tree
        if ((left && right) || ((tree == p || tree == q) && (left || right))) {
            answer = tree;
        }
        return (tree == p || tree == q) || left || right;
    }

    //法1：存储父节点
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //先序遍历树，存储每个节点的父节点
        Map<TreeNode, TreeNode> map = new HashMap<>();
        preOrder(root, map);
        //从p开始向上查找到根节点，放入set
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        //从q开始向上查找到根节点，第一个包含在set里的就是LCA
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = map.get(q);
        }
        return null;
    }

    private static void preOrder(TreeNode node, Map<TreeNode, TreeNode> map) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.put(node.left, node);
        }
        if (node.right != null) {
            map.put(node.right, node);
        }
        preOrder(node.left, map);
        preOrder(node.right, map);
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
