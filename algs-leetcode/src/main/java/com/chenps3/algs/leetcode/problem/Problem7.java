package com.chenps3.algs.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class Problem7 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int k = solution1(Integer.MAX_VALUE);
        System.out.println(k);
    }

    /*
    我的解法
     */
    public static int solution1(int x) {
        if (x == 0) return 0;
        boolean positive = x > 0;
        x = x > 0 ? x : -1 * x;
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }
        long result = 0;
        long j = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            long tmp = list.get(i) * j;
            result += tmp;
            j *= 10;
        }
        result = positive ? result : result * -1;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    /*
    一次遍历，使用(x*10)/10==x判断是否溢出
     */
    public static int solution2(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }
}
