package com.wangrollin.leetcode.n0_normal.p300.p380.problem387;

import java.util.*;

/**
 * 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 *
 * Solution2
 * 记录字符的位置，然后去找只有一个的，然后找到最小的那个
 */
public class Solution2 {

    public int firstUniqChar(String s) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (indexMap.containsKey(s.charAt(i))) {
                indexMap.get(s.charAt(i)).add(i);
            } else {
                indexMap.put(s.charAt(i), new ArrayList<>(Arrays.asList(i)));
            }
        }
        var result = indexMap.entrySet().stream().filter(entry ->
                entry.getValue().size() == 1
        ).min(Comparator.comparingInt(x -> x.getValue().get(0)));

        if (result.isPresent()) {
            return result.get().getValue().get(0);
        } else {
            return -1;
        }
    }
}
