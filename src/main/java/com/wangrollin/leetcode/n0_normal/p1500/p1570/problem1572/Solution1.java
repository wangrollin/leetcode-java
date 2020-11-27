package com.wangrollin.leetcode.n0_normal.p1500.p1570.problem1572;

/**
 * 矩阵对角线元素的和
 *
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 *
 * 示例 1：
 * 输入：mat = [[1,2,3],
 *            [4,5,6],
 *            [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 *
 * 示例 2：
 * 输入：mat = [[1,1,1,1],
 *            [1,1,1,1],
 *            [1,1,1,1],
 *            [1,1,1,1]]
 * 输出：8
 *
 * 示例 3：
 * 输入：mat = [[5]]
 * 输出：5
 *
 * 提示：
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-diagonal-sum
 *
 * Solution1
 * 模拟遍历
 */
public class Solution1 {

    public int diagonalSum(int[][] mat) {

        final int N = mat.length;
        int result = 0;

        for (int i = 0; i < N; i++) {
            result += mat[i][i] + mat[N - 1 - i][i];
        }
        if (N % 2 == 1) {
            result -= mat[N / 2][N / 2];
        }

        return result;
    }
}
