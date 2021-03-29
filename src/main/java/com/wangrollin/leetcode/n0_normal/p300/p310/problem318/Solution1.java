package com.wangrollin.leetcode.n0_normal.p300.p310.problem318;

import java.util.Arrays;

/**
 * 最大单词长度乘积
 *
 * 给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，并且这两个单词不含有公共字母。
 * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 示例1:
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 *
 * 示例 2:
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 示例 3:
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 *
 * Solution1
 * 通过位运算快速判断是否符合条件
 */
public class Solution1 {

    public int maxProduct(String[] words) {

        int[] trans = Arrays.stream(words)
                .mapToInt(str -> {
                    String[] biNum = new String[32];
                    Arrays.fill(biNum, "0");
                    for (int i = 0; i < str.length(); i++) {
                        biNum[str.charAt(i) - 'a'] = "1";
                    }
                    return Integer.valueOf(new StringBuilder(String.join("", biNum)).reverse().toString(),
                            2);
                })
                .toArray();

        int result = 0;
        for (int i = 0; i < trans.length; i++) {
            for (int j = 0; j < trans.length; j++) {
                if ((trans[i] & trans[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }
}
