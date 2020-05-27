package com.chenps3.algs.impl.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
/**
 * @Author chenguanhong
 * @Date 2020/5/15
 */
public class Graph {

    public static void main(String[] args) throws Exception {
    }

    //顶点数
    private int v;
    //边数
    private int e;
    //邻接表
    private Bag<Integer>[] adj;

    //创建一个含有v个顶点单不包含边的图
    public Graph(int v) {
        this.v = v;
        e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    //从文件输入创建一个图
    public Graph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    //顶点数
    public int v() {
        return v;
    }

    //边数
    public int e() {
        return e;
    }

    //向图中添加一条边v-w
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    //和v相邻的所有顶点
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(v + " vertices, " + e + " edges\n");
        for (int i = 0; i < v; i++) {
            s.append(i).append(": ");
            for (int w : adj(i)) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
