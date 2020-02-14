package com.chenps3.algs.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * 堆
 *
 * @Author chenguanhong
 * @Date 2020-02-14
 */
public class Problem373 {

    public static void main(String[] args) {
        int x = 1;
        System.out.println(x--);
        System.out.println(x-- >0);
        System.out.println(x);


        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = new Problem373().kSmallestPairs4(nums1, nums2, k);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> kSmallestPairs4(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt(i -> i.num1 + i.num2));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(new Pair(nums1[i], nums2[j]));
            }
        }
        while (k-- > 0 && !pq.isEmpty()) {
            Pair pair = pq.poll();
            result.add(pairToList(pair));
        }
        return result;
    }

    public List<List<Integer>> kSmallestPairs3(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt(i -> i.num1 + i.num2));
        for (int i = 0; i < k && i < nums1.length; i++) {
            pq.add(new Pair(i, 0, nums1[i], nums2[0]));
        }
        for (int i = 0; i < nums1.length * nums2.length && i < k; i++) {
            Pair pair = pq.poll();
            result.add(pairToList(pair));
            if (pair.i2 + 1 < nums2.length) {
                pq.add(new Pair(pair.i1, pair.i2 + 1, nums1[pair.i1], nums2[pair.i2 + 1]));
            }
        }
        return result;
    }

    //wrong
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt(i -> i.num1 + i.num2));
        pq.add(new Pair(0, 0, nums1[0], nums2[0]));
        for (int i = 0; i < nums1.length * nums2.length && i < k; i++) {
            //序列当前元素记为nums1[i1]+nums[i2]
            Pair pair = pq.poll();
            result.add(pairToList(pair));
            //序列的下一个元素只可能是A=nums1[i1]+nums[i2+1]或者B=nums1[i1+1]+nums[i2]
            //把A加入到堆，可能会重复插入
            if (pair.i2 + 1 < nums2.length) {
                pq.add(new Pair(pair.i1, pair.i2 + 1, nums1[pair.i1], nums2[pair.i2 + 1]));
            }
            //把B加入到堆，可能会重复插入
            if (pair.i1 + 1 < nums1.length) {
                pq.add(new Pair(pair.i1 + 1, pair.i2, nums1[pair.i1 + 1], nums2[pair.i2]));
            }
        }
        return result;
    }

    //基于堆的解法，要利用好有序这个条件
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        MinHeap<Pair> heap = new MinHeap<>();
        //初始化堆元素：nums2[0]和前k个nums1，nums1可能不到k个
        for (int i = 0; i < nums1.length && i < k; i++) {
            heap.insert(new Pair(i, 0, nums1[i], nums2[0]));
        }
        for (int i = 0; i < nums1.length * nums2.length && i < k; i++) {
            //当前出堆元素记为nums1[i1]+nums[i2]
            Pair pair = heap.delMin();
            result.add(pairToList(pair));
            //下一个出堆元素只可能是A=nums1[i1]+nums[i2+1]或者B=nums1[i1+1]+nums[i2]
            //其中B或者在之前的循环入堆，或者是初始化时入堆
            //只需要把A加入到堆
            if (pair.i2 + 1 < nums2.length) {
                heap.insert(new Pair(pair.i1, pair.i2 + 1, nums1[pair.i1], nums2[pair.i2 + 1]));
            }
        }
        return result;
    }

    private List<Integer> pairToList(Pair pair) {
        return Arrays.asList(pair.num1, pair.num2);
    }

    private class MinHeap<T extends Comparable<T>> {

        private T[] pq;
        private int n;

        private MinHeap() {
            pq = (T[]) new Comparable[10];
            n = 0;
        }

        private int size() {
            return n;
        }

        private boolean isEmpty() {
            return n == 0;
        }

        private void insert(T x) {
            if (n + 1 == pq.length) {
                resize(2 * pq.length);
            }
            pq[++n] = x;
            swim(n);
        }

        private T delMin() {
            if (isEmpty()) {
                throw new RuntimeException("empty");
            }
            T min = pq[1];
            exch(1, n--);
            sink(1);
            return min;
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
            return pq[i].compareTo(pq[j]) > 0;
        }

        private void exch(int i, int j) {
            T tmp = pq[i];
            pq[i] = pq[j];
            pq[j] = tmp;
        }

        private void resize(int capacity) {
            T[] tmp = (T[]) new Comparable[capacity];
            for (int i = 1; i <= n; i++) {
                tmp[i] = pq[i];
            }
            pq = tmp;
        }
    }

    private class Pair implements Comparable<Pair> {
        private int i1;
        private int i2;
        private int num1;
        private int num2;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        private Pair(int i1, int i2, int num1, int num2) {
            this.i1 = i1;
            this.i2 = i2;
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public int compareTo(Pair o) {
            if (num1 + num2 < o.num1 + o.num2) {
                return -1;
            }
            if (num1 + num2 > o.num1 + o.num2) {
                return 1;
            }
            return 0;
        }
    }
}
