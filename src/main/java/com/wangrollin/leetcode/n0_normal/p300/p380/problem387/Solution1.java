package com.wangrollin.leetcode.n0_normal.p300.p380.problem387;

import java.util.HashMap;
import java.util.Map;

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
 * Solution1
 * 遍历一遍，计数，再去一个一个看谁只有一个
 */
public class Solution1 {

    public int firstUniqChar(String s) {
        Map<Integer, Integer> counter = new HashMap<>();
        s.chars().forEach(x -> {
            if (counter.containsKey(x)) {
                counter.put(x, counter.get(x) + 1);
            } else {
                counter.put(x, 1);
            }
        });
        for (int i = 0; i < s.length(); i++) {
            if (counter.get((int) s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
