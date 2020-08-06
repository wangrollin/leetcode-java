package com.wangrollin.leetcode.n2_codingInterviews.p0.problem05;

/**
 * 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 *
 * Solution1
 * replaceAll
 */
public class Solution1 {

    public String replaceSpace(String s) {

        return s.replaceAll(" ", "%20");
    }
}
