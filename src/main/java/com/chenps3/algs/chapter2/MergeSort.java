package com.chenps3.algs.chapter2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//二路归并排序：把输入（递归地）分成两半分别排序，再合并。
//特点是无论什么输入，时间复杂度都是NlogN，但需要额外的空间复杂度N
public class MergeSort {

    //自顶向下归并
    //需要1/2NLogN 至 NLogN次比较；最多需要访问数组6NLogN次
    public static <T> void sortV1(Comparable<T>[] a) {
        aux = new Comparable[a.length];     //一次性分配辅助数组所需的内存空间
        sortV1(a, 0, a.length - 1);
    }

    //todo 待改进
    //1 数组规模小时（high-low<某个值）改用插入排序
    //2 如果a[mid]<a[mid+1]，可以认为数组[low...high]已经有序，跳过归并
    //3 不将元素复制到辅助数组
    private static <T> void sortV1(Comparable<T>[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sortV1(a, low, mid);          //递归排序左半边
        sortV1(a, mid + 1, high);     //递归排序右半边
        merge(a, low, mid, high);   //归并左右
    }

    //自底向上归并，适合链表组织的数据,只需要修改指针指向就可以完成原地排序，不需要额外空间
    public static <T> void sortV2(Comparable<T>[] a) {
        int N = a.length;
        aux = new Comparable[a.length];
        for (int sz = 1; sz < N; sz = sz + sz) {        //sz为子数组大小，从1开始，每轮归并翻倍
            for (int low = 0; low < N - sz; low += (sz + sz)) { //low为子数组索引
                merge(a, low, low + sz - 1, Math.min(low + sz + sz - 1, N - 1));
            }
        }
    }


    private static Comparable[] aux;

    //归并a[low...mid](左数组)和a[mid+1...high]（右数组），两个子数组已各自有序
    public static <T> void merge(Comparable<T>[] a, int low, int mid, int high) {
        int i = low;        //i是左数组下标
        int j = mid + 1;    //j是右数组下标
        //把low到high复制到辅助数组
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        //遍历并比较左右数组，合并成有序的大数组
        for (int k = low; k <= high; k++) {
            if (i > mid) {          //左数组遍历完毕
                a[k] = aux[j++];
            } else if (j > high) {  //右数组遍历完毕
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) { //左数组当前元素>右数组当前元素
                a[k] = aux[j++];
            } else {                //左数组当前元素<右数组当前元素
                a[k] = aux[i++];
            }
        }
    }

    private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    private static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static <T> void show(Comparable<T>[] a) {
        for (Comparable<T> item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static <T> boolean isSorted(Comparable<T>[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    private static String[] input() {
        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String filePath = classpath + File.separator + "sort1.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String data = reader.readLine();
            return data.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String[] input = input();
        show(input);
        sortV1(input);
        //需要启用jvm配置 -ea
        assert isSorted(input);
        show(input);
    }
}
