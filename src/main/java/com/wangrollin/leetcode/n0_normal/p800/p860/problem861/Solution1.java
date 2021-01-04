package com.wangrollin.leetcode.n0_normal.p800.p860.problem861;

import java.util.Arrays;

/**
 * 翻转矩阵后的得分
 *
 * 有一个二维矩阵A 其中每个元素的值为0或1。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 *
 * 示例：
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 * 提示：
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j]是0 或1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 *
 * Solution1
 * 从题目中可以得出很重要的一点：变换的次序无所谓，最后的值是一样的，所以可以先横着变到最大，然后竖着变到最大
 */
public class Solution1 {

    public int matrixScore(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                A[i] = Arrays.stream(A[i])
                        .map(integer -> integer == 0 ? 1 : 0)
                        .toArray();
            }
        }

        for (int col = 1; col < A[0].length; col++) {

            int count = 0;
            for (int[] ints : A) {
                if (ints[col] == 0) {
                    count++;
                }
            }
            if (count > A.length / 2) {
                for (int row = 0; row < A.length; row++) {
                    A[row][col] = A[row][col] == 0 ? 1 : 0;
                }
            }
        }

        return Arrays.stream(A)
                .map(ints -> {
                    StringBuilder sb = new StringBuilder();
                    for (int anInt : ints) {
                        sb.append(anInt);
                    }
                    return Integer.parseInt(sb.toString(), 2);
                })
                .mapToInt(i -> i)
                .sum();
    }
}
