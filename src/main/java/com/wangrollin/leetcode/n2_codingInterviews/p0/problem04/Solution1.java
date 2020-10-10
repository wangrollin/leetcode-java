package com.wangrollin.leetcode.n2_codingInterviews.p0.problem04;

/**
 * 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * 给定target=20，返回false。
 *
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 *
 * Solution1
 * 在计算的过程中进行剪枝
 */
public class Solution1 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int Y = matrix.length;
        int X = matrix[0].length;
        if (X == 0) {
            return false;
        }

        for (int[] ints : matrix) {
            for (int x = 0; x < X; x++) {
                if (ints[x] == target) {
                    return true;
                } else if (ints[x] < target) {
                    continue;
                } else {
                    X = x;
                    break;
                }
            }
        }
        return false;
    }
}
