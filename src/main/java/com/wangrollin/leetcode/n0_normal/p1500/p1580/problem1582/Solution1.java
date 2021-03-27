package com.wangrollin.leetcode.n0_normal.p1500.p1580.problem1582;

import java.util.Arrays;

/**
 * 二进制矩阵中的特殊位置
 *
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵mat 中特殊位置的数目 。
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），
 * 则位置 (i, j) 被称为特殊位置。
 *
 * 示例 1：
 * 输入：mat = [[1,0,0],
 *            [0,0,1],
 *            [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 *
 * 示例 2：
 * 输入：mat = [[1,0,0],
 *            [0,1,0],
 *            [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 *
 * 示例 3：
 * 输入：mat = [[0,0,0,1],
 *            [1,0,0,0],
 *            [0,1,1,0],
 *            [0,0,0,0]]
 * 输出：2
 *
 * 示例 4：
 * 输入：mat = [[0,0,0,0,0],
 *            [1,0,0,0,0],
 *            [0,1,0,0,0],
 *            [0,0,1,0,0],
 *            [0,0,0,1,1]]
 * 输出：3
 *
 * 提示：
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/special-positions-in-a-binary-matrix
 *
 * Solution1
 * 记录下来每个行每个列的1的个数，然后遍历1的位置，如果该位置对应的行和列的1的个数为1，则是一个答案
 */
public class Solution1 {

    public int numSpecial(int[][] mat) {

        int rowLen = mat.length;
        int colLen = mat[0].length;

        int[] rows = new int[rowLen];
        int[] cols = new int[colLen];

        Arrays.fill(rows, 0);
        Arrays.fill(cols, 0);

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }
}
