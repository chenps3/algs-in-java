package com.chenps3.algs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/3/15
 */
public class Offer35 {
    public static void main(String[] args) {
        Node t0 = new Node(7);
        Node t1 = new Node(13);
        Node t2 = new Node(11);
        Node t3 = new Node(10);
        Node t4 = new Node(1);
        t0.next = t1;
        t0.random = null;
        t1.next = t2;
        t1.random = t0;
        t2.next = t3;
        t2.random = t4;
        t3.next = t4;
        t3.random = t2;
        t4.next = null;
        t4.random = t0;
        Node ans = new Offer35().copyRandomList3(t0);
        System.out.println();
    }


    //法3：分治法，空间复杂度O(1)
    //1 创建copy节点，放在原始节点之后
    //2 设置copy节点的random
    //3 拆分，偶数节点的就是copy
    public Node copyRandomList3(Node head) {
        copy(head);
        setRandom(head);
        return split(head);
    }

    private void copy(Node head) {
        Node node = head;
        while (node != null) {
            Node tmp = node.next;
            node.next = new Node(node.val);
            node.next.next = tmp;
            node = tmp;
        }
    }

    private void setRandom(Node head) {
        Node node = head;
        while (node != null) {
            Node copy = node.next;
            if (node.random != null) {
                copy.random = node.random.next;
            }
            node = copy.next;
        }
    }

    private Node split(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        Node copyHead = head.next;
        Node copyNode = head.next;
        node.next = copyNode.next;
        node = node.next;
        while (node != null) {
            copyNode.next = node.next;
            copyNode = copyNode.next;
            node.next = copyNode.next;
            node = node.next;
        }
        return copyHead;
    }

    //法2：利用hashmap O(n)
    public Node copyRandomList2(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    //法1：O(n²)遍历
    public Node copyRandomList1(Node head) {
        List<Node> source = new ArrayList<>();
        Node node = head;
        while (node != null) {
            source.add(node);
            node = node.next;
        }
        List<Node> copy = new ArrayList<>();
        for (Node n : source) {
            copy.add(new Node(n.val));
        }
        for (int i = 0; i < copy.size() - 1; i++) {
            copy.get(i).next = copy.get(i + 1);
        }
        for (int i = 0; i < source.size(); i++) {
            Node tmp = source.get(i);
            for (int j = 0; j < source.size(); j++) {
                if (tmp.random == source.get(j)) {
                    copy.get(i).random = copy.get(j);
                }
            }
        }
        if (copy.size() > 0) {
            return copy.get(0);
        }
        return null;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
