package com.chenps3.algs.impl.ch1;

/**
 * 编程珠玑第一章习题2
 * 使用位运算实现位图，即设置特定的bit为1或0
 */
public class One2 {

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(100000);
        bitMap.setBit(1000);
        System.out.println(bitMap.getBit(1000));
        System.out.println(bitMap.getBit(1001));
    }

}
