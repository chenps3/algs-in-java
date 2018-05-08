package com.chenps3.algs.leetcode.linkedList;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class Problem21 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /*
      使用虚拟结点做头部
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
