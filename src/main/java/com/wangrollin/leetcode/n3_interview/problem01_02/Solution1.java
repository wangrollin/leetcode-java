package com.wangrollin.leetcode.n3_interview.problem01_02;

import java.util.stream.Collectors;

/**
 * 判定是否互为字符重排
 *
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * 说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 *
 * Solution1
 * map equals
 */
public class Solution1 {

    public boolean CheckPermutation(String s1, String s2) {

        return s1
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .equals(s2
                        .chars()
                        .boxed()
                        .collect(Collectors.groupingBy(ch -> ch, Collectors.counting())));
    }
}
