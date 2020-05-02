package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 链表
 *
 * @Author chenguanhong
 * @Date 2020/5/1
 */
public class Problem141 {

    public static void main(String[] args) {

    }

    //快慢指针检测链表的环
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
