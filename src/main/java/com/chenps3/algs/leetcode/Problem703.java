package com.chenps3.algs.leetcode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Heap
 *
 * @Author chenguanhong
 * @Date 2020-02-07
 */
class Problem703 {

    private IntMinHeap heap;

    private int k;

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        Problem703 kthLargest = new Problem703(k, arr);
        System.out.println(kthLargest.add(3));      //return 4
        System.out.println(kthLargest.add(5));      //return 5
        System.out.println(kthLargest.add(10));     //return 5
        System.out.println(kthLargest.add(9));      //return 8
        System.out.println(kthLargest.add(4));      //return 8
    }

    public Problem703(int k, int[] nums) {
        heap = new IntMinHeap(k);
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            heap.insert(nums[i]);
            if (heap.size() > k) {
                heap.delMin();
            }
        }
    }

    //返回堆的最小值
    public int add(int val) {
        heap.insert(val);
        while (heap.size() > k) {
            heap.delMin();
        }
        return heap.getMin();
    }

    static class IntMinHeap {

        private int[] pq;

        private int n;

        public IntMinHeap(int capacity) {
            pq = new int[capacity + 1];
            n = 0;
        }

        public void insert(int x) {
            if (n == pq.length - 1) {
                resize(2 * pq.length);
            }
            pq[++n] = x;
            swim(n);
        }

        public int delMin() {
            if (isEmpty()) {
                throw new RuntimeException("empty heap");
            }
            int min = pq[1];
            exch(1, n--);
            sink(1);
            return min;
        }

        public int getMin() {
            return pq[1];
        }

        public int size() {
            return n;
        }

        private boolean isEmpty() {
            return n == 0;
        }

        //比较
        private boolean greater(int i, int j) {
            return pq[i] > pq[j];
        }

        //交换
        private void exch(int i, int j) {
            int tmp = pq[i];
            pq[i] = pq[j];
            pq[j] = tmp;
        }

        //自底向上构建堆
        private void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                exch(k / 2, k);
                k = k / 2;
            }
        }

        //自顶向下构建堆
        private void sink(int k) {
            while (k * 2 <= n) {
                int j = k * 2;
                //取更小的子节点交换
                if (j < n && greater(j, j + 1)) {
                    j++;
                }
                if (!greater(k, j)) {
                    break;
                }
                exch(j, k);
                k = j;
            }
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


