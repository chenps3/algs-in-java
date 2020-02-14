package com.chenps3.algs.impl.chapter2;

import java.util.Random;

//比较算法性能
public class SortCompare {

    private static Random random = new Random();

    public static <T> long time(String alg, Comparable<T>[] a) {
        long start = System.currentTimeMillis();
        switch (alg) {
            case "insert":
                InsertSort.sort(a);
                break;
            case "insertv2":
                InsertSort.sortV2(a);
                break;
            case "select":
                SelectSort.sort(a);
                break;
            case "shell":
                ShellSort.sort(a);
                break;
            default:
                break;
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * 用随机double类型输入测试算法性能
     *
     * @param alg 算法名称
     * @param N   输入规模
     * @param T   测试次数
     * @return
     */
    public static long timeRandomInput(String alg, int N, int T) {
        long total = 0L;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = random.nextDouble();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        int N = 20000;
        int T = 10;
        String alg1 = "insert";
        String alg2 = "insertv2";
        String alg3 = "select";
        String alg4 = "shell";
        long time1 = timeRandomInput(alg1, N, T);
        long time2 = timeRandomInput(alg2, N, T);
        long time3 = timeRandomInput(alg3, N, T);
        long time4 = timeRandomInput(alg4, N, T);
        System.out.println(alg1 + " 输入规模" + N + " 测试次数" + T + " 用时" + time1 + "ms");
        System.out.println(alg2 + " 输入规模" + N + " 测试次数" + T + " 用时" + time2 + "ms");
        System.out.println(alg3 + " 输入规模" + N + " 测试次数" + T + " 用时" + time3 + "ms");
        System.out.println(alg4 + " 输入规模" + N + " 测试次数" + T + " 用时" + time4 + "ms");

    }

}
