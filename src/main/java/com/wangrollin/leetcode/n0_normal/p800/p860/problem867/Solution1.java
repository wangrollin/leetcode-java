package com.wangrollin.leetcode.n0_normal.p800.p860.problem867;

/**
 * 转置矩阵
 *
 * 给定一个矩阵A，返回A的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * 示例 2：
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * 
 * 提示：
 * 1 <= A.length<= 1000
 * 1 <= A[0].length<= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/transpose-matrix
 *
 * Solution1
 * 双层for循环
 */
public class Solution1 {

    public int[][] transpose(int[][] A) {

        int[][] result = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[j][i] = A[i][j];
            }
        }

        return result;
    }
}
