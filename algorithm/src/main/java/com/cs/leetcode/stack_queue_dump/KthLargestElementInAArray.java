package com.cs.leetcode.stack_queue_dump;

import java.util.PriorityQueue;

/**
 * author:chang shuai
 * date:2020/10/11
 * time:09:37
 *
 * 求数组中第k大的元素
 *
 */
public class KthLargestElementInAArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (q.size() < k) {
                q.add(nums[i]);
            } else if (q.peek() < nums[i]) {
                q.poll();
                q.add(nums[i]);
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        KthLargestElementInAArray kthLargestElementInAArray = new KthLargestElementInAArray();
        System.out.println(kthLargestElementInAArray.findKthLargest(nums, 2));
    }
}
