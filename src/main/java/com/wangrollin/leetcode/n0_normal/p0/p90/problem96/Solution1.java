package com.wangrollin.leetcode.n0_normal.p0.p90.problem96;

import java.util.HashMap;
import java.util.Map;

/**
 * 不同的二叉搜索树
 *
 * 给定一个整数 n，求以1 ...n为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 *
 * Solution1
 * 动态规划
 */
public class Solution1 {

    public int numTrees(int n) {

        if (n < 1) {
            return 0;
        }

        Map<Integer, Integer> numMap = new HashMap<>();
        numMap.put(0, 1);
        numMap.put(1, 1);

        calNum(numMap, n);
        return calNum(numMap, n);
    }

    private int calNum(Map<Integer, Integer> numMap, int n) {

        if (numMap.containsKey(n)) {
            return numMap.get(n);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum += calNum(numMap, i) * calNum(numMap, n - 1 - i);
        }

        numMap.put(n, sum);
        return sum;
    }
}
