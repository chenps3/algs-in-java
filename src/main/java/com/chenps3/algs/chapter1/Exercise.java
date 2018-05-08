package com.chenps3.algs.chapter1;

public class Exercise {
    public static void main(String[] args) {

    }

    //exe 1.3.4
    static void test1() {
        boolean result = true;
        String input = "[(])";
        char[] cs = input.toCharArray();
        Stack<Character> stack = new ResizingArrayStack<>();
        for (char c : cs) {
            switch (c) {
                case '{':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.pop() != '(') {
                        result = false;
                    }
                    break;
                case ']':
                    if (stack.pop() != '[') {
                        result = false;
                    }
                    break;
                case '}':
                    if (stack.pop() != '{') {
                        result = false;
                    }
                    break;
            }
        }
        System.out.println(result);
    }

    //exe 1.3.9
    static void test2() {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String[] elements = input.split(" ");
        ResizingArrayStack<String> ops = new ResizingArrayStack<>();
        ResizingArrayStack<String> vals = new ResizingArrayStack<>();
        for (String s : elements) {
            switch (s) {
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
                    String val2 = vals.pop();
                    String val1 = vals.pop();
                    String op = ops.pop();
                    String newVal = "(" + val1 + op + val2 + ")";
                    vals.push(newVal);
                    break;
                default:
                    vals.push(s);
            }
        }
        System.out.println(vals.pop());
    }

    //exe 1.3.10 中缀表达式转后缀 很常用
    //更好的方法是用二叉树，这里先用栈
    // 1 + 3 * (6 / 2 - 2) => 1 3 6 2 / 2 - * +
    //法则：

//1）如果遇到数字，我们就直接将其输出。
//2）如果遇到非数字时，若栈为空或者该符号为左括号或者栈顶元素为括号，直接入栈。
//3）如果遇到一个右括号，持续出栈并输出符号，直到栈顶元素为左括号，然后将左括号出栈（注意，左括号只出栈，不输出），右括号不入栈
//4）如果遇到运算符号且栈非空，查看栈顶元素，如果栈顶元素的运算优先级大于或者等于该运算符号，则持续出栈，直到栈顶元素优先级小于该运算符。最后将该元素入栈
//5）如果我们读到了输入的末尾，则将栈中所有元素依次弹出。
    static void test3() {
        String input = "1 + 3 * 2 - 8 / 4";
        String[] elements = input.split(" ");
        ResizingArrayStack<String> ops = new ResizingArrayStack<>();
        StringBuilder sb = new StringBuilder();
        for(String s : elements){
            switch (s){
                case "+":
                    ops.push(s);break;
                case "-":
                    ops.push(s);break;

            }
        }
    }
}
