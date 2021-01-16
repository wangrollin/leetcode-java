package com.wangrollin.leetcode.n2_codingInterviews.p60.problem64;

/**
 * 求1+2+…+n
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 * 输入: n = 3
 * 输出:6
 *
 * 示例 2：
 * 输入: n = 9
 * 输出:45
 *
 * 限制：
 * 1 <= n<= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 *
 * Solution1
 * 使用 || 的熔断特性来进行递归的判断
 */
public class Solution1 {

    public int sumNums(int n) {

        int result;

        boolean h = (result = n) == 1 || (result = n + sumNums(n - 1)) == 1;

        return result;
    }
}
