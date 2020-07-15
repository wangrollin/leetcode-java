package com.wangrollin.leetcode.p1400.p1410.problem1417;

/**
 * 重新格式化字符串
 *
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 * 示例 1：
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 *
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 *
 * 示例 3：
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 *
 * 示例 4：
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 *
 * 示例 5：
 * 输入：s = "ab123"
 * 输出："1a2b3"
 *
 * 提示：
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reformat-the-string
 *
 * Solution1
 * 先判断长度来快速退出，然后判断谁应该放在第一个，不断寻找下一个字母或数字
 */
public class Solution1 {

    public String reformat(String s) {

        int digitCount = 0;
        int letterCount = 0;

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                digitCount++;
            } else {
                letterCount++;
            }
        }

        if (Math.abs(digitCount - letterCount) > 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int digitIndex = -1;
        int letterIndex = -1;
        boolean letterOver = false;
        boolean digitOver = false;

        if (letterCount > digitCount) {
            letterIndex = findNextLetter(chars, letterIndex);
            sb.append(chars[letterIndex]);
        }

        while (true) {

            if (!digitOver) {
                digitIndex = findNextDigit(chars, digitIndex);
                digitOver = digitIndex == -1;
                if (!digitOver) {
                    sb.append(chars[digitIndex]);
                }
            }
            if (!letterOver) {
                letterIndex = findNextLetter(chars, letterIndex);
                letterOver = letterIndex == -1;
                if (!letterOver) {
                    sb.append(chars[letterIndex]);
                }
            }

            if (digitOver && letterOver) {
                break;
            }
        }

        return sb.toString();
    }

    private int findNextLetter(char[] chars, int startIndex) {

        for (int i = startIndex + 1; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                return i;
            }
        }
        return -1;
    }

    private int findNextDigit(char[] chars, int startIndex) {

        for (int i = startIndex + 1; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                return i;
            }
        }
        return -1;
    }
}
