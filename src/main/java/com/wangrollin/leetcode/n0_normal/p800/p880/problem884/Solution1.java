package com.wangrollin.leetcode.n0_normal.p800.p880.problem884;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两句话中的不常见单词
 *
 * 给定两个句子A和B。（句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * 返回所有不常用单词的列表。
 * 您可以按任何顺序返回列表。
 *
 * 示例 1：
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 *
 * 示例2：
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 *
 * 提示：
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和B都只包含空格和小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
 *
 * Solution1
 * 使用set的差集、并集
 */
public class Solution1 {

    public String[] uncommonFromSentences(String A, String B) {

        Set<String> oneTimeInA = new HashSet<>();
        Set<String> manyTimeInA = new HashSet<>();

        Arrays.stream(A.split(" ")).forEach(word -> {
            if (oneTimeInA.contains(word)) {
                oneTimeInA.remove(word);
                manyTimeInA.add(word);
            } else if (!manyTimeInA.contains(word)) {
                oneTimeInA.add(word);
            }
        });

        Set<String> oneTimeInB = new HashSet<>();
        Set<String> manyTimeInB = new HashSet<>();
        Arrays.stream(B.split(" ")).forEach(word -> {
            if (oneTimeInB.contains(word)) {
                oneTimeInB.remove(word);
                manyTimeInB.add(word);
            } else if (!manyTimeInB.contains(word)) {
                oneTimeInB.add(word);
            }
        });

        Set<String> resultSet = new HashSet<>(oneTimeInA);

        resultSet.removeAll(oneTimeInB);
        resultSet.removeAll(manyTimeInB);

        oneTimeInB.removeAll(oneTimeInA);
        oneTimeInB.removeAll(manyTimeInA);

        resultSet.addAll(oneTimeInB);

        String[] result = new String[resultSet.size()];
        resultSet.toArray(result);

        return result;
    }
}
