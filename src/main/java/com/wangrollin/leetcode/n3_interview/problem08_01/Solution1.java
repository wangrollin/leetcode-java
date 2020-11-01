package com.wangrollin.leetcode.n3_interview.problem08_01;

/**
 * 三步问题
 *
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 *
 * 示例2:
 *  输入：n = 5
 *  输出：13
 *
 * 提示:
 * n范围在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 *
 * Solution1
 * 迭代，存储两个结果
 * f(i)代表踩了第i阶台阶的情况下，从1-i的可能性数量
 * 状态转移方程：f(n) = f(n-1) + f(n-2) + f(n-3)
 */
public class Solution1 {

    public int waysToStep(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        int firstOptCnt = 1;
        int secondOptCnt = 2;
        int thirdOptCnt = 4;
        int result = 0;

        for (int i = 4; i <= n; i++) {
            result = ((firstOptCnt + secondOptCnt) % 1000000007 + thirdOptCnt) % 1000000007;
            firstOptCnt = secondOptCnt;
            secondOptCnt = thirdOptCnt;
            thirdOptCnt = result;
        }

        return result;
    }
}
