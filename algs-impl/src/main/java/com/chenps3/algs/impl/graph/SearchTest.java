package com.chenps3.algs.impl.graph;

import edu.princeton.cs.algs4.In;

/**
 * @Author chenguanhong
 * @Date 2020/5/16
 */
public class SearchTest {

    public static void main(String[] args) throws Exception {
        Graph g = new Graph(new In("/Users/chenps3/Desktop/GitHub/algs/algs-impl/src/main/resources/tinyG.txt"));
        int s = 9;
        Search search = new DepthFirstSearch(g, s);
        for (int i = 0; i < g.v(); i++) {
            if(search.marked(i)){
                System.out.println(i + " ");
            }
        }
        System.out.println();
        if(search.count() != g.v()){
            System.out.print("NOT ");
        }
        System.out.println("connected");
    }
}
