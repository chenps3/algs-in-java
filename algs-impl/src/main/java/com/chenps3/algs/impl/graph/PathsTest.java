package com.chenps3.algs.impl.graph;

import edu.princeton.cs.algs4.In;

/**
 * @Author chenguanhong
 * @Date 2020/5/19
 */
public class PathsTest {

    public static void main(String[] args) {
        Graph g = new Graph(new In("/Users/chenps3/Desktop/GitHub/algs/algs-impl/src/main/resources/tinyCG.txt"));
        int s = 0;
        Paths paths = new BreadthFirstPaths(g, s);
        for (int i = 0; i < g.v(); i++) {
            System.out.print(s + " to " + i + ": ");
            if(paths.hasPathTo(i)){
                Iterable<Integer> iterable = paths.pathTo(i);
                for (int x : iterable){
                    if(x == s){
                        System.out.print(x);
                    }else{
                        System.out.print("-" + x);
                    }
                }
            }
            System.out.println();
        }
    }
}
