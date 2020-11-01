package com.cs.leetcode.recursive_backtrack_devide_and_conquer;

import java.util.*;

/**
 * author:chang shuai
 * date:2020/11/1
 * time:11:12
 *
 * 已知一组有重复元素的数，求所有子集中，各元素之和为整数target的子集，要求无重复子集
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(List<Integer> nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Set<List<Integer>> res_set = new HashSet<>();
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        generate(0, nums, result, item, res_set, 0, target);
        return result;
    }

    private void generate(int i, List<Integer> nums, List<List<Integer>> result, List<Integer> item, Set<List<Integer>> res_set, int sum, int target) {
        if (i >= nums.size() || sum > target) {
            return;
        }
        sum += nums.get(i);
        item.add(nums.get(i));
        List<Integer> list = new ArrayList<>(item);
        if (target == sum && !res_set.contains(list)) {
            result.add(list);
            res_set.add(list);
        }
        generate(i + 1, nums, result, item, res_set, sum, target);
        sum -= nums.get(i);
        item.remove(item.size() - 1);
        generate(i + 1, nums, result, item, res_set, sum, target);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 1, 2, 7, 6, 1, 5);
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> result = combinationSum2.combinationSum2(nums, 8);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}
