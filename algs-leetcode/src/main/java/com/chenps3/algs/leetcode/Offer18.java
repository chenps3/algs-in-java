package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @Author chenguanhong
 * @Date 2020-03-10
 */
public class Offer18 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
        l1 = deleteNode(l1, 1);
        System.out.println();
    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node != null && node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return dummy.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
