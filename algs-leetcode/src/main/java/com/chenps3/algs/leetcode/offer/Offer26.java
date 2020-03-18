package com.chenps3.algs.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 二叉树
 *
 * @Author chenguanhong
 * @Date 2020/3/11
 */
public class Offer26 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);

        TreeNode b = new TreeNode(2);
        b.left = new TreeNode(4);

        System.out.println(isSubStructure(a, b));
    }

    public static boolean isSubStructure(TreeNode a, TreeNode b) {
        boolean result = false;
        if (a != null && b != null) {
            if (a.val == b.val) {
                result = treeAHasTreeB(a, b);
            }
            if (!result) {
                result = isSubStructure(a.left, b);
            }
            if (!result) {
                result = isSubStructure(a.right, b);
            }
        }
        return result;
    }

    private static boolean treeAHasTreeB(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return treeAHasTreeB(a.left, b.left) && treeAHasTreeB(a.right, b.right);
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
