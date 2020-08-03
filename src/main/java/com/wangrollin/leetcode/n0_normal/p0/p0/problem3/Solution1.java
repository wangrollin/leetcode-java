package com.wangrollin.leetcode.n0_normal.p0.p0.problem3;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"abc"，所以其长度为3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是"b"，所以其长度为1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为3。
 *     请注意，你的答案必须是子串的长度，"pwke"是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * Solution1
 * 最暴力的就是穷举出所有子串；以某一个index开始的最长子串，第一个遇到重复字符之后，从前面的重复字符后面继续搞起
 */
public class Solution1 {

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        int curLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        int curIndex = 0;
        while (true) {
            if (curIndex >= len) {
                return Math.max(maxLen, curLen);
            }
            Character c = s.charAt(curIndex);
            if (!map.containsKey(c)) {
                map.put(c, curIndex);
                ++curIndex;
                ++curLen;
            } else {
                maxLen = Math.max(maxLen, curLen);
                int firstRepeatedIndex = map.get(c);
                curLen = curIndex - firstRepeatedIndex;
                for (int i = startIndex; i < firstRepeatedIndex + 1; ++i) {
                    map.remove(s.charAt(i));
                }
                map.put(c, curIndex);
                ++curIndex;
                startIndex = firstRepeatedIndex + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
