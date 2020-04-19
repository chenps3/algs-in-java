package com.chenps3.algs.impl.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * Hashmap+自定义链表实现
 *
 * @Author chenguanhong
 * @Date 2020/4/8
 */
public class LRUCache<K, V> {

    private Map<K, Node<K, V>> map = new HashMap<>();
    private int count;
    private int capacity;
    private Node<K, V> head, tail;        //从头部插入，尾部删除

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        head = new Node<>();
        head.prev = null;
        tail = new Node<>();
        tail.post = null;
        head.post = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            node = new Node<>(key, value);
            map.put(key, node);
            addNode(node);
            ++count;
            if (count > capacity) {
                Node<K, V> tail = popTail();
                map.remove(tail.key);
                --count;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    //节点加到链表头部
    private void addNode(Node<K, V> node) {
        node.prev = head;
        node.post = head.post;
        head.post.prev = node;
        head.post = node;
    }

    //把节点从链表删除
    private void removeNode(Node<K, V> node) {
        Node<K, V> prev = node.prev;
        Node<K, V> post = node.post;
        prev.post = post;
        post.prev = prev;
    }

    //节点移到链表头部
    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    private Node<K, V> popTail() {
        Node<K, V> res = tail.prev;
        removeNode(res);
        return res;
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> post;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
