package com.wangrollin.leetcode.n0_normal.p1100.p1130.problem1137;

/**
 * 第 N 个泰波那契数
 *
 * 泰波那契序列 Tn 定义如下： 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 *
 * 示例 2：
 * 输入：n = 25
 * 输出：1389537
 *
 * 提示：
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 *
 * Solution1
 * 计算出结果，保存起来
 */
public class Solution1 {

    private static final int[] ANSWERS = new int[38];

    static {
        ANSWERS[0] = 0;
        ANSWERS[1] = 1;
        ANSWERS[2] = 1;
        for (int i = 3; i <= 37; i++) {
            ANSWERS[i] = ANSWERS[i - 1] + ANSWERS[i - 2] + ANSWERS[i - 3];
        }
    }

    public int tribonacci(int n) {

        return ANSWERS[n];
    }
}
