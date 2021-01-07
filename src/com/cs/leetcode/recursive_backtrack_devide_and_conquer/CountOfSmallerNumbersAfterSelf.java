package com.cs.leetcode.recursive_backtrack_devide_and_conquer;

import java.util.Arrays;

/**
 * author:chang shuai
 * date:2020/11/1
 * time:12:44
 *
 * 逆序数，一直数组nums， 求新数组count，count[i]代表在nums[i]右侧且比nums[i]小的元素个数
 */
public class CountOfSmallerNumbersAfterSelf {
    public int[] countSmaller(int[] nums) {
        int[] counts = new int[nums.length];
        return counts;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        CountOfSmallerNumbersAfterSelf countOfSmallerNumbersAfterSelf = new CountOfSmallerNumbersAfterSelf();
        int[] counts = countOfSmallerNumbersAfterSelf.countSmaller(nums);
        System.out.println(Arrays.asList(counts));
    }
}
