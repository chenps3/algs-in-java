package com.chenps3.algs.impl.graph;

import edu.princeton.cs.algs4.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author chenguanhong
 * @Date 2020/5/21
 */
public class BreadthFirstPaths extends Paths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    protected BreadthFirstPaths(Graph g, int s) {
        super(g, s);
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        this.s = s;
        bfs(g, s);
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
        while (v != s) {
            path.push(v);
            v = edgeTo[v];
        }
        path.push(s);
        return path;
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}
