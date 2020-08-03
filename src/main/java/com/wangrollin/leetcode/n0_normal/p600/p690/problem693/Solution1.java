package com.wangrollin.leetcode.n0_normal.p600.p690.problem693;

/**
 * 交替位二进制数
 *
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 示例 1:
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 *
 * 示例 2:
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 *
 * 示例3:
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *
 * 示例 4:
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 *
 * Solution1
 *
 */
public class Solution1 {

    public boolean hasAlternatingBits(int n) {

        String str = Integer.toString(n, 2);

        for (int i = 0, j = 1; j < str.length(); i++, j++) {
            if (str.charAt(i) == str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
