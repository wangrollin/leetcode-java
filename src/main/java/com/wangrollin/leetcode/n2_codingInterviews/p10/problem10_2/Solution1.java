package com.wangrollin.leetcode.n2_codingInterviews.p10.problem10_2;

/**
 * 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 *
 * 提示：
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 * Solution1
 * 迭代，存储两个结果
 * f(i)代表踩了第i阶台阶的情况下，从1-i的可能性数量
 * 状态转移方程：f(n) = f(n-1) + f(n-2)
 */
public class Solution1 {

    public int numWays(int n) {

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int firstOptCnt = 1;
        int secondOptCnt = 2;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = (firstOptCnt + secondOptCnt) % 1000000007;
            firstOptCnt = secondOptCnt;
            secondOptCnt = result;
        }

        return result;
    }
}
