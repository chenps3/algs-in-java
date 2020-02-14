package com.chenps3.algs.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 堆
 *
 * @Author chenguanhong
 * @Date 2020-02-13
 */
public class Problem347 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> result = new Problem347().topKFrequent(nums, k);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        //先对nums排序
        sort(nums);
        //遍历有序数组，插入大堆
        MaxHeap<ValueCount> heap = new MaxHeap<>();
        int lastCount = 0;
        int lastValue = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (lastValue == nums[i]) {
                lastCount++;
            } else {
                heap.insert(new ValueCount(lastValue, lastCount));
                lastValue = nums[i];
                lastCount = 1;
            }
            if (i == nums.length - 1) {
                heap.insert(new ValueCount(lastValue, lastCount));
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(heap.delMax().value);
        }
        return result;
    }

    //用堆排序
    private void sort(int[] nums) {
        int n = nums.length;
        //从后往前sink，构建大根堆
        for (int i = n / 2; i >= 1; i--) {
            sink(nums, i, n);
        }
        while (n > 0) {
            exch(nums, 1, n--);
            sink(nums, 1, n);
        }
    }

    private void sink(int[] nums, int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(nums, j, j + 1)) {
                j++;
            }
            if (!less(nums, k, j)) {
                break;
            }
            exch(nums, k, j);
            k = j;
        }
    }

    private boolean less(int[] nums, int i, int j) {
        return nums[i - 1] < nums[j - 1];
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i - 1];
        nums[i - 1] = nums[j - 1];
        nums[j - 1] = tmp;
    }

    private class MaxHeap<T extends Comparable<T>> {

        private T[] pq;
        private int n;

        public MaxHeap() {
            pq = (T[]) new Comparable[11];
            n = 0;
        }

        private T delMax() {
            if (isEmpty()) {
                throw new RuntimeException();
            }
            Comparable max = pq[1];
            exch(1, n--);
            sink(1);
            return (T) max;
        }

        private void insert(T t) {
            if (n + 1 == pq.length) {
                resize(pq.length * 2);
            }
            pq[++n] = t;
            swim(n);
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

        private void resize(int capacity) {
            T[] tmp = (T[]) new Comparable[capacity];
            for (int i = 1; i <= n; i++) {
                tmp[i] = pq[i];
            }
            pq = tmp;
        }

        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }

        private void exch(int i, int j) {
            T tmp = pq[i];
            pq[i] = pq[j];
            pq[j] = tmp;
        }

        private boolean isEmpty() {
            return n == 0;
        }
    }

    private class ValueCount implements Comparable<ValueCount> {

        public ValueCount(int value, int count) {
            this.value = value;
            this.count = count;
        }

        private int value;

        private int count;

        @Override
        public int compareTo(ValueCount o) {
            if (count < o.count) {
                return -1;
            }
            if (count > o.count) {
                return 1;
            }
            return 0;
        }
    }
}
