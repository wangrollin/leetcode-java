package com.wangrollin.leetcode.n0_normal.p0.p40.problem49;

import java.util.*;

/**
 * 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 *
 * Solution2
 * 使用letter count map作为key，存储list，最后汇总
 */
public class Solution2 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Map<Character, Integer>, List<String>> resultMap = new HashMap<>();

        Arrays
                .stream(strs)
                .forEach(str -> {

                    Map<Character, Integer> letterMap = new HashMap<>();
                    str.chars()
                            .forEach(ch -> letterMap.put((char) ch, letterMap.getOrDefault((char) ch, 0) + 1));

                    resultMap.compute(letterMap, (k, v) -> {
                        if (v == null) {
                            List<String> list = new ArrayList<>();
                            list.add(str);
                            return list;
                        } else {
                            v.add(str);
                            return v;
                        }
                    });
                });

        List<List<String>> result = new ArrayList<>();

        resultMap
                .values()
                .forEach(list -> result.add(list));

        return result;
    }
}
