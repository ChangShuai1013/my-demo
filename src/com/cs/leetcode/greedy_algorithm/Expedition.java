package com.cs.leetcode.greedy_algorithm;

import java.util.*;

/**
 * author:chang shuai
 * date:2020/10/25
 * time:15:36
 *
 * 一条有起止点的公路，之间有n个加油站。已知从n个加油站到终点的距离d和各加油站可加的油量l、起止点距离L以及起始油量P。
 * 一个单位的汽油可走一个单位的距离，油箱无上线，最少加几次油可开至终点，若无法到达，返回-1
 *
 * 油用光时加油，油量最多的加油站加油
 */
public class Expedition {
    public int getMinimumStop(int L, int P, List<Pair> stop) {//<d, l>
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int result = 0;
        stop.add(new Pair(0, 0));
        stop.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.getStart() - o1.getStart();
            }
        });
        for (int i = 0; i < stop.size(); i++) {
            int dis = L - stop.get(i).getStart();
            while (!q.isEmpty() && P < dis) {
                P += q.poll();
                result++;
            }
            if (q.isEmpty() && P < dis) {
                return -1;
            }
            P = P - dis;
            L = stop.get(i).getStart();
            q.add(stop.get(i).getEnd());
        }
        return result;
    }

    public static void main(String[] args) {
        List<Pair> stop = new ArrayList<>();
        stop.add(new Pair(4, 4));
        stop.add(new Pair(5, 2));
        stop.add(new Pair(11, 5));
        stop.add(new Pair(15, 10));
        int L = 25;
        int P = 10;
        Expedition expedition = new Expedition();
        System.out.println(expedition.getMinimumStop(L, P, stop));
    }
}