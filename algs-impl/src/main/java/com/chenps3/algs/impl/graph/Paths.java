package com.chenps3.algs.impl.graph;

/**
 * 路径API
 * @Author chenguanhong
 * @Date 2020/5/19
 */
public abstract class Paths {

    //在g中找出所有起点为s的路径
    protected Paths(Graph g,int s) {
    }

    //是否存在从s到v的路径
    protected boolean hasPathTo(int v){
        return false;
    }

    //s到v的路径，不存在则返回null
    protected Iterable<Integer> pathTo(int v){
        return null;
    }
}
