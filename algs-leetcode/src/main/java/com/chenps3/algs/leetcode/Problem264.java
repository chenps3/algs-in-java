package com.chenps3.algs.leetcode;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 * 堆
 * 动态规划
 * @Author chenguanhong
 * @Date 2020-02-11
 */
public class Problem264 {

    public static void main(String[] args) {
        int x = new Problem264().nthUglyNumber(1407);
        System.out.println(x);
    }

    public int nthUglyNumber(int n) {
        return heapSolution(n);
    }

    //解法1：构建小根堆
    //从小到大把每个丑数都放进堆
    //删除堆顶n-1次，最后留在堆顶的就是第n个丑数
    //注意int溢出的可能性
    private int heapSolution(int n) {
        IntMinHeap heap = new IntMinHeap();
        heap.insert(1);
        for (int i = 1; i < n; i++) {
            long min = heap.getMin();
            //可能有重复的元素，删除
            while (!heap.isEmpty() && min == heap.getMin()) {
                heap.delMin();
            }
            heap.insert(min * 2L);
            heap.insert(min * 3L);
            heap.insert(min * 5L);
        }
        return (int)heap.getMin();
    }


    private static class IntMinHeap {

        private long[] pq;
        private int n;

        private IntMinHeap() {
            pq = new long[11];
            n = 0;
        }

        private void insert(long val) {
            if (n + 1 == pq.length) {
                resize(2 * pq.length);
            }
            pq[++n] = val;
            swim(n);
        }

        private long getMin() {
            return pq[1];
        }

        private long delMin() {
            if (isEmpty()) {
                throw new RuntimeException("empty");
            }
            long min = pq[1];
            exch(1, n--);
            sink(1);
            return min;
        }

        //helpers

        private void sink(int k) {
            while (k * 2 <= n) {
                int j = k * 2;
                if (j < n && greater(j, j + 1)) {
                    j++;
                }
                if (!greater(k, j)) {
                    break;
                }
                exch(k, j);
                k = j;
            }
        }

        private void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                exch(k / 2, k);
                k = k / 2;
            }
        }

        private boolean greater(int i, int j) {
            return pq[i] > pq[j];
        }

        private void exch(int i, int j) {
            long tmp = pq[i];
            pq[i] = pq[j];
            pq[j] = tmp;
        }

        private void resize(int capacity) {
            long[] tmp = new long[capacity];
            for (int i = 1; i <= n; i++) {
                tmp[i] = pq[i];
            }
            pq = tmp;
        }

        private boolean isEmpty() {
            return n == 0;
        }
    }

}
