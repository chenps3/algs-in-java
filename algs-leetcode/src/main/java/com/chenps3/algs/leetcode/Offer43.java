package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * 数学观察
 *
 * @Author chenguanhong
 * @Date 2020/3/11
 */
public class Offer43 {

    public static void main(String[] args) {
        System.out.println(countDigitOne(824883294));
    }

    public static int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        return countOne(String.valueOf(n));
    }

    //int转为string处理
    private static int countOne(String n) {
        int first = n.charAt(0) - '0';      //第一位数
        int len = n.length();
        if (len == 1 && first == 0) {       //n=="0"
            return 0;
        }
        if (len == 1 && first > 0) {        //1 <= n <= 9
            return 1;
        }

        //假设n是 21345
        //numFirstDigit是10000到19999中1的数目
        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = powBase10(len - 1);
        } else if (first == 1) {
            numFirstDigit = 1 + Integer.parseInt(n.substring(1));
        }

        //numOtherDigit是1346 ~ 21345除第一位外，1的数目
        int numOtherDigit = first * (len - 1) * powBase10(len - 2);
        //numRecursive 是1 ~ 1345中 1的数目
        int numRecursive = countOne(n.substring(1));

        return numFirstDigit + numOtherDigit + numRecursive;
    }

    //求10的n次方
    private static int powBase10(int n) {
        int i = 1;
        while (n-- > 0) {
            i *= 10;
        }
        return i;
    }
}
