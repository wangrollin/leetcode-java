package com.wangrollin.leetcode.n0_normal.p0.p60.problem67;

/**
 * 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字1和0。
 *
 * 示例1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 
 * Solution1
 * string 数字加法器
 */
public class Solution1 {

    public String addBinary(String a, String b) {

        int len = Math.max(a.length(), b.length());
        int carry = 0;
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++) {

            int sum = carry;
            if (i < a.length()) {
                sum += a.charAt(i) - '0';
            }
            if (i < b.length()) {
                sum += b.charAt(i) - '0';
            }
            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
