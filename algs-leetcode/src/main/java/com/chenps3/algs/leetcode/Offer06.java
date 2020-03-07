package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 链表
 *
 * @Author chenguanhong
 * @Date 2020-03-06
 */
public class Offer06 {

    public static int[] reversePrint(ListNode head) {
        int size = listSize(head);
        int[] output = new int[size];
        int k = size - 1;
        while (head != null) {
            output[k--] = head.val;
            head = head.next;
        }
        return output;
    }

    private static int listSize(ListNode head) {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
