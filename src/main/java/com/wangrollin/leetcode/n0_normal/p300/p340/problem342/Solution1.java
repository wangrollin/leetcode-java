package com.wangrollin.leetcode.n0_normal.p300.p340.problem342;

/**
 * 4的幂
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4的幂次方。
 *
 * 示例 1:
 * 输入: 16
 * 输出: true
 *
 * 示例 2:
 * 输入: 5
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 *
 * Solution1
 * 可以转换成4进制，然后正则匹配[^10*$]
 * logn/log4是否为整数
 * logn/log2是否为偶数
 * 不断除下去
 */
public class Solution1 {

    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }
}
