package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 链表
 *
 * @Author chenguanhong
 * @Date 2020-03-10
 */
public class Offer25 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = mergeTwoListsV2(l1, l2);
        System.out.println();
    }

    //法2：迭代实现
    public static ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null) {
            tail.next = l2;
        }
        if (l2 == null) {
            tail.next = l1;
        }
        return dummyHead.next;
    }

    //法1：递归
    public static ListNode mergeTwoListsV1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoListsV1(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoListsV1(l1, l2.next);
        }
        return head;
    }


    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
