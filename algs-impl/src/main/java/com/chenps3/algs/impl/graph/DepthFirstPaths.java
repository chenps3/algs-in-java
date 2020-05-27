package com.chenps3.algs.impl.graph;

import edu.princeton.cs.algs4.Stack;

/**
 * @Author chenguanhong
 * @Date 2020/5/19
 */
public class DepthFirstPaths extends Paths {

    //在这个顶点上调用过dfs了吗
    private boolean[] marked;

    //从起点s到顶点i的已知路径上的最后一个顶点(如果顶点i要回到s，下一个应该经过顶点edgeTo[i])
    private int[] edgeTo;

    //起点
    private final int s;

    protected DepthFirstPaths(Graph g, int s) {
        super(g, s);
        this.s = s;
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        dfs(g, s);
    }

    @Override
    protected boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    protected Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }
}
