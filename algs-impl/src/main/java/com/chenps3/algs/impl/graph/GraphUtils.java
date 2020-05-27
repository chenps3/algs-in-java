package com.chenps3.algs.impl.graph;

/**
 * 常用的图处理代码
 *
 * @Author chenguanhong
 * @Date 2020/5/15
 */
public class GraphUtils {

    /**
     * 计算v的度数
     *
     * @param g
     * @param v
     * @return
     */
    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w : g.adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * 计算所有顶点的最大度数
     *
     * @param g
     * @return
     */
    public static int maxDegree(Graph g) {
        int max = 0;
        for (int i = 0; i < g.v(); i++) {
            int t = degree(g, i);
            if (t > max) {
                max = t;
            }
        }
        return max;
    }

    /**
     * 计算所有顶点的平均度数
     *
     * @param g
     * @return
     */
    public static double avgDegree(Graph g) {
        return 2.0 * g.e() / g.v();
    }

    /**
     * 计算自环的个数
     *
     * @param g
     * @return
     */
    public static int numberOfSelfLoops(Graph g) {
        int count = 0;
        for (int v = 0; v < g.v(); v++) {
            for (int w : g.adj(v)) {
                if (w == v) {
                    count++;
                }
            }
        }
        return count;
    }

}
