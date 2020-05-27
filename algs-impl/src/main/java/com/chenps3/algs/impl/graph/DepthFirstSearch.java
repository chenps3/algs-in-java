package com.chenps3.algs.impl.graph;

/**
 * @Author chenguanhong
 * @Date 2020/5/16
 */
public class DepthFirstSearch extends Search {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        super(g, s);
        marked = new boolean[g.v()];
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
