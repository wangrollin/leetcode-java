package com.wangrollin.leetcode.p1300.p1350.problem1351;

/**
 * 统计有序矩阵中的负数
 *
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
 * 请你统计并返回 grid 中 负数 的数目。
 *
 * 示例 1：
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 *
 * 示例 2：
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 *
 * 示例 3：
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 *
 * 示例 4：
 * 输入：grid = [[-1]]
 * 输出：1
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix
 *
 * Solution1
 * 官方答案值得一看https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/solution/tong-ji-you-xu-ju-zhen-zhong-de-fu-shu-by-leetcode/
 * 其中倒序遍历很棒
 * 我用的是正序遍历，每次都会相应截短colLen（双百通过）
 */
public class Solution1 {

    public int countNegatives(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;
        int curColLen = colLen;

        boolean isFirstNegative = false;
        int result = 0;

        for (int i = 0; i < rowLen; i++) {

            if (isFirstNegative) {
                result += (rowLen - i) * colLen;
                break;
            }

            for (int j = 0; j < curColLen; j++) {
                if (grid[i][j] < 0) {
                    if (j == 0) {
                        isFirstNegative = true;
                    }
                    result += colLen - j;
                    curColLen = j + 1;
                    break;
                }
            }
        }

        return result;
    }
}
