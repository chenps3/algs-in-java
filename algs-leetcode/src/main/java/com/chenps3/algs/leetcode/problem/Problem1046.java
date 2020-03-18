package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode.com/problems/last-stone-weight/
 * 堆
 *
 * @Author chenguanhong
 * @Date 2020-02-08
 */
public class Problem1046 {

    public static void main(String[] args) {

    }

    public int lastStoneWeight(int[] stones) {
        IntMaxHeap heap = new IntMaxHeap(stones.length);
        for (int i = 0; i < stones.length; i++) {
            heap.insert(stones[i]);
        }
        while (heap.size() > 1) {
            int y = heap.delMax();
            int x = heap.delMax();
            if (y > x) {
                heap.insert(y - x);
            }
        }
        if (heap.isEmpty()) {
            return 0;
        } else {
            return heap.delMax();
        }
    }

    static class IntMaxHeap {

        private IntMaxHeap(int capacity) {
            pq = new int[capacity + 1];
            n = 0;
        }

        private void insert(int val) {
            if (n + 1 == pq.length) {
                resize(pq.length * 2);
            }
            pq[++n] = val;
            swim(n);
        }

        private int delMax() {
            if (isEmpty()) {
                throw new RuntimeException("empty heap");
            }
            int max = pq[1];
            exch(1, n--);
            sink(1);
            return max;
        }

        private int size() {
            return n;
        }

        private int[] pq;

        private int n;

        private boolean less(int i, int j) {
            return pq[i] < pq[j];
        }

        private void exch(int i, int j) {
            int tmp = pq[i];
            pq[i] = pq[j];
            pq[j] = tmp;
        }

        private void swim(int k) {
            while (k > 1 && less(k / 2, k)) {
                exch(k / 2, k);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= n) {
                int j = 2 * k;
                //跟更大的子节点交换
                if (j < n && less(j, j + 1)) {
                    j++;
                }
                if (less(j, k)) {
                    break;
                }
                exch(j, k);
                k = j;
            }
        }

        private boolean isEmpty() {
            return n == 0;
        }

        private void resize(int capacity) {
            int[] tmp = new int[capacity];
            for (int i = 1; i <= n; i++) {
                tmp[i] = pq[i];
            }
            pq = tmp;
        }
    }
}
