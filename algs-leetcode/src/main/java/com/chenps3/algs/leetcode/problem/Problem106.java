package com.chenps3.algs.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * <p>
 * 树
 *
 * @Author chenguanhong
 * @Date 2020-02-22
 */
public class Problem106 {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode t = buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    //左闭右开
    public static TreeNode buildTreeHelper(int[] inorder, int[] postorder,
                                           int inorderBegin, int inorderEnd,
                                           int postorderBegin, int postorderEnd) {
        if (inorderBegin == inorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderEnd - 1]);
        int rootInorderIndex = map.get(postorder[postorderEnd - 1]);
        //左子树
        int leftSize = rootInorderIndex - inorderBegin;
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = rootInorderIndex;
        int leftPostorderBegin = postorderBegin;
        int leftPostorderEnd = postorderBegin + leftSize;
        root.left = buildTreeHelper(inorder, postorder, leftInorderBegin, leftInorderEnd, leftPostorderBegin, leftPostorderEnd);

        //右子树
        int rightInorderBegin = rootInorderIndex + 1;
        int rightInorderEnd = inorderEnd;
        int rightPostorderBegin = postorderBegin + leftSize;    //即leftPostorderEnd
        int rightPostorderEnd = postorderEnd - 1;
        root.right = buildTreeHelper(inorder, postorder, rightInorderBegin, rightInorderEnd, rightPostorderBegin, rightPostorderEnd);
        return root;
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
