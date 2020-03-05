package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/h-index-ii/
 * <p>
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-28
 */
public class Problem275 {

    public static void main(String[] args) {
        int[] a1 = {0,1,3,5,6};
        System.out.println(hIndex(a1) == 3);
    }

    public static int hIndex(int[] citations) {
        int lo = 0;
        int hi = citations.length - 1;
        int h = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int num = citations.length - mid;       //h指数以num为准
            if (citations[mid] < num) {
                lo = mid + 1;
            } else if (citations[mid] >= num) {
                h = num;
                hi = mid - 1;
            }
        }
        return h;
    }
}
