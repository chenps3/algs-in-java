package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/3/13
 */
public class Offer33 {

    public static void main(String[] args) {
        int[] a1 = {3, 4, 7, 6, 5};
        int[] a2 = {3, 8, 4, 7, 6, 5};
        System.out.println(verifyPostorderV2(a1));
        System.out.println(verifyPostorderV2(a2));
    }

    //法2：从左向右遍历，遇到第一个大于root的数时，左边是左子树，剩下是右子树
    public static boolean verifyPostorderV2(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return helper2(postorder, 0, postorder.length - 1);
    }

    private static boolean helper2(int[] postorder, int lo, int hi) {
        int root = postorder[hi];
        int k = lo;
        while (k < hi) {
            if (postorder[k] > root) {
                break;
            }
            k++;
        }
        //k右边的数必须都大于root
        for (int i = k; i < hi; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        boolean left = true;
        boolean right = true;
        if (k > lo) {
            left = helper2(postorder, lo, k - 1);
        }
        if (k <= hi - 1) {
            right = helper2(postorder, k, hi - 1);
        }
        return left && right;
    }

    //法1：从右向左遍历，遇到的第一个大于root的数是右子树的根，第一个小于root的数是左子树的根
    public static boolean verifyPostorderV1(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return helper1(postorder, 0, postorder.length - 1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static boolean helper1(int[] postorder, int lo, int hi, int max, int min) {
        int rightTreeRoot = -1;
        int leftTreeRoot = -1;
        int root = postorder[hi];
        for (int i = hi; i >= lo; i--) {
            if (rightTreeRoot == -1 && postorder[i] > root) {
                rightTreeRoot = i;
            }
            if (leftTreeRoot == -1 && postorder[i] < root) {
                leftTreeRoot = i;
            }
            if (postorder[i] > max || postorder[i] < min) {
                return false;
            }
        }
        if (rightTreeRoot == -1 && leftTreeRoot == -1) {
            return true;
        }
        if (rightTreeRoot != -1 && leftTreeRoot != -1) {
            return helper1(postorder, lo, leftTreeRoot, root, min) && helper1(postorder, leftTreeRoot + 1, rightTreeRoot, max, root);
        }
        if (leftTreeRoot != -1) {
            return helper1(postorder, lo, leftTreeRoot, root, min);
        } else {
            return helper1(postorder, lo, rightTreeRoot, max, root);
        }
    }
}
