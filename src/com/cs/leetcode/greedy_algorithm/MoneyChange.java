package com.cs.leetcode.greedy_algorithm;

/**
 * author:chang shuai
 * date:2020/10/11
 * time:10:22
 *
 * 面额为1，5，10，20，100，200的钞票，支付x元，最少需要几张
 * 贪心算法成立的前提是某张钞票面额是闭自己小的面额的倍数关系
 *
 */
public class MoneyChange {

    public static void main(String[] args) {
        int[] rmb = new int[]{200,100,20,10,5,1};
        int num = rmb.length;
        int x = 628;
        int count = 0;
        for (int i = 0; i < num; i++) {
            int use = x / rmb[i];
            count += use;
            x = x - rmb[i] * use;
            System.out.println("需要面额" + rmb[i] + "的钞票" + use + "张，剩余应支付金额为" + x);
        }
        System.out.println("共需钞票" + count + "张");
    }

}
