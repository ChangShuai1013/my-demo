package com.cs.leetcode.greedy_algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * author:chang shuai
 * date:2020/10/25
 * time:15:20
 *
 * 一个平面上有一定数量的气球，平面可以看作一个坐标系，在x轴安排弓箭手向y方向射箭，弓箭可以在y轴走无穷远。
 * 气球宽度start < x < end，至少需要多少弓箭手能将气球全部打爆
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(List<Pair> points) {
        if (points.size() == 0) {
            return 0;
        }
        points.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.getStart() - o2.getStart();
            }
        });
        int shootNum = 1;
        int shootBegin = points.get(0).getStart();
        int shootEnd = points.get(0).getEnd();
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).getStart() > shootBegin) {
                shootBegin = points.get(i).getStart();
                if (shootEnd > points.get(i).getEnd()) {
                    shootEnd = points.get(i).getEnd();
                }
            } else {
                shootNum++;
                shootBegin = points.get(i).getStart();
                shootEnd = points.get(i).getEnd();
            }
        }
        return shootNum;
    }

    public static void main(String[] args) {
        List<Pair> points = new ArrayList<>();
        points.add(new Pair(10, 16));
        points.add(new Pair(2, 8));
        points.add(new Pair(1, 6));
        points.add(new Pair(7, 12));
        MinimumNumberOfArrowsToBurstBalloons number = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(number.findMinArrowShots(points));
    }
}


class Pair {
    private int start;
    private int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}