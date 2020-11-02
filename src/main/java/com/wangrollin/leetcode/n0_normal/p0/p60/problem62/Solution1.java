package com.wangrollin.leetcode.n0_normal.p0.p60.problem62;

/**
 * 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 示例1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 示例2:
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 *
 * Solution1
 * 记录整个矩阵，迭代
 * f(i, j)代表从起点走到这里的可能路线总数
 * f(i, j) = f(i-1, j) + f(i, j-1)
 */
public class Solution1 {

    public int uniquePaths(int m, int n) {

        int[][] map = new int[m][n];
        map[0][0] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if (i - 1 >= 0 && j - 1 >= 0) {
                    map[i][j] += map[i - 1][j] + map[i][j - 1];
                } else if (i - 1 < 0 && j - 1 >= 0) {
                    map[i][j] = map[i][j - 1];
                } else if (i - 1 >= 0 && j - 1 < 0) {
                    map[i][j] = map[i - 1][j];
                }
            }
        }

        return map[map.length - 1][map[0].length - 1];
    }
}
