package com.cs.leetcode.greedy_algorithm;

/**
 * author:chang shuai
 * date:2020/10/14
 * time:22:23
 *
 */
public class JumpGame {
    /**
     * 数组中存储非负整形数据，值代表从当前位置最多可以向前跳跃多少步，已知各元素，求能否从第0个位置调制最后一个元素的位置
     */
    public boolean canJump(int[] nums) {
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i + nums[i];
        }
        int jump = 0;
        int maxIndex = index[0];
        while (jump < index.length && jump <= maxIndex) {
            if (maxIndex < index[jump]) {
                maxIndex = index[jump];
            }
            jump++;
        }
        if (jump == index.length) {
            return true;
        }
        return false;
    }

    /**
     *  若必定能跳至最后一个位置，则最少跳跃几次能跳到最后一个位置
     *  在到达某点之前，若一直不跳跃，发现从该点不能跳到更远的地方，在这之前肯定有次必要的跳跃
     */
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int currentMaxIndex = nums[0];
        int preMaxMaxIndex = nums[0];
        int jumpMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > currentMaxIndex) {
                jumpMin++;
                currentMaxIndex = preMaxMaxIndex;
            }
            if (preMaxMaxIndex < nums[i] + i) {
                preMaxMaxIndex = nums[i] + i;
            }
        }
        return jumpMin;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(nums));
        System.out.println(jumpGame.jump(nums));
    }
}
