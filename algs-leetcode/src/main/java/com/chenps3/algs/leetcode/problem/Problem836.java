package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/rectangle-overlap/
 *
 * @Author chenguanhong
 * @Date 2020/3/18
 */
public class Problem836 {

    public static void main(String[] args) {
        int[] r1 = {7, 8, 13, 15};
        int[] r2 = {10, 8, 12, 20};
        System.out.println(isRectangleOverlap(r1, r2));
    }

    //如果图形重叠，x,y轴投影也重叠
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isLineOverlap(rec1[0],rec1[2],rec2[0],rec2[2]) && isLineOverlap(rec1[1],rec1[3],rec2[1],rec2[3]);
    }

    private static boolean isLineOverlap(int begin1, int end1, int begin2, int end2) {
        if (end1 <= begin2) {
            return false;
        }
        if (end2 <= begin1) {
            return false;
        }
        return true;
    }
}
