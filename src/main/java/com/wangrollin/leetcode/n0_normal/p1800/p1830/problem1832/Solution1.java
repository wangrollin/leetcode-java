package com.wangrollin.leetcode.n0_normal.p1800.p1830.problem1832;

import java.util.Arrays;

/**
 * 判断句子是否为全字母句
 *
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 *
 * 示例 2：
 * 输入：sentence = "leetcode"
 * 输出：false
 *
 * 提示：
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram
 *
 * Solution1
 * 数组记录字母
 */
public class Solution1 {

    public boolean checkIfPangram(String sentence) {

        int[] letters = new int[26];
        Arrays.fill(letters, 0);

        for (int i = 0; i < sentence.length(); i++) {

            letters[sentence.charAt(i) - 'a'] = 1;
        }

        return Arrays.stream(letters).allMatch(num -> num == 1);
    }
}
