package com.wangrollin.leetcode.n0_normal.p300.p380.problem389;

/**
 * 找不同
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串t由字符串s随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例:
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * 输出：
 * e
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 *
 * Solution1
 * int[26]，先加上去，再减下来，-1是要找的
 */
public class Solution1 {

    public char findTheDifference(String s, String t) {
        int[] charCount = new int[26];
        s.chars().forEach(x -> charCount[x - 'a']++);
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (--charCount[c - 'a'] == -1) {
                return c;
            }
        }
        return ' ';
    }
}
