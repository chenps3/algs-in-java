package com.chenps3.algs.impl.ch1;

public class BitMap {
    //使用int数组表示bitmap，数组长度size = length/32+1;
    private static int[] bitMap;

    public BitMap(int length) {
        int size = getWordIndex(length - 1) + 1;
        bitMap = new int[size];
    }

    //把index位置的bit设置为1
    public void setBit(int index) {
        int wordIndex = getWordIndex(index);
        bitMap[wordIndex] = bitMap[wordIndex] | 1 << index;
    }

    //获取index位置的bit值
    public int getBit(int index) {
        int wordIndex = getWordIndex(index);
        boolean isOne = (bitMap[wordIndex] & 1 << index) > 0;
        return isOne ? 1 : 0;
    }

    //bitIndex对应的int在数组的下标
    //一个int包含32位即2的5次方
    private int getWordIndex(int bitIndex) {
        return bitIndex >> 5;
    }
}
