package com.chenps3.algs.leetcode;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * 贪心
 *
 * @Author chenguanhong
 * @Date 2020-03-10
 */
public class Offer14II {

    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }

    //数字过大，不能用动态规划存储中间值了
    //贪心
//我们首先考虑对于一段长n的绳子，我们可以切出的结果包含什么？
//1 会包含吗？ 不会，因为1 * (k - 1) < k, 只要把1和任何一个其他的片段组合在一起就有个更大的值
//2 可以
//3 可以
//4 可以吗？ 它拆成两个2的效果和本身一样，因此也不考虑
//5 以上可以吗？ 不可以，这些绳子必须拆，因为总有一种拆法比不拆更优，比如拆成 k / 2 和 k - k / 2
//综上, 最后的结果只包含2和3(当然当总长度为2和3时单独处理),
//那么很显然n >= 5时， 3*(n - 3) >= 2 * (n - 2) ，因此我们优先拆成3，最后剩余的拆成2。
//最后的结果一定是由若干个3和1或2个2组成.

    public static int cuttingRope(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        long res = 1;
        while (n >= 5) {
            n -= 3;
            res *= 3;
            res %= 1000000007;
        }
        return (int) (res * n % 1000000007);
    }

}
