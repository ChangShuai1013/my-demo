package com.cs.leetcode.stack_queue_dump;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author:chang shuai
 * date:2020/10/8
 * time:10:53
 *
 * 使用队列实现栈
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.top());
        myStack.push(5);
        System.out.println(myStack.top());
    }
}

class MyStack {
    private Queue<Integer> data;

    public MyStack() {
        data = new LinkedList<>();
    }

    public void push(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while (!data.isEmpty()) {
            queue.offer(data.poll());
        }
        while (!queue.isEmpty()) {
            data.offer(queue.poll());
        }
    }

    public Integer pop() {
        if (!data.isEmpty()) {
            return data.poll();
        } else {
            return null;
        }
    }

    public int top() {
        return data.element();
    }

    public boolean empty() {
        return data.isEmpty();
    }
}