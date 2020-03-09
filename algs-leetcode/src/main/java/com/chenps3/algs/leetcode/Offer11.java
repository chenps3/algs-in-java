package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 同154
 *
 * @Author chenguanhong
 * @Date 2020-03-07
 */
public class Offer11 {

    public static void main(String[] args) {
        int[] n1 = {3, 5, 1};
        System.out.println(minArray(n1));
    }

    public static int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int left = numbers[0];
        int lo = 0;
        int hi = numbers.length;
        //没有旋转
        if (numbers[lo] < numbers[hi - 1]) {
            return numbers[lo];
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            //[lo,mid]有序
            if (numbers[mid] > left) {
                lo = mid + 1;
            }
            //[mid,hi)有序
            else if (numbers[mid] < left) {
                hi = mid;
            }
            //相等时无法判断，只能顺序查找
            else if (numbers[mid] == left) {
                return findMin(numbers, lo, hi);
            }
        }
        return numbers[lo];
    }

    private static int findMin(int[] numbers, int lo, int hi) {
        if (hi == numbers.length) {     //防止越界
            hi = hi - 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }
}
