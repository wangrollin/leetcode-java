package com.wangrollin.leetcode.n0_normal.p500.p500.problem504;

/**
 * 七进制数
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 * 输入: 100
 * 输出: "202"
 *
 * 示例 2:
 * 输入: -7
 * 输出: "-10"
 *
 * 注意: 输入范围是 [-1e7, 1e7] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/base-7
 *
 * Solution1
 * 取余
 */
public class Solution1 {

    public String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }

        String pre = "";
        if (num < 0) {
            pre = "-";
            num *= -1;
        }

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }

        return sb.append(pre).reverse().toString();
    }
}
