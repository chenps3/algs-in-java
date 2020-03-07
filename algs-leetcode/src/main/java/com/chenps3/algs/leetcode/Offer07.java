package com.chenps3.algs.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 *
 * @Author chenguanhong
 * @Date 2020-03-06
 */
public class Offer07 {

    public static void main(String[] args) {
        int[] p1 = {3, 9, 20, 15, 7};
        int[] i1 = {9, 3, 15, 20, 7};
        TreeNode t = buildTree(p1, i1);
        System.out.println();
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    //左闭右闭
    private static TreeNode helper(int[] preorder, int[] inorder, int pBegin, int pEnd, int iBegin, int iEnd) {
        if (pBegin > pEnd) {
            return null;
        }
        int rootVal = preorder[pBegin];
        TreeNode root = new TreeNode(rootVal);
        int rootInIndex = map.get(rootVal);

        int leftSize = rootInIndex - iBegin;

        int leftPreBegin = pBegin + 1;
        int leftPreEnd = pBegin + leftSize;        // leftPreBegin + leftSize - 1
        int leftInBegin = iBegin;
        int leftInEnd = rootInIndex - 1;               // leftInBegin + leftSize - 1

        int rightPreBegin = pBegin + leftSize + 1;       //leftPreEnd + 1
        int rightPreEnd = pEnd;
        int rightInBegin = rootInIndex + 1;
        int rightInEnd = iEnd;

        root.left = helper(preorder, inorder, leftPreBegin, leftPreEnd, leftInBegin, leftInEnd);
        root.right = helper(preorder, inorder, rightPreBegin, rightPreEnd, rightInBegin, rightInEnd);
        return root;
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
