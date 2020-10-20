package com.wangrollin.leetcode.n0_normal.p0.p0.problem9;

/**
 * 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 *
 * Solution1
 * 最简单的方式，转换成字符串，左右比较
 */
public class Solution1 {

    public boolean isPalindrome(int x) {

        String intStr = Integer.toString(x);

        for (int left = 0, right = intStr.length() - 1; left < right; left++, right--) {

            if (intStr.charAt(left) != intStr.charAt(right)) {
                return false;
            }
        }

        return true;
    }
}
