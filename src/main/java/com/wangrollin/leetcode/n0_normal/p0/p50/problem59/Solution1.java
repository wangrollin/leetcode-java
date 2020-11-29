package com.wangrollin.leetcode.n0_normal.p0.p50.problem59;

/**
 * 螺旋矩阵 II
 *
 * 给定一个正整数n，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 *
 * Solution1
 * 模拟螺旋遍历
 */
public class Solution1 {

    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int leftLimit = 0;
        int rightLimit = n - 1;
        int topLimit = 0;
        int bottomLimit = n - 1;

        Direction curDirection = Direction.RIGHT;
        int curRow = 0;
        int curCol = 0;

        for (int i = 1; i <= n * n; i++) {

            result[curRow][curCol] = i;
            switch (curDirection) {
                case TOP:
                    if (curRow == topLimit) {
                        curDirection = Direction.RIGHT;
                        leftLimit++;
                        curCol++;
                    } else {
                        curRow--;
                    }
                    break;
                case LEFT:
                    if (curCol == leftLimit) {
                        curDirection = Direction.TOP;
                        bottomLimit--;
                        curRow--;
                    } else {
                        curCol--;
                    }
                    break;
                case RIGHT:
                    if (curCol == rightLimit) {
                        curDirection = Direction.BOTTOM;
                        topLimit++;
                        curRow++;
                    } else {
                        curCol++;
                    }
                    break;
                case BOTTOM:
                    if (curRow == bottomLimit) {
                        curDirection = Direction.LEFT;
                        rightLimit--;
                        curCol--;
                    } else {
                        curRow++;
                    }
                    break;
            }
        }

        return result;
    }

    private static enum Direction {

        TOP, BOTTOM, LEFT, RIGHT;
    }
}
