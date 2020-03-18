package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 位运算
 *
 * @Author chenguanhong
 * @Date 2020-03-10
 */
public class Offer15 {

    public static void main(String[] args) {
        System.out.println(hammingWeightV2(0b11111111111111111111111111111101));
    }

    public static int hammingWeightV1(int n) {
        int cnt = 0;
        while (n != 0) {
            if ((n & 0b1) != 0) {
                ++cnt;
            }
            n >>>= 1;
        }
        return cnt;
    }

    //    法2： n & (n-1)，相当于把二进制数最右边的1变成0.很多二进制问题可以用这个思路
    public static int hammingWeightV2(int n) {
        int cnt = 0;
        while (n != 0) {
            ++cnt;
            n = n & (n - 1);
        }
        return cnt;
    }
}
