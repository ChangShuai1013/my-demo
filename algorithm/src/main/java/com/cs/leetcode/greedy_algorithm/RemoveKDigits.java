package com.cs.leetcode.greedy_algorithm;

import java.util.Stack;

/**
 * author:chang shuai
 * date:2020/10/11
 * time:17:54
 *
 * 一个非负整数num，移除其中的k个数字，使新数字最小，num不以0开头，长度小于10002
 * 从高位向低位遍历，如果对应的数字大于下一位的数字，则把该位数字去掉
 */
public class RemoveKDigits {
    public String removeKDigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.push(num.charAt(0) - '0');
        for (int i = 1; i < num.length(); i++) {
            int x = num.charAt(i) - '0';
            while (!stack.empty() && stack.peek() > x && k > 0) {
                stack.pop();
                k--;
            }
            if (x != 0 || stack.size() != 0) {
                stack.push(x);
            }
        }
        while (!stack.empty() && k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : stack) {
            stringBuilder.append(integer);
        }
        String result = stringBuilder.toString();
        if (result.equals("")) {
            return "0";
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKDigits("1432219", 3));
        System.out.println(removeKDigits.removeKDigits("100200", 1));
    }
}
