package com.cs.leetcode.stack_queue_dump;

import java.util.Stack;

/**
 * author:chang shuai
 * date:2020/10/8
 * time:11:19
 *
 * 包含min函数的栈
 */
public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> min;

    public MinStack() {
        this.data = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.empty()) {
            min.push(x);
        } else {
            if (x > min.peek()) {
                x = min.peek();
            }
            min.push(x);
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        System.out.println("top = " + minStack.top() + ", min = " + minStack.getMin());
        minStack.push(0);
        System.out.println("top = " + minStack.top() + ", min = " + minStack.getMin());
        minStack.push(-5);
        System.out.println("top = " + minStack.top() + ", min = " + minStack.getMin());
        minStack.pop();
        System.out.println("top = " + minStack.top() + ", min = " + minStack.getMin());

    }
}
