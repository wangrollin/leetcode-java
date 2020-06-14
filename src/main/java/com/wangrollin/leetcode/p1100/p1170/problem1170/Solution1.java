package com.wangrollin.leetcode.p1100.p1170.problem1170;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 比较字符串最小字母出现频次
 *
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；
 * 该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，
 * 其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 *
 * 示例 1：
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 *
 * 示例 2：
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 *  
 * 提示：
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] 都是小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character
 *
 * Solution1
 * 一个一个对比
 */
public class Solution1 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] answers = new int[11];

        Arrays.stream(words).forEach(word -> {
            answers[f(word)]++;
        });

        int sum = answers[10];
        for (int i = 9; i >= 1; i--) {
            int tmp = answers[i];
            answers[i] = sum;
            sum += tmp;
        }

        List<Integer> result = new ArrayList<>(queries.length);
        Arrays.stream(queries).forEach(str -> result.add(answers[f(str)]));

        return result.stream().mapToInt(i -> i).toArray();
    }

    private int f(String word) {

        AtomicReference<Character> curChar = new AtomicReference<>(word.charAt(0));
        int[] count = new int[1];

        word.chars().forEach(c -> {
            if (c == curChar.get()) {
                count[0]++;
            } else if (c < curChar.get()) {
                curChar.set((char) c);
                count[0] = 1;
            }
        });
        return count[0];
    }
}
