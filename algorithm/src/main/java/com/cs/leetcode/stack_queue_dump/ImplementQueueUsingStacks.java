package com.cs.leetcode.stack_queue_dump;

import java.util.Stack;

/**
 * author:chang shuai
 * date:2020/10/8
 * time:11:12
 *
 * 利用栈实现队列
 */
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.peek());
    }
}

class MyQueue {
    private Stack<Integer> data;

    public MyQueue() {
        data = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> stack = new Stack<>();
        while (!data.empty()) {
            stack.push(data.pop());
        }
        stack.push(x);
        while (!stack.empty()) {
            data.push(stack.pop());
        }
    }

    public Integer pop() {
        if (!data.empty()) {
            return data.pop();
        } else {
            return null;
        }
    }

    public int peek() {
        return data.peek();
    }

    public boolean empty() {
        return data.empty();
    }
}