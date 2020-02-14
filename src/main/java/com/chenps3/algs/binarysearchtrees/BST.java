package com.chenps3.algs.binarysearchtrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树基本实现
 *
 * @Author chenguanhong
 * @Date 2020-02-12
 */
public class BST<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private Node left;
        private Node right;
        private K key;
        private V value;
        private int size;

        private Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public BST() {
    }

    //BST是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    //BST大小
    public int size() {
        return size(root);
    }

    //判断是否包含key
    public boolean contains(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return get(key) != null;
    }

    //查找value
    public V get(K key) {
        return get(root, key);
    }

    //添加元素
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
        check();
    }

    //删除特定key对应的节点
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        root = delete(root, key);
        check();
    }

    //删除key最小的节点
    public void deleteMin() {
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        root = deleteMin(root);
        check();
    }

    //删除key最大的节点
    public void deleteMax() {
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        root = deleteMax(root);
        check();
    }

    //最小的key
    public K min() {
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        return min(root).key;
    }

    //最大的key
    public K max() {
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        return max(root).key;
    }

    //小于等于key的最大key值
    public K floor(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        Node x = floor(root, key);
        if (x == null) {
            throw new RuntimeException("no such key");
        }
        return x.key;
    }

    //floor的另一种实现
    public K floor2(K key) {
        K x = floor2(root, key, null);
        if (x == null) {
            throw new RuntimeException("no such key");
        }
        return x;
    }

    //大于等于key的最小key值
    public K ceiling(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        Node x = ceiling(root, key);
        if (x == null) {
            throw new RuntimeException("no such key");
        }
        return x.key;
    }

    //BST中排序为k+1的key
    public K select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException();
        }
        return select(root, k).key;
    }

    //比给定key小的key的数量
    public int rank(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return rank(key, root);
    }

    //遍历BST
    public Iterable<K> keys() {
        if (isEmpty()) {
            return new LinkedList<>();
        }
        return keys(min(), max());
    }

    //BST在给定范围内的key的数量
    public int size(K lo, K hi) {
        if (lo == null) {
            throw new IllegalArgumentException();
        }
        if (hi == null) {
            throw new IllegalArgumentException();
        }
        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        }
        return rank(hi) - rank(lo);
    }

    //中序遍历，非递归版本
    public Iterable<K> keys2() {
        Stack<Node> stack = new Stack<>();
        Queue<K> queue = new LinkedList<>();
        Node x = root;
        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            } else {
                x = stack.pop();
                queue.add(x.key);
                x = x.right;
            }
        }
        return queue;
    }

//    ---------------------------------------helpers---------------------------------------

    //是否是BST
    private boolean isBST() {
        return isBST(root, null, null);
    }

    //x子树是否BST
    private boolean isBST(Node x, K min, K max) {
        if (x == null) {
            return true;
        }
        if (min != null && min.compareTo(x.key) > 0) {
            return false;
        }
        if (max != null && max.compareTo(x.key) < 0) {
            return false;
        }
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    //中序遍历
    private void keys(Node x, Queue<K> queue, K lo, K hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.add(x.key);
        }
        if (cmphi < 0) {
            keys(x.right, queue, lo, hi);
        }
    }


    private Iterable<K> keys(K min, K max) {
        Queue<K> queue = new LinkedList<>();
        keys(root, queue, min, max);
        return queue;
    }

    private int rank(K key, Node node) {
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return 1 + size(node.left) + rank(key, node.right);
        }
        if (cmp == 0) {
            return size(node.left);
        }
        return rank(key, node.left);
    }

    private Node select(Node node, int k) {
        if (node == null) {
            return null;
        }
        int t = size(node.left);
        if (t > k) {
            return select(node.left, k);
        }
        if (t == k) {
            return node;
        }
        return select(node.right, k - t - 1);
    }

    private Node ceiling(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            Node t = ceiling(node.left, key);
            return t != null ? t : node;
        }
        if (cmp == 0) {
            return node;
        }
        return ceiling(node.right, key);
    }

    //best表示当前小于等于key最大值
    private K floor2(Node node, K key, K best) {
        if (node == null) {
            return best;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return floor2(node.left, key, best);
        }
        //best一定小于等于node的key
        if (cmp > 0) {
            return floor2(node.right, key, node.key);
        }
        return node.key;
    }

    //node子树下小于等于key的最大节点
    private Node floor(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return floor(node.left, key);
        }
        if (cmp == 0) {
            return node;
        }
        Node tmp = floor(node.right, key);
        return tmp != null ? tmp : node;
    }

    //node子树下key最小的节点
    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    //node子树下key最小的节点
    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    //删除node子树下key对应节点，返回新的子树根节点
    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        //key在左子树
        if (cmp < 0) {
            node.left = delete(node.left, key);
        }
        //key在右子树
        else if (cmp > 0) {
            node.right = delete(node.right, key);
        }
        //删除的是当前node
        else {
            Node tmp = node;
            //与右子树的最小节点交换
            node = min(tmp.right);
            //交换后，原右子树的最小节点删除
            node.right = deleteMin(tmp.right);
            //左子树还原
            node.left = tmp.left;
            //链表的删除只是断掉引用，这里只有当前node的引用被断掉了，可以被GC
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    //删除node子树下key最大的节点，返回新的子树根节点
    private Node deleteMax(Node node) {
        //删除自己
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    //删除node子树下key最小的节点，返回新的子树根节点
    private Node deleteMin(Node node) {
        //删除自己
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    //node子树的节点个数
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    //在node子树下按key查找valye
    private V get(Node node, K key) {
        if (key == null) {
            throw new IllegalArgumentException("");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    //在node子树下添加节点
    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        }
        if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    //检测是否是个BST
    private void check() {
        //todo
    }
}
