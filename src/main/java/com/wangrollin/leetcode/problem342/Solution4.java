package com.wangrollin.leetcode.problem342;

/**
 * 4的幂
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
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
 * Solution4
 * 位操作：如果 num 是否为 2 的幂，则 x > 0 and x & (x - 1) == 0
 * num = 2pow(a), a=2k+1, a=2k
 * num%3=2pow(2k+1)%3=2*4pow(k)%3=2*(3+1)pow(k)%3=2
 * num%3=2pow(2k)%3=4pow(k)%3=(3+1)pow(k)%3=1
 */
public class Solution4 {

    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }
}
