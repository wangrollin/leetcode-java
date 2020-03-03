package com.wangrollin.leetcode.problem290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 单词规律
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 *
 * Solution1
 * 一个map，一个set
 */
public class Solution1 {

    public boolean wordPattern(String pattern, String str) {
        int patternLen = pattern == null ? 0 : pattern.length();
        int wordListLen = str == null ? 0 : str.split(" ").length;
        if (patternLen != wordListLen) {
            return false;
        }
        if (patternLen == 0 && wordListLen == 0) {
            return true;
        }
        String[] wordList = str.split(" ");
        Map<Character, String> pMap = new HashMap<>();
        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            if (pMap.containsKey(ch)) {
                if (!pMap.get(ch).equals(wordList[i])) {
                    return false;
                }
            } else {
                pMap.put(ch, wordList[i]);
                if (strSet.contains(wordList[i])) {
                    return false;
                } else {
                    strSet.add(wordList[i]);
                }
            }
        }
        return true;
    }
}
