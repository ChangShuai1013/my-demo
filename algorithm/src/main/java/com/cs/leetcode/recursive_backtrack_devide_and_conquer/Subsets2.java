package com.cs.leetcode.recursive_backtrack_devide_and_conquer;

import java.util.*;

/**
 * author:chang shuai
 * date:2020/10/26
 * time:21:50
 *
 * 求一组有重复的数的所有子集
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Set<List<Integer>> res_set = new HashSet<>();
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        result.add(item);
        generate(0, nums, result, item, res_set);
        return result;
    }

    private void generate(int i, List<Integer> nums, List<List<Integer>> result, List<Integer> item, Set<List<Integer>> res_set) {
        if (i >= nums.size()) {
            return;
        }
        item.add(nums.get(i));
        List<Integer> list = new ArrayList<>(item);
        if (!res_set.contains(list)) {
            result.add(list);
            res_set.add(list);
        }
        generate(i + 1, nums, result, item, res_set);
        item.remove(item.size() - 1);
        generate(i + 1, nums, result, item, res_set);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 1, 2, 2);
        Subsets2 subsets = new Subsets2();
        List<List<Integer>> result = subsets.subsetsWithDup(nums);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}
