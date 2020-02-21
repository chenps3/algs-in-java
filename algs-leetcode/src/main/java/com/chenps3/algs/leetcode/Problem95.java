package com.chenps3.algs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 树
 *
 * @Author chenguanhong
 * @Date 2020-02-20
 */
public class Problem95 {

    public static void main(String[] args) {
        Problem95 p = new Problem95();
        List<TreeNode> list = p.generateTrees(3);
        System.out.println(list);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return generateTree(1, n);
    }

    //bst最大值为max，最小值为min
    private List<TreeNode> generateTree(int min, int max) {
        List<TreeNode> list = new LinkedList<>();
        if (min > max) {
            list.add(null);         //保证left和right都不是空列表
            return list;
        }
        if (min == max) {
            list.add(new TreeNode(min));
            return list;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> left = generateTree(min, i - 1);
            List<TreeNode> right = generateTree(i + 1, max);
            for (TreeNode lt : left) {
                for (TreeNode rt : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    list.add(root);
                }
            }
        }
        return list;
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
