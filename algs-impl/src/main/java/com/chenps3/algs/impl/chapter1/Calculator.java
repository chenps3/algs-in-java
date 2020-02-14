package com.chenps3.algs.impl.chapter1;

import java.util.Stack;

//Dijkstra双栈算数表达式算法，基于内置stack
//运算符无优先级，使用括号
public class Calculator {

    public static Double eval(String exp) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            String s = String.valueOf(exp.charAt(i));
            switch (s) {
                case "(":
                    break;
                case "+":
                    ops.push(s);
                    break;
                case "-":
                    ops.push(s);
                    break;
                case "*":
                    ops.push(s);
                    break;
                case "/":
                    ops.push(s);
                    break;
                case ")":
                    double val1 = vals.pop();
                    double val2 = vals.pop();
                    String op = ops.pop();
                    switch (op) {
                        case "+":
                            vals.push(val2 + val1);
                            break;
                        case "-":
                            vals.push(val2 - val1);
                            break;
                        case "*":
                            vals.push(val2 * val1);
                            break;
                        case "/":
                            vals.push(val2 / val1);
                            break;
                    }
                    break;
                default:
                    vals.push(Double.parseDouble(s));
            }
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        String exp = "(1+((2*3)-(4/(5-6))))";
        System.out.println(eval(exp));
    }
}
