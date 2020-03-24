package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @Author chenguanhong
 * @Date 2020/3/23
 */
public class Problem876 {

    //快慢指针
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
