package com.wangrollin.leetcode.p300.p340.problem345;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 反转字符串中的元音字母
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 *
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 *
 * Solution1
 * 双指针相向而行
 */
public class Solution1 {

    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        Set<Character> univocalicSet = Stream.of('a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U')
                .collect(Collectors.toCollection(HashSet::new));
        for (int left = 0, right = s.length() - 1; left < right; ) {
            if (!univocalicSet.contains(chars[left])) {
                left++;
                continue;
            }
            if (!univocalicSet.contains(chars[right])) {
                right--;
                continue;
            }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
