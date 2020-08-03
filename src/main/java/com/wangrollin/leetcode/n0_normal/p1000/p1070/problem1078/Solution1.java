package com.wangrollin.leetcode.n0_normal.p1000.p1070.problem1078;

import java.util.ArrayList;
import java.util.List;

/**
 * Bigram 分词
 *
 * 给出第一个词first 和第二个词second，考虑在某些文本text中可能以 "first second third" 形式出现的情况，
 * 其中second紧随first出现，third紧随second出现。
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 * 示例 1：
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 *
 * 示例 2：
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 * 
 * 提示：
 * 1 <= text.length <= 1000
 * text由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
 * 1 <= first.length, second.length <= 10
 * first 和second由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/occurrences-after-bigram
 *
 * Solution1
 * 直接indexOf方法
 */
public class Solution1 {

    public String[] findOcurrences(String text, String first, String second) {

        List<String> result = new ArrayList<>();

        String prefix = first + " " + second + " ";

        int index = -1;
        while ((index = text.indexOf(prefix, index + 1)) != -1) {

            if (index != 0 && text.charAt(index - 1) != ' ') {
                continue;
            }
            int nextSpace = text.indexOf(' ', index + prefix.length());
            result.add(text.substring(index + prefix.length(), nextSpace == -1 ? text.length() : nextSpace));
        }

        return result.toArray(new String[0]);
    }
}
