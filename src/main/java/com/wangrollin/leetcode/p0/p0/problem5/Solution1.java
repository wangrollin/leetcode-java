package com.wangrollin.leetcode.p0.p0.problem5;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * Solution1
 * 中心开花，2n-1 个中心
 */
public class Solution1 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            sb.append('#').append(s.charAt(i));
        }
        sb.append('#');

        int startIndex = 0;
        int endIndex = 0;
        int longestLen = 0;
        for (int i = 0; i < sb.length(); ++i) {
            int fitst = i;
            int last = i;
            while (fitst >= 0 && last < sb.length() && sb.charAt(fitst) == sb.charAt(last)) {
                ++last;
                --fitst;
            }
            if (last - i > longestLen) {
                startIndex = fitst + 1;
                endIndex = last - 1;
                longestLen = last - 1 - i;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = startIndex + 1; i <= endIndex; i += 2) {
            result.append(sb.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
