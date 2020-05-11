package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/5/9
 */
public class Offer52 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
//        n3.next = n6;
        n4.next = n5;
//        n5.next = n6;
        n6.next = n7;

        ListNode common = getIntersectionNode(n1, n4);
        if (common == null) {
            System.out.println("null");
        } else {
            System.out.println(common.val);
        }
    }

    //双指针，证明：
    //headA长度为L1+C,headB长度为L2+C
    //headA走了长度L1+C后，从headB头部出发走L2步
    //headB走了长度L2+C后，从headA头部出发走L1步
    //两个指针都走了L1+L2+C步时，相遇在第一个公共节点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;
        while (head1 != head2) {        //null == null 为true
            head1 = head1 == null ? headB : head1.next;
            head2 = head2 == null ? headA : head2.next;
        }
        return head1;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

