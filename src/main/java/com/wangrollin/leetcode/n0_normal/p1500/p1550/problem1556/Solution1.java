package com.wangrollin.leetcode.n0_normal.p1500.p1550.problem1556;

/**
 * 千位分隔数
 *
 * 给你一个整数n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 *
 * 示例 1：
 * 输入：n = 987
 * 输出："987"
 *
 * 示例 2：
 * 输入：n = 1234
 * 输出："1.234"
 *
 * 示例 3：
 * 输入：n = 123456789
 * 输出："123.456.789"
 *
 * 示例 4：
 * 输入：n = 0
 * 输出："0"
 * 
 * 提示：
 * 0 <= n < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/thousand-separator
 *
 * Solution1
 * 简单的字符串操作
 */
public class Solution1 {

    public String thousandSeparator(int n) {

        String str = String.valueOf(n);
        StringBuilder result = new StringBuilder();

        for (int i = str.length() - 1, count = 0; i >= 0; i--, count = (count + 1) % 3) {

            if (i != str.length() - 1 && count == 0) {
                result.append('.');
            }
            result.append(str.charAt(i));
        }

        return result.reverse().toString();
    }
}
