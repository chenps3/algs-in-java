package com.chenps3.algs.leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 *
 * @Author chenguanhong
 * @Date 2020/3/29
 */
public class Problem1162 {

    public static void main(String[] args) {
        int[][] a1 = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(maxDistance(a1));
        int[][] a2 = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(maxDistance(a2));
    }

    //所有陆地先入队，对每个陆地bfs，队列最后一个元素的距离一定最远
    public static int maxDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        //表示到陆地的最短距离
        int[][] distance = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    distance[i][j] = 1;
                }
            }
        }
        int[] p = null;
        boolean hasOcean = false;
        while (!queue.isEmpty()) {
            p = queue.remove();
            //上
            if (p[0] - 1 >= 0 && distance[p[0] - 1][p[1]] == 0) {
                queue.add(new int[]{p[0] - 1, p[1]});
                distance[p[0] - 1][p[1]] = distance[p[0]][p[1]] + 1;
                hasOcean = true;
            }
            //下
            if (p[0] + 1 < grid.length && distance[p[0] + 1][p[1]] == 0) {
                queue.add(new int[]{p[0] + 1, p[1]});
                distance[p[0] + 1][p[1]] = distance[p[0]][p[1]] + 1;
                hasOcean = true;
            }
            //左
            if (p[1] - 1 >= 0 && distance[p[0]][p[1] - 1] == 0) {
                queue.add(new int[]{p[0], p[1] - 1});
                distance[p[0]][p[1] - 1] = distance[p[0]][p[1]] + 1;
                hasOcean = true;
            }
            //右
            if (p[1] + 1 < grid[0].length && distance[p[0]][p[1] + 1] == 0) {
                queue.add(new int[]{p[0], p[1] + 1});
                distance[p[0]][p[1] + 1] = distance[p[0]][p[1]] + 1;
                hasOcean = true;
            }
        }
        if (p == null) {  //说明队列一直是空的，没有陆地
            return -1;
        }
        if (!hasOcean) {
            return -1;
        }
        return distance[p[0]][p[1]] - 1;
    }


}
