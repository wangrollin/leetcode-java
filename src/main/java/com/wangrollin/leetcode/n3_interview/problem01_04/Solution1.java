package com.wangrollin.leetcode.n3_interview.problem01_04;

import java.util.HashSet;
import java.util.Set;

/**
 * 回文排列
 *
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 *
 * 示例1：
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 *
 * Solution1
 * 两两相消，消消乐，如果长度奇数，则set中有一个，为偶数，set中则没有
 */
public class Solution1 {

    public boolean canPermutePalindrome(String s) {

        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }

        return s.length() % 2 == 0 && set.isEmpty()
                || s.length() % 2 == 1 && set.size() == 1;
    }
}
