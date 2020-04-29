package com.chenps3.algs.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * @Author chenguanhong
 * @Date 2020/4/28
 */
public class Offer56I {

    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        int[] ans = singleNumbers(nums);
        for (int a : ans) {
            System.out.println(a);
        }
    }

    /**
     * 异或运算的性质：
     * 1 交换律
     * 2 结合律
     * 3 A XOR A = 0， A XOR 0 = A
     */
    public static int[] singleNumbers(int[] nums) {
        //第1遍遍历，依次异或，得到这两个只出现1次的数字的异或结果k
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            k ^= nums[i];
        }
        //正常的输入下，k一定不为0，任意取一位1,这里就取右边第一位1
        int n = findFirstBitIs1(k);
        //nums的数可以分为两类，第n位为1，第n位不为1，且a,b的第n位一个为1一个不为1
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isBit1(nums[i], n)) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a, b};
    }

    //判断num的第n位是否为1
    private static boolean isBit1(int num, int n) {
        int t = num >>> n;
        return (t & 1) == 1;
    }

    //找到数字k右边第一个1是第几位,n从0开始计算
    private static int findFirstBitIs1(int k) {
        int n = 0;
        while ((k & 1) == 0) {
            k >>>= 1;
            n++;
        }
        return n;
    }
}
