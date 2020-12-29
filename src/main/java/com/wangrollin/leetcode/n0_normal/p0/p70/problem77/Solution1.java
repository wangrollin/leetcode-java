package com.wangrollin.leetcode.n0_normal.p0.p70.problem77;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 * 输入:n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 *
 * Solution1
 * 每个位置0或1
 */
public class Solution1 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        calc(result, 1, n, k, new ArrayList<>());
        return result;
    }

    private void calc(List<List<Integer>> result,
                      int curNum,
                      final int n,
                      int restQuantity,
                      List<Integer> curList) {

        if (restQuantity == 0) {
            result.add(curList);
            return;
        }
        if (n - curNum + 1 == restQuantity) {
            for (int i = curNum; i <= n; i++) {
                curList.add(i);
            }
            result.add(curList);
            return;
        }

        List<Integer> newList = new ArrayList<>(curList);
        newList.add(curNum);
        calc(result, curNum + 1, n, restQuantity - 1, newList);

        calc(result, curNum + 1, n, restQuantity, curList);
    }

}
