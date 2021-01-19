package com.cs.leetcode.stack_queue_dump;

import java.util.Stack;

/**
 * author:chang shuai
 * date:2020/10/8
 * time:22:30
 *
 * 计算包含括号、+、-的数学表达式的计算器，表达式中可能存在空格，保证合法
 *
 */
public class BasicCalculator {
    private static final int STATE_BEGIN = 0;
    private static final int NUMBER_STATE = 1;
    private static final int OPERATION_STATE = 2;

    private Stack<Integer> numberStack = new Stack<>();
    private Stack<Character> operationStack = new Stack<>();

    public int calculate(String s) {
        int number = 0;
        int state = STATE_BEGIN;
        int computeFlag = 0;//记录是否可以计算，+-可以计算是1，（不能计算是0
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == ' ') {
                continue;
            }
            switch (state) {
                case STATE_BEGIN:
                    if (x >= '0' && x <= '9') {
                        state = NUMBER_STATE;
                    } else {
                        state = OPERATION_STATE;
                    }
                    i--;
                    break;
                case NUMBER_STATE:
                    if (x >= '0' && x <= '9') {
                        number = number * 10 + x - '0';
                    } else {
                        numberStack.push(number);
                        if (computeFlag == 1) {
                            compute(numberStack, operationStack);
                        }
                        number = 0;
                        i--;
                        state = OPERATION_STATE;
                    }
                    break;
                case OPERATION_STATE:
                    if (x == '+' || x == '-') {
                        operationStack.push(x);
                        computeFlag = 1;
                    } else if (x == '(') {
                        state = NUMBER_STATE;
                        computeFlag = 0;
                    } else if (x >= '0' && x <= '9') {
                        state = NUMBER_STATE;
                        i--;
                    } else if (x == ')') {
                        compute(numberStack, operationStack);
                    }
                    break;
            }
        }
        if (number != 0) {
            numberStack.push(number);
            compute(numberStack, operationStack);
        }
        if (number == 0 && numberStack.empty()) {
            return 0;
        }
        return numberStack.pop();
    }

    public void compute(Stack<Integer> numberStack, Stack<Character> operationStack) {
        if (numberStack.size() < 2) {
            return;
        }
        int num2 = numberStack.pop();
        int num1 = numberStack.pop();
        char operator = operationStack.pop();
        if (operator == '+') {
            numberStack.push(num1 + num2);
        } else if (operator == '-') {
            numberStack.push(num1 - num2);
        }
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate("1+121-(14+(5-6))"));
    }
}
