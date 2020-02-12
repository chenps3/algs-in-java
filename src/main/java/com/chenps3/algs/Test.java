package com.chenps3.algs;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws Exception{

    }


    private static Date getData(String data) {

        if (data == null || "".equals(data)) {
            return null;
        }
        String tmp = data;
        if (data.indexOf(".") != -1) {
            tmp = tmp.substring(0, tmp.lastIndexOf("."));
        }
        if (DEFAULT_TIME.equals(tmp)) {
            return null;
        }
        if (DEFAULT_DATE.equals(tmp)) {
            return null;
        }
        // simple date format 非线程安全，不能抽出去
        Date result = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            result = dateFormat.parse(tmp);
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }
        //处理DATE 类型
        if (result == null) {
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                result = dateFormat2.parse(tmp);
            } catch (Exception e) {
                e.printStackTrace();
                result = null;
            }
        }
        return result;
    }

    private static final BinaryOperator<List<Integer>> listMergeMethod = (l1, l2) -> Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList());

    private static final String DEFAULT_TIME = "2000-01-01 00:00:00";

    private static final String DEFAULT_DATE = "2000-01-01";
}
