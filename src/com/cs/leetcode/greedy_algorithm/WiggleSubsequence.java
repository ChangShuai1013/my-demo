package com.cs.leetcode.greedy_algorithm;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.List;

/**
 * author:chang shuai
 * date:2020/10/11
 * time:10:46
 *
 * 如果一个整数序列想另两元素的差恰好正负交替出现，则该序列为摇摆序列，一个小于2个元素的序列直接为摇摆序列。
 * 求一个随机序列为摇摆序列的最长子序列长度
 *
 */
public class WiggleSubsequence {
    private static final int BEGIN = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    public int wiggleMaxLength(List<Integer> nums) {
        if (nums.size() < 2) {
            return nums.size();
        }
        int state = BEGIN;
        int maxLength = 1;
        for (int i = 1; i < nums.size(); i++) {
            switch (state) {
                case BEGIN:
                    if (nums.get(i - 1) < nums.get(i)) {
                        state = UP;
                        maxLength++;
                    } else if(nums.get(i - 1) > nums.get(i)) {
                        state = DOWN;
                        maxLength++;
                    }
                    break;
                case UP:
                    if (nums.get(i - 1) > nums.get(i)) {
                        state = DOWN;
                        maxLength++;
                    }
                    break;
                case DOWN:
                    if (nums.get(i - 1) < nums.get(i)) {
                        state = UP;
                        maxLength++;
                    }
                    break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,17,5,10,13,15,10,5,16,8);
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        System.out.println(wiggleSubsequence.wiggleMaxLength(nums));
    }
}
