package com.chenps3.algs.week1;

public class BitonicSearch {

    public static void main(String[] args) {

    }

    public static boolean bitonicSearch(int[] a, int b) {
        //二分法找到分水岭index m ，lgN
        int m = 0;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid - 1] > a[mid]) {
                hi = mid - 1;
            } else if (a[mid] < a[mid + 1]) {
                lo = mid + 1;
            } else {
                m = mid;
            }
        }
        //二分法在m的左右两边查找b， 加起来是lgN
        if (b > a[m]) {
            return false;
        } else if (b == a[m]) {
            return true;
        } else {
            int indedOfB = binarySearch(a, 0, m, b);
            if (indedOfB == -1) {
                indedOfB = binarySearch(a, m + 1, a.length - 1, b);
            }
            return indedOfB != -1;
        }
    }

    static int binarySearch(int[] a, int lo, int hi, int b) {
        return -1;
    }

}
