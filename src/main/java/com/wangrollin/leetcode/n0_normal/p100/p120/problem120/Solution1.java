package com.wangrollin.leetcode.n0_normal.p100.p120.problem120;

import java.util.List;

/**
 * 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 *
 * 说明：
 * 如果你可以只使用 O(n)的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 *
 * Solution1
 * 存储整个矩阵，迭代
 * f(i, j)代表到达这个点的最小路径和
 * f(i, j) = min(f(i-1, j), f(i-1, j-1)) + grid[i][j]
 */
public class Solution1 {

    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j) + triangle.get(i).get(j));
                } else if (j == i) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                } else {
                    triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1))
                            + triangle.get(i).get(j));
                }
            }
        }

        return triangle
                .get(triangle.size() - 1)
                .stream()
                .mapToInt(i -> i)
                .min()
                .getAsInt();
    }
}
