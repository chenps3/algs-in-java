package com.chenps3.algs.leetcode;


/**
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * 堆
 *
 * @Author chenguanhong
 * @Date 2020-03-06
 */
public class Problem973 {

    public static void main(String[] args) {
//        int[][] p1 = {{1, 3}, {-2, 2}};
//        int[][] a1 = kClosest(p1, 1);
//
//        int[][] p2 = {{3, 3}, {5, -1}, {-2, 4}};
//        int[][] a2 = kClosest(p2, 2);

        int[][] p3 = {{68, 97}, {34, -84}, {60, 100}, {2, 31}, {-27, -38}, {-73, -74}, {-55, -39}, {62, 91}, {62, 92}, {-57, -67}};
        int[][] a3 = kClosest(p3, 5);

        System.out.println();
    }

    public static int[][] kClosest(int[][] points, int K) {
        MaxHeap<Point> heap = new MaxHeap<>(K + 5);
        for (int i = 0; i < points.length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            heap.insert(p);
            if (heap.size() > K) {
                heap.delMax();
            }
        }
        int[][] res = new int[K][2];
        int i = 0;
        while (!heap.isEmpty() && K-- > 0) {
            Point p = heap.delMax();
            res[i][0] = p.x;
            res[i][1] = p.y;
            i++;
        }
        return res;
    }

    private static class MaxHeap<T extends Comparable> {
        T[] pq;
        int n;

        public MaxHeap(int capacity) {
            n = 0;
            pq = (T[]) new Comparable[capacity + 1];
        }

        //元素有capacity个时，删掉一个，令堆最多有capacity-1个元素
        public void insert(T x) {
            pq[++n] = x;
            swim(n);
        }

        public T delMax() {
            if (isEmpty()) {
                throw new RuntimeException();
            }
            T max = pq[1];
            exch(1, n--);
            sink(1);
            return max;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int size() {
            return n;
        }

        private void sink(int k) {
            while (k * 2 <= n) {
                int j = k * 2;
                if (j < n && less(j, j + 1)) {
                    j++;
                }
                if (!less(k, j)) {
                    break;
                }
                exch(k, j);
                k = j;
            }
        }

        private void swim(int k) {
            while (k > 1 && less(k / 2, k)) {
                exch(k / 2, k);
                k = k / 2;
            }
        }

        private boolean less(int a, int b) {
            return pq[a].compareTo(pq[b]) < 0;
        }

        private void exch(int a, int b) {
            T tmp = pq[a];
            pq[a] = pq[b];
            pq[b] = tmp;
        }
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            distance = x * x + y * y;
        }

        @Override
        public int compareTo(Point o) {
            return this.distance - o.distance;
        }
    }
}
