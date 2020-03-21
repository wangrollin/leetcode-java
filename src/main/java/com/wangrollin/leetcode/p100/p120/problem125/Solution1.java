package com.wangrollin.leetcode.p100.p120.problem125;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 *
 * Solution1
 * 遍历一遍
 */
public class Solution1 {

    public static boolean isPalindrome(String s) {

        if (s == null || s.equals("")) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!Character.isDigit(s.charAt(left)) && !Character.isLetter(s.charAt(left))) {
                ++left;
                continue;
            }
            if (!Character.isDigit(s.charAt(right)) && !Character.isLetter(s.charAt(right))) {
                --right;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {

                return false;
            } else {
                ++left;
                --right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
