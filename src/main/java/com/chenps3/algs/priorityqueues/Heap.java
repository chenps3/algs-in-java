package com.chenps3.algs.priorityqueues;

import edu.princeton.cs.algs4.StdIn;

/**
 * @Author chenguanhong
 * @Date 2020-02-10
 */
public class Heap {

    private Heap() {
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Heap.sort(a);
        show(a);
    }

    //堆排序
    public static void sort(Comparable[] pq) {
        int n = pq.length;
        //从倒数第二层开始，通过sink操作构建最大堆
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }
        //不断地将堆顶移到堆底，完成升序排序
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    /**
     * 通过下沉操作重建最大堆
     *
     * @param pq 堆数组
     * @param k  元素下标
     * @param n  堆数组元素个数
     */
    private static void sink(Comparable[] pq, int k, int n) {
        while (k * 2 <= n) {
            //找更大的子节点交换
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) {
                j++;
            }
            //父节点已经比子节点大了
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    //pq有效元素从位置0开始计算，所以下标-1
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    //pq有效元素从位置0开始计算，所以下标-1
    private static void exch(Object[] pq, int i, int j) {
        Object tmp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = tmp;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
