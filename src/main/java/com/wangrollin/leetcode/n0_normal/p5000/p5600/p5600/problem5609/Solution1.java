package com.wangrollin.leetcode.n0_normal.p5000.p5600.p5600.problem5609;

import java.util.Arrays;

/**
 * 统计一致字符串的数目
 *
 * 给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串。
 * 请你返回words数组中一致字符串的数目。
 *
 * 示例 1：
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 *
 * 示例 2：
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 *
 * 示例 3：
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 * 
 * 提示：
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed中的字符 互不相同。
 * words[i] 和allowed只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings
 *
 * Solution1
 * stream大法好
 */
public class Solution1 {

    public int countConsistentStrings(String allowed, String[] words) {

        int[] check = new int[26];
        Arrays.fill(check, 0);
        for (char ch : allowed.toCharArray()) {
            check[ch - 'a'] = 1;
        }

        return (int) Arrays.stream(words)
                .filter(word -> word.chars().allMatch(ch -> check[ch - 'a'] == 1))
                .count();
    }
}
