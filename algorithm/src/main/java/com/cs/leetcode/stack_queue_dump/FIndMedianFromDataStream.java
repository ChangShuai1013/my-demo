package com.cs.leetcode.stack_queue_dump;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * author:chang shuai
 * date:2020/10/11
 * time:09:44
 *
 * 设计一个数据结构，动态维护一组数据，支持添加元素及返回中位数
 *
 */
public class FIndMedianFromDataStream {
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7};
        MedianFinder medianFinder = new MedianFinder();
        for (int i = 0; i < test.length; i++) {
            medianFinder.addNum(test[i]);
            System.out.println(medianFinder.findMedian());
        }
    }
}

class MedianFinder {
    private PriorityQueue<Integer> bigQueue;
    private PriorityQueue<Integer> smallQueue;

    public MedianFinder() {
        this.bigQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        this.smallQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (bigQueue.isEmpty()) {
            bigQueue.add(num);
            return;
        }
        if (bigQueue.size() == smallQueue.size()) {
            if (num < bigQueue.peek()) {
                bigQueue.add(num);
            } else {
                smallQueue.add(num);
            }
        } else if (bigQueue.size() > smallQueue.size()) {
            if (num > bigQueue.peek()) {
                smallQueue.add(num);
            } else {
                smallQueue.add(bigQueue.peek());
                bigQueue.poll();
                bigQueue.add(num);
            }
        } else { //if (bigQueue.size() < smallQueue.size())
            if (num < smallQueue.peek()) {
                bigQueue.add(num);
            } else {
                bigQueue.add(smallQueue.peek());
                smallQueue.poll();
                smallQueue.add(num);
            }
        }
    }

    public double findMedian() {
        if (bigQueue.size() == smallQueue.size()) {
            return (Double.valueOf(bigQueue.peek()) + Double.valueOf(smallQueue.peek())) / 2;
        } else if (bigQueue.size() > smallQueue.size()) {
            return bigQueue.peek();
        }
        return smallQueue.peek();
    }
}