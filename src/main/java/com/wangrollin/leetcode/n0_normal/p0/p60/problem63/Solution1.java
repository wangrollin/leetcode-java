package com.wangrollin.leetcode.n0_normal.p0.p60.problem63;

/**
 * 不同路径 II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m和 n 的值均不超过 100。
 *
 * 示例1:
 * 输入:
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 *
 * Solution1
 * 记录整个矩阵，迭代
 * f(i, j)代表从起点走到这里的可能路线总数
 * f(i, j) = f(i-1, j) + f(i, j-1) 要考虑到障碍物的影响
 */
public class Solution1 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];
        map[0][0] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                if (i - 1 >= 0 && obstacleGrid[i - 1][j] == 0 && j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    map[i][j] += map[i - 1][j] + map[i][j - 1];
                } else if ((i - 1 < 0 || obstacleGrid[i - 1][j] == 1) && (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0)) {
                    map[i][j] = map[i][j - 1];
                } else if ((i - 1 >= 0 && obstacleGrid[i - 1][j] == 0) && (j - 1 < 0 || obstacleGrid[i][j - 1] == 1)) {
                    map[i][j] = map[i - 1][j];
                }
            }
        }

        return map[map.length - 1][map[0].length - 1];
    }
}
