package com.chenps3.algs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/3/12
 */
public class Offer28 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(2);
//        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(3);
//        t.right.left = new TreeNode(4);
        t.right.right = new TreeNode(3);
        System.out.println(isSymmetricV1(t));
    }

    //法2：如果对称，中左右遍历 和 中右左遍历的顺序是一样的
    public static boolean isSymmetricV2(TreeNode root) {
        return isSymmetricHelper(root, root);
    }

    //t1执行中左右遍历，t2执行中右左遍历
    private static boolean isSymmetricHelper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetricHelper(t1.left, t2.right) && isSymmetricHelper(t1.right, t2.left);
    }

    //法1：层序遍历，每层都是对称的
    public static boolean isSymmetricV1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (t == null) {
                    list.add(null);
                } else {
                    list.add(t.val);
                    queue.add(t.left);
                    queue.add(t.right);
                }
            }
            if (!levelIsSymmetric(list)) {
                return false;
            }
        }
        return true;
    }

    private static boolean levelIsSymmetric(List<Integer> list) {
        int len = list.size();
        if (len == 1) {
            return true;
        }
        if (len % 2 != 0) {
            return false;
        }
        for (int i = 0; i < len / 2; i++) {
            Integer i1 = list.get(i);
            Integer i2 = list.get(len - 1 - i);
            if (i1 == null && i2 == null) {
                continue;
            }
            if (i1 == null || i2 == null) {
                return false;
            }
            if (!i1.equals(i2)) {
                return false;
            }
        }
        return true;
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
