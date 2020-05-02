package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第N个节点
 *
 * @Author chenguanhong
 * @Date 2020/5/2
 */
public class Problem19 {

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        n = removeNthFromEnd(n, 3);
        System.out.println();
    }

    //虚拟节点做头部
    //快指针先前进n步
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n-- > 0) {
            if (fast.next == null) {        //走不到n步，说明不用删除
                return dummy.next;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //此时slow指向倒数第n个节点的前驱
        slow.next = slow.next.next;
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
