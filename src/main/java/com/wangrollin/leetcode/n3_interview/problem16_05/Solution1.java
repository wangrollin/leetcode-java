package com.wangrollin.leetcode.n3_interview.problem16_05;

/**
 * 阶乘尾数
 *
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 *
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释:3! = 6, 尾数中没有零。
 *
 * 示例2:
 * 输入: 5
 * 输出: 1
 * 解释:5! = 120, 尾数中有 1 个零.
 *
 * 说明: 你算法的时间复杂度应为O(logn)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-zeros-lcci
 *
 * Solution1
 * 只有2和5可以构造0，2比5多，所以关键在于找到最小因子中5的个数
 */
public class Solution1 {

    public int trailingZeroes(int n) {

        int result = 0;
        while (n != 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
}
