package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @Author chenguanhong
 * @Date 2020-03-10
 */
public class Offer22 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        ListNode n2 = getKthFromEnd(n1,3);
        System.out.println();
    }

    //双指针
    //指针1出发k步后，指针2出发
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode n1 = head;
        ListNode n2 = head;
        while (k-- > 0) {
            if(n1 == null){
                return null;
            }
            n1 = n1.next;
        }
        while (n1 != null){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n2;
    }


    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
