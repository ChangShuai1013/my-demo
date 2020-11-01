package com.cs.leetcode.recursive_backtrack_devide_and_conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * author:chang shuai
 * date:2020/11/1
 * time:11:27
 *
 * 已知n组括号，生成这n组括号的所有合法组合可能
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", n, n, result);
        return result;
    }

    /**
     * （、）最多放置n个
     * 若（的数量>）的数量，不可进行放置）的递归
     * @param item
     * @param left
     * @param right
     * @param result
     */
    private void generate(String item, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(item);
        }
        if (left > 0) {
            generate(item + "(", left - 1, right, result);
        }
        if (left < right) {
            generate(item + ")", left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(3);
        System.out.println(result);
    }
}
