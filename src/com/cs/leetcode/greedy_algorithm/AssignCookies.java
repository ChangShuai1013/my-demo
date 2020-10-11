package com.cs.leetcode.greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * author:chang shuai
 * date:2020/10/11
 * time:10:28
 *
 * 每个孩子有需求因子g，每个糖果有大小s，当s>=g时代表孩子能被满足，一个孩子最多只能用一个糖果满足，求这些糖果最多能满足多少孩子
 *
 */
public class AssignCookies {

    public int findContentChildren(List<Integer> g, List<Integer> s) {
        Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
        g.sort(comparator);
        s.sort(comparator);
        int child = 0;
        int cookie = 0;
        while (child < g.size() && cookie < s.size()) {
            if (g.get(child) <= s.get(cookie)) {
                child++;
            }
            cookie++;
        }
        return child;
    }

    public static void main(String[] args) {
        List<Integer> g = Arrays.asList(5,10,2,9,15,9);
        List<Integer> s = Arrays.asList(6,1,20,3,8);
        AssignCookies assignCookies = new AssignCookies();
        System.out.println(assignCookies.findContentChildren(g, s));
    }
}
