package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/3/30
 */
public class Offer62 {

    public static void main(String[] args) {
        System.out.println(lastRemaining1(5, 3));
        System.out.println(lastRemaining2(5, 3));

    }

    //法2：f(n,m) = [f(n-1,m)+m]%n
    public static int lastRemaining2(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int[] aux = new int[n + 1];
        aux[1] = 0;
        for (int i = 2; i < aux.length; i++) {
            aux[i] = (aux[i - 1] + m) % i;
        }
        return aux[n];
    }

    //法1：循环链表模拟，会超时
    public static int lastRemaining1(int n, int m) {
        if (n == 1) {
            return 0;
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 1; i < n; i++) {
            ListNode tmp = new ListNode(i);
            curr.next = tmp;
            tmp.prev = curr;
            curr = curr.next;
        }
        curr.next = head;
        head.prev = curr;
        curr = head;
        int cnt = n;
        while (cnt-- > 1) {
            ListNode remove = nodeToRemove(curr, m);
            ListNode prev = remove.prev;
            ListNode next = remove.next;
            prev.next = next;
            next.prev = prev;
            curr = next;
        }
        return curr.val;
    }

    private static ListNode nodeToRemove(ListNode node, int m) {
        while (m-- > 1) {
            node = node.next;
        }
        return node;
    }

    private static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
