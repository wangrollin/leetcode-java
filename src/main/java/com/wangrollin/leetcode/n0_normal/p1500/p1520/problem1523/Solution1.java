package com.wangrollin.leetcode.n0_normal.p1500.p1520.problem1523;

/**
 * 在区间范围内统计奇数数目
 *
 * 给你两个非负整数low 和high。请你返回low 和high之间（包括二者）奇数的数目。
 *
 * 示例 1：
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 *
 * 示例 2：
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 *
 * 提示：
 * 0 <= low <= high<= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-odd-numbers-in-an-interval-range
 *
 * Solution1
 * 可直接用数学方法计算
 */
public class Solution1 {

    public int countOdds(int low, int high) {

        return (high - low) / 2 + (low % 2 == 0 && high % 2 == 0 ? 0 : 1);
    }
}
