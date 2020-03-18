package com.chenps3.algs.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @Author chenguanhong
 * @Date 2020-02-22
 */
public class Problem105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode t = buildTree(preorder, inorder);
    }

    //减少查找root的时间
    private static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    //左闭右开
    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                            int preorderBegin, int preorderEnd,
                                            int inorderBegin, int inorderEnd) {
        if (preorderBegin == preorderEnd) {
            return null;
        }
        //先序的第一个元素是根
        TreeNode root = new TreeNode(preorder[preorderBegin]);
        //中序 根的下标
        int inorderRootIndex = map.get(root.val);

        //左子树
        int leftSize = inorderRootIndex - inorderBegin;
        //先序
        int leftPreorderBegin = preorderBegin + 1;
        int leftPreorderEnd = preorderBegin + leftSize + 1;     //leftPreorderBegin + leftSize
        //中序
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = inorderRootIndex;   //leftInorderBegin + leftSize
        root.left = buildTreeHelper(preorder, inorder, leftPreorderBegin, leftPreorderEnd, leftInorderBegin, leftInorderEnd);

        //右子树
        //先序
        int rightPreorderBegin = preorderBegin + leftSize + 1;
        int rightPreorderEnd = preorderEnd;
        //中序
        int rightInorderBegin = inorderRootIndex + 1;
        int rightInorderEnd = inorderEnd;
        root.right = buildTreeHelper(preorder, inorder, rightPreorderBegin, rightPreorderEnd, rightInorderBegin, rightInorderEnd);
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
