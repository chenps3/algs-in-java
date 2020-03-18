package com.chenps3.algs.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-right-interval/
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-03-02
 */
public class Problem436 {

    public static void main(String[] args) {
        int[][] i1 = {{1, 2}};
        printArray(findRightIntervalV2(i1));

        int[][] i2 = {{3, 4}, {2, 3}, {1, 2}};
        printArray(findRightIntervalV2(i2));

        int[][] i3 = {{1, 4}, {2, 3}, {3, 4}};
        printArray(findRightIntervalV2(i3));

    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    //法2：两个排序数组
    public static int[] findRightIntervalV2(int[][] intervals) {
        List<Interval> orderByLeft = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            orderByLeft.add(new Interval(intervals[i][0], intervals[i][1], i));
        }
        List<Interval> orderByRight = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            orderByRight.add(new Interval(intervals[i][0], intervals[i][1], i));
        }
        //按区间左边界升序
        orderByLeft.sort((o1, o2) -> o1.left - o2.left);
        //按区间右边界升序
        orderByRight.sort((o1, o2) -> o1.right - o2.right);
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            result[i] = -1;
        }
        int j = 0;
        for (int i = 0; i < orderByRight.size(); i++) {
            Interval right = orderByRight.get(i);
            while (j < orderByLeft.size()) {
                Interval left = orderByLeft.get(j);
                if (right.right <= left.left) {
                    result[right.index] = left.index;
                    break;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    //法1：排序+二分
    public static int[] findRightInterval(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1], i));
        }
        //按区间左边界升序
        list.sort((o1, o2) -> o1.left - o2.left);
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {        //初始化
            Interval interval = searchInterval(intervals[i][1], list);
            if (interval != null) {
                result[i] = interval.index;
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    //二分查找list，找出left字段大于等于right的最小元素
    private static Interval searchInterval(int right, List<Interval> list) {
        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            Interval obj = list.get(mid);
            if (obj.left > right) {
                hi = mid;
            } else if (obj.left < right) {
                lo = mid + 1;
            } else if (obj.left == right) {     //元素不重复，obj一定是最小的
                return obj;
            }
        }
        if (lo == list.size()) {
            return null;
        }
        return list.get(lo);
    }

    private static class Interval {
        int left;
        int right;
        int index;

        public Interval(int left, int right, int index) {
            this.left = left;
            this.right = right;
            this.index = index;
        }
    }
}
