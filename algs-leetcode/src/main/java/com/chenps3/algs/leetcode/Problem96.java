package com.chenps3.algs.leetcode;


/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * <p>
 * 树
 * 动态规划
 * @Author chenguanhong
 * @Date 2020-02-21
 */
public class Problem96 {

    public static void main(String[] args) {
        Problem96 p = new Problem96();
        System.out.println(p.numTrees(3));
    }

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        return numTrees1(1, n);
    }

    //最小值min，最大值max的子树数量
    public int numTrees1(int min, int max) {
        int result = 0;
        if (min > max) {
            return 1;       //空树
        }
        if (min == max) {
            return 1;
        }
        for (int i = min; i <= max; i++) {
            int left = numTrees1(min, i - 1);
            int right = numTrees1(i + 1, max);
            result += left * right;
        }
        return result;
    }
}
