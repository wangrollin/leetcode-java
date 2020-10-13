package com.wangrollin.leetcode.n2_codingInterviews.p50.problem50;

/**
 * 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 *
 * 限制：
 * 0 <= s 的长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 *
 * Solution1
 * stream大法
 */
public class Solution1 {

    public char firstUniqChar(String s) {

        return
                (char) s.chars()
                        .filter(ch -> s.indexOf(ch) == s.lastIndexOf(ch))
                        .findFirst()
                        .orElseGet(() -> (int) ' ');
    }
}
