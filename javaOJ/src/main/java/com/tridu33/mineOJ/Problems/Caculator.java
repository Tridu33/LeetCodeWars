package com.tridu33.mineOJ.Problems;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * OJ考题代码：四则运算求值
 * 1+2*3-100/2
 * @author 命题组
 * @since 2021-02-04
 */


import java.util.Scanner;

/**
 * OJ考题代码：四则运算求值
 *
 * @author 命题组
 * @since 2021-02-04
 */
public class Caculator {
    /**
     * main入口由OJ平台调用
     */
    // 初始化操作符的优先级
    private static HashMap<Character, Integer> priority = new HashMap<>();
    static {
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String expression = cin.nextLine();
        cin.close();
        String result = calculate(expression);
        System.out.println(result);
    }
    // 待实现函数，在此函数中填入答题代码
    private static String calculate(String expression) {
        Deque<Integer> stackNums = new ArrayDeque<Integer>();
        Deque<Character> stackOptions = new ArrayDeque<Character>();
        try {
            int index = 0;
            while (index < expression.length()) {
                int num = 0;
                char cur = expression.charAt(index);
                // 数入栈，要考虑两位及两位以上的数，一直取数到不是数字为止
                while (Character.isDigit(cur)) {
                    num = num * 10 + cur - '0';
                    if (++index == expression.length()) {
                        stackNums.addLast(num);
                        break;
                    }
                    cur = expression.charAt(index);
                }
                //操作符入栈，不是最后一个数，则必是操作符
                if (index != expression.length()) {
                    stackNums.addLast(num);
                    addOptions(stackNums, stackOptions, cur);
                }
                index++;
            }
            calRes(stackNums, stackOptions);
            return "" + stackNums.peekLast();
        } catch (Exception e) {
            // catch除0异常，不记得除0异常咋写了，就直接catch Exception
            return "error";
        }
    }
    // 扫描入栈时，计算中间结果
    private static void calRes(Deque<Integer> stackNums, Deque<Character> stackOptions) {
        while (!stackOptions.isEmpty()) {
            char curOp = stackOptions.pollLast();
            int num2 = stackNums.pollLast();
            int num1 = stackNums.pollLast();
            int res = calculator(num1, num2, curOp);
            stackNums.addLast(res);
        }
    }
    // 计算器，除0风险不用考虑，被catch
    private static int calculator(int num1, int num2, char operation) {
        if (operation == '+') {
            return num1 + num2;
        }
        if (operation == '-') {
            return num1 - num2;
        }
        if (operation == '*') {
            return num1 * num2;
        }
        if (operation == '/') {
            return num1 / num2;
        }
        return 0;
    }
    // 操作符入栈
    private static void addOptions(Deque<Integer> stackNums, Deque<Character> stackOptions, char curOp) {
        // 操作符入栈前，要判断是否需要计算中间结果入数栈
        while (!stackOptions.isEmpty()) {
            char operation = stackOptions.getLast();
            if (priority.get(curOp) <= priority.get(operation)) {
                stackOptions.pollLast();
                int num2 = stackNums.pollLast();
                int num1 = stackNums.pollLast();
                int res = calculator(num1, num2, operation);
                stackNums.addLast(res);
            } else {
                break;
            }
        }
        stackOptions.addLast(curOp);
    }
}