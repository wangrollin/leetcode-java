package com.wangrollin.leetcode.n3_interview.problem08_07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 无重复字符串的排列组合
 *
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 *
 * 示例2:
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 *
 * 提示:
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 *
 * Solution1
 * 递归
 */
public class Solution1 {

    public String[] permutation(String S) {

        List<String> result = new ArrayList<>();

        buildStr(result,
                "",
                S.chars()
                        .boxed()
                        .map(ch -> (char) (int) ch)
                        .collect(Collectors.toSet()));

        return result.toArray(new String[0]);
    }

    private void buildStr(List<String> result, String prefix, Set<Character> letterSet) {

        if (letterSet.isEmpty()) {

            result.add(prefix);
        } else {

            letterSet.forEach(character -> {

                String newPrefix = prefix + character;
                Set<Character> newLetterSet = new HashSet<>(letterSet);
                newLetterSet.remove(character);
                buildStr(result, newPrefix, newLetterSet);
            });
        }
    }
}
