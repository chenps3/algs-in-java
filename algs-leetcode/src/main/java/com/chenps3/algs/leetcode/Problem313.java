package com.chenps3.algs.leetcode;

/**
 * https://leetcode.com/problems/super-ugly-number/
 * 堆
 * 动态规划
 * @Author chenguanhong
 * @Date 2020-02-12
 */
public class Problem313 {

    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        int answer = new Problem313().nthSuperUglyNumber(n, primes);
        System.out.println(answer);
    }

    //构建小根堆
    //从小到大把每个超级丑数放入堆中
    //删除堆顶n-1次，留在堆顶的就是第n个的超级丑数
    public int nthSuperUglyNumber(int n, int[] primes) {
        IntMinHeap heap = new IntMinHeap();
        heap.insert(1L);
        for (int i = 1; i < n; i++) {
            long min = heap.getMin();
            while (!heap.isEmpty() && min == heap.getMin()) {
                heap.delMin();
            }
            for (int j = 0; j < primes.length; j++) {
                long superUglyNumber = min * primes[j];
                heap.insert(superUglyNumber);
            }
        }
        return (int) heap.getMin();
    }

    private class IntMinHeap {
        private long[] pq;
        private int n;

        public IntMinHeap() {
            pq = new long[11];
            n = 0;
        }

        private long getMin() {
            return pq[1];
        }

        private long delMin() {
            if (isEmpty()) {
                throw new RuntimeException("empty heap");
            }
            long min = pq[1];
            exch(1, n--);
            sink(1);
            if (n > 0 && n == (pq.length - 1) / 4) {
                resize(pq.length / 2);
            }
            return min;
        }

        private void insert(long val) {
            if (n + 1 == pq.length) {
                resize(2 * pq.length);
            }
            pq[++n] = val;
            swim(n);
        }

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

        //k结点的子树是否堆有序
        private boolean isMinHeapOrdered(int k) {
            if (k > n) {
                return true;
            }
            int left = k * 2;
            int right = left + 1;
            if (left <= n && greater(k, left)) {
                return false;
            }
            if (right <= n && greater(k, right)) {
                return false;
            }
            return isMinHeapOrdered(left) && isMinHeapOrdered(right);
        }

        //pq是不是个最小堆
        private boolean isMinHeap() {
            return isMinHeapOrdered(1);
        }
    }
}
