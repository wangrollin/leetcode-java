package com.wangrollin.leetcode.n0_normal.p0.p10.problem14;

import java.util.Arrays;

/**
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母a-z。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *
 * Solution1
 * 从前到后，对比每一位是否相同
 */
public class Solution1 {

    public String longestCommonPrefix(String[] strs) {

        int len =
                Arrays
                        .stream(strs)
                        .mapToInt(String::length)
                        .min()
                        .orElse(0);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++) {

            int finalI = i;
            if (Arrays
                    .stream(strs)
                    .mapToInt(str -> str.charAt(finalI))
                    .distinct()
                    .count() == 1) {

                result.append(strs[0].charAt(i));

            } else {
                break;
            }
        }

        return result.toString();
    }
}
