package com.chenps3.algs.impl.graph;


/**
 * @Author chenguanhong
 * @Date 2020/5/15
 */
public abstract class Search {

    //找到和点s连通的所有顶点
    protected Search(Graph g, int s) {
    }

    //判断v和s是否连通
    protected boolean marked(int v) {
        return false;
    }

    //与点s连通的顶点数量
    protected int count() {
        return 0;
    }
}
