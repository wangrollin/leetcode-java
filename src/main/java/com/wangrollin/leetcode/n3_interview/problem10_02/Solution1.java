package com.wangrollin.leetcode.n3_interview.problem10_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 变位词组
 *
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
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
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 *
 * Solution1
 * 把相同的放在一起，map的key可以是map，也可以是字典序的排序
 */
public class Solution1 {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<Map<Character, Integer>, List<String>> result = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> map = calMap(str);
            result.compute(map, (k, v) -> {
                if (v == null) {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    return list;
                } else {
                    v.add(str);
                    return v;
                }
            });
        }

        return new ArrayList<>(result.values());
    }

    private Map<Character, Integer> calMap(String word) {

        if (word == null || word.length() == 0) {
            return new HashMap<>();
        }

        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            result.put(word.charAt(i), result.getOrDefault(word.charAt(i), 0) + 1);
        }
        return result;
    }
}
