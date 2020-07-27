package com.wangrollin.leetcode.n0_normal.p300.p320.problem326;

/**
 * 3的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 * 输入: 27
 * 输出: true
 *
 * 示例 2:
 * 输入: 0
 * 输出: false
 *
 * 示例 3:
 * 输入: 9
 * 输出: true
 *
 * 示例 4:
 * 输入: 45
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 *
 * Solution3
 * 数学公式推导，n=3的i次方，i=log3(n), i=logn/log3, 看i是否是整数
 * (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
 *
 * 转换成3进制，如果符合条件，则会匹配上
 *
 */
public class Solution3 {

    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
