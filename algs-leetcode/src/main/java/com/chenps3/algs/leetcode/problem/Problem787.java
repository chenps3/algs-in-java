package com.chenps3.algs.leetcode.problem;

import java.util.*;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * 堆
 * 图的广度优先搜索
 *
 * @Author chenguanhong
 * @Date 2020-02-14
 */
public class Problem787 {

    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {{3, 0, 8}, {1, 4, 1}, {1, 0, 4}, {1, 3, 3}, {3, 4, 1}, {2, 3, 3}, {2, 0, 10}};
        int src = 1;
        int dst = 4;
        int K = 4;
        int result = new Problem787().findCheapestPrice(n, flights, src, dst, K);
        System.out.println(result);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.price));
        Map<Integer, List<Flight>> flightMap = flightMap(flights);
        List<Flight> flightFromSrc = flightMap.get(src);
        Queue<Flight> queue = new LinkedList<>();
        if (flightFromSrc != null) {
            queue.addAll(flightFromSrc);
        }
        boolean[] checked = new boolean[n];
        while (!queue.isEmpty()) {
            Flight flight = queue.remove();
            //目的地已经检查过
            if (checked[flight.dst]) {
                continue;
            }
            if (flight.dst == dst) {
                Route r = new Route(flight.totalStop, flight.totalPrice);
                pq.add(r);
            } else {
                List<Flight> nextFlights = flightMap.get(flight.dst);
                if (nextFlights != null) {
                    for (Flight next : nextFlights) {
                        next.totalPrice += flight.totalPrice;
                        next.totalStop = flight.totalStop + 1;
                    }
                    queue.addAll(nextFlights);
                }
                checked[flight.dst] = true;
            }
        }
        while (!pq.isEmpty()) {
            Route route = pq.poll();
            if (route.stop <= K) {
                return route.price;
            }
        }
        return -1;
    }


    //key：city
    //value：flight list
    private Map<Integer, List<Flight>> flightMap(int[][] flights) {
        Map<Integer, List<Flight>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int[] flight = flights[i];
            List<Flight> flightList = map.get(flight[0]);
            if (flightList == null) {
                flightList = new ArrayList<>();
                map.put(flight[0], flightList);
            }
            flightList.add(new Flight(flight[0], flight[1], flight[2]));
        }
        return map;
    }

    private class Flight {
        private int src;
        private int dst;
        private int price;
        private int totalStop;
        private int totalPrice;

        public Flight(int src, int dst, int price) {
            this.src = src;
            this.dst = dst;
            this.price = price;
            totalStop = 0;
            totalPrice = price;
        }
    }

    private class Route {

        private int stop;
        private int price;

        public Route(int stop, int price) {
            this.stop = stop;
            this.price = price;
        }
    }


}
