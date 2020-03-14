package com.chenps3.algs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/3/13
 */
public class Offer32III {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        queue.add(root);
        int levelNumber = 0;
        while (!queue.isEmpty()) {
            ++levelNumber;
            int levelSize = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            while (levelSize-- > 0) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
                if (levelNumber % 2 != 0) {
                    levelList.add(t.val);
                }else {
                    levelList.addFirst(t.val);
                }
            }
            list.add(levelList);
        }
        return list;
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
