package com.wangrollin.leetcode.p800.p880.problem884;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两句话中的不常见单词
 *
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * 返回所有不常用单词的列表。
 * 您可以按任何顺序返回列表。
 *
 * 示例 1：
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 *
 * 示例 2：
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 *  
 * 提示：
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和 B 都只包含空格和小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
 *
 * Solution2
 * 站在整体的角度思考问题
 */
public class Solution2 {

    public String[] uncommonFromSentences(String A, String B) {

        Set<String> oneTime = new HashSet<>();
        Set<String> manyTime = new HashSet<>();

        Arrays.stream((A + " " + B).split(" ")).forEach(word -> {
            if (oneTime.contains(word)) {
                oneTime.remove(word);
                manyTime.add(word);
            } else if (!manyTime.contains(word)) {
                oneTime.add(word);
            }
        });

        String[] result = new String[oneTime.size()];
        oneTime.toArray(result);
        return result;
    }
}
