package com.chenps3.algs.leetcode.problem;

import com.chenps3.algs.leetcode.Review;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @Author chenguanhong
 * @Date 2020/5/2
 */
public class Problem206 {

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l = reverseList(l);
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
