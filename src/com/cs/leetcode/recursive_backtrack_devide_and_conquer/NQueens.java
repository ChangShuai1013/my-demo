package com.cs.leetcode.recursive_backtrack_devide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author:chang shuai
 * date:2020/11/1
 * time:11:39
 *
 * N皇后问题
 */
public class NQueens {
    private static final int[] dx = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};//方向数组
    private static final int[] dy = new int[]{0, 0, -1, 1, -1, 1, -1, 1};

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] mark = new int[n][n];//标记棋盘是否可以放置皇后的二维数组
        List<String> location = new ArrayList<>();//存储某个拜访结果，当完成一次递归找到结果后，将location放入result
        for (int i = 0; i < n; i++) {
            StringBuilder initLocation = new StringBuilder();
            for (int j = 0; j < n; j++) {
                mark[i][j] = 0;
                initLocation.append("*");
            }
            location.add(initLocation.toString());
        }
        generate(0, n, location, result, mark);
        return result;
    }

    /**
     *
     * @param k 完成了几个皇后的放置（正在放置第k行皇后）
     * @param n n列，一共需要放置n个皇后
     * @param location 某次结果储存在location中
     * @param result 最终结果放置在result
     * @param mark 棋盘数组
     */
    private void generate(int k, int n, List<String> location, List<List<String>> result, int[][] mark) {
        if (k == n) {//k=n时，代表完成了第0至n-1行皇后放置的位置，所有皇后完成放置后，将记录皇后未知的location数组放入result
            result.add(new ArrayList<>(location));
            return;
        }
        for (int i = 0; i < n; i++) {//按顺序尝试第0至n-1列
            if (mark[k][i] == 0) {//可以放置皇后
                int[][] tmpMark = copyMark(mark);//记录放置前的棋盘镜像
                changeLocation(k, location, i, 'Q');//记录当前皇后的位置
                putDownTheQueen(k, i, mark);//放置皇后
                generate(k + 1, n, location, result, mark);//递归下一行皇后的位置
                mark = tmpMark;//将棋盘重新赋值为放置前的状态
                changeLocation(k, location, i, '*');//将当前尝试的皇后位置重置
            }
        }
    }

    public void putDownTheQueen(int x, int y, int[][] mark) {
        mark[x][y] = 1;
        for (int i = 1; i < mark.length; i++) {
            for (int j = 0; j < 8; j++) {//遍历8个方向
                int newX = x + i * dx[j];
                int newY = y + i * dy[j];
                if (newX >= 0 && newX < mark.length && newY >= 0 && newY < mark.length) {//新位置仍在棋盘内
                    mark[newX][newY] = 1;
                }
            }
        }
    }

    public int[][] copyMark(int[][] mark) {
        int[][] tmpMark = new int[mark.length][];
        for(int i = 0;i < mark.length;i++){
            tmpMark[i] = mark[i].clone();
        }
        return tmpMark;
    }

    public void changeLocation(int k, List<String> location, int n, char ch) {
        char[] locationChars = location.get(k).toCharArray();
        locationChars[n] = ch;
        location.set(k, String.valueOf(locationChars));
    }

    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        NQueens nQueens = new NQueens();
        result = nQueens.solveNQueens(8);
        for (int i = 0; i < result.size(); i++) {
            List<String> location = result.get(i);
            for (String s : location) {
                System.out.println(s);
            }
            System.out.println("----------");
        }
    }
}
