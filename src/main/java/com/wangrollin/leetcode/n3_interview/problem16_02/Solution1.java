package com.wangrollin.leetcode.n3_interview.problem16_02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 单词频率
 *
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 * 你的实现应该支持如下操作：
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 *
 * 示例：
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 *
 * 提示：
 * book[i]中只包含小写字母
 * 1 <= book.length <= 100000
 * 1 <= book[i].length <= 10
 * get函数的调用次数不会超过100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/words-frequency-lcci
 *
 * Solution1
 * hashmap直接存
 */
public class Solution1 {

    /**
     * Your WordsFrequency object will be instantiated and called as such:
     * WordsFrequency obj = new WordsFrequency(book);
     * int param_1 = obj.get(word);
     */
    private static class WordsFrequency {

        private Map<String, Integer> strFreqMap = new HashMap<>();

        public WordsFrequency(String[] book) {

            Arrays.stream(book).forEach(str -> strFreqMap.compute(str, (key, value) -> value == null ? 1 : value + 1));
        }

        public int get(String word) {

            return strFreqMap.getOrDefault(word, 0);
        }
    }
}
