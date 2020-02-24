package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 * <p>
 * 二分查找
 *
 * @Author chenguanhong
 * @Date 2020-02-23
 */
public class Problem29 {

    public static void main(String[] args) {
        int dividend = Integer.MIN_VALUE;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
    }

    //dividend被除数
    //divisor除数
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        //确定商的范围
        long tmpDividend = dividend > 0 ? dividend : -1L * dividend;
        long tmpDivisor = divisor > 0 ? divisor : -1L * divisor;
        long hi = tmpDividend;
        long lo = 1L;
        long tmpQuotient = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long product = mid * tmpDivisor;
            if (product == tmpDividend) {
                tmpQuotient = mid;
                break;
            } else if (product > tmpDividend) {
                hi = mid - 1;
            } else if (product < tmpDividend) {
                if (tmpDividend - product < tmpDivisor) {
                    tmpQuotient = mid;
                    break;
                }
                lo = mid + 1;
            }
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            return (int) (-1 * tmpQuotient);
        }
        return tmpQuotient > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) tmpQuotient;
    }
}
