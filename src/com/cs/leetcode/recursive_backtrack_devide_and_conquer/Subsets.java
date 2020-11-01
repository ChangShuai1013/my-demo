package com.cs.leetcode.recursive_backtrack_devide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author:chang shuai
 * date:2020/10/26
 * time:21:17
 *
 * 求一组无重复的数的所有子集
 */
public class Subsets {
    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        result.add(item);
        generate(0, nums, item, result);
        return result;
    }

    private void generate(int i, List<Integer> nums, List<Integer> item, List<List<Integer>> result) {
        if (i >= nums.size()) {
            return;
        }
        item.add(nums.get(i));
        result.add(new ArrayList<>(item));
        generate(i + 1, nums, item, result);
        item.remove(item.size() - 1);
        generate(i + 1, nums, item, result);
    }

    /**
     * 位运算法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        int allSet = 1 << nums.size();//2^n
        for (int i = 0; i < allSet; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < nums.size(); j++) {
                System.out.println((i & (1 << j)));
                if ((i & (1 << j)) != 0) {
                    item.add(nums.get(j));
                }
            }
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        Subsets subsets = new Subsets();
        //List<List<Integer>> result = subsets.subsets1(nums);
        List<List<Integer>> result = subsets.subsets2(nums);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}
