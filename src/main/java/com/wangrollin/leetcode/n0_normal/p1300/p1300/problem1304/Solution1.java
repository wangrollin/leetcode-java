package com.wangrollin.leetcode.n0_normal.p1300.p1300.problem1304;

/**
 * 和为零的N个唯一整数
 *
 * 给你一个整数n，请你返回 任意一个由 n个 各不相同的整数组成的数组，并且这 n 个数相加和为 0 。
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：[-1,0,1]
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：[0]
 * 
 * 提示：
 * 1 <= n <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero
 *
 * Solution1
 * -sum,1,2,3,...,n-1
 */
public class Solution1 {

    public int[] sumZero(int n) {

        int[] result = new int[n];

        int sum = (n - 1) * n / 2;
        result[0] = -1 * sum;
        for (int i = 1; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }
}
