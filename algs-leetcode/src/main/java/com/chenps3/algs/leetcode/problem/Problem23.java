package com.chenps3.algs.leetcode.problem;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 链表
 * 优先队列+多路归并
 *
 * @Author chenguanhong
 * @Date 2020/5/1
 */
public class Problem23 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode ans = mergeKLists(lists);
        ListNode t = ans;
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                Comparator.comparingInt(i -> i.val)
        );
        ListNode result = new ListNode(Integer.MIN_VALUE);
        Map<ListNode, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                pq.add(head);
                indexMap.put(head, i);
                lists[i] = head.next;
            }
        }
        ListNode tmp = result;
        while (!pq.isEmpty()) {
            ListNode next = pq.poll();
            tmp.next = next;
            int index = indexMap.get(next);
            ListNode head = lists[index];
            if (head != null) {
                pq.add(head);
                indexMap.put(head, index);
                lists[index] = head.next;
            }
            tmp = tmp.next;
        }
        return result.next;
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
