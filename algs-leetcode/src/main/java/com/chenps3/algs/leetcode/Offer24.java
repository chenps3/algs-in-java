package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @Author chenguanhong
 * @Date 2020-03-10
 */
public class Offer24 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        ListNode n2 = reverseListV2(n1);
        System.out.println();
    }

    //法2：迭代实现
    public static ListNode reverseListV2(ListNode head) {
        ListNode res = null;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            if (next == null) {
                res = curr;
            }
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return res;
    }


    //法1：递归实现
    public static ListNode reverseListV1(ListNode head) {
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        helper(head);
        return tail;
    }

    private static ListNode helper(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        ListNode prev = helper(node.next);
        prev.next = node;
        node.next = null;
        return node;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}


