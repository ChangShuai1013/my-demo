package com.cs.leetcode.stack_queue_dump;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * author:chang shuai
 * date:2020/10/8
 * time:11:29
 *
 * 已知1到n的数字序列，按顺序入栈，每个数字入栈后即可出栈，也可停留等后面的数字入栈出栈后再出栈，求出栈序列是否合法
 *
 */
public class Rails {

    public boolean checkIsValidOrder(Queue<Integer> order) {
        Stack<Integer> stack = new Stack<>();
        int n = order.size();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            while (!stack.empty() && !order.isEmpty() && order.peek().equals(stack.peek())) {
                order.poll();
                stack.pop();
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(6, 5, 4, 3, 2, 1));
        Rails rails = new Rails();
        System.out.println(rails.checkIsValidOrder(queue));
    }
}
