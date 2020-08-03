package com.wangrollin.leetcode.n0_normal.p1100.p1180.problem1189;

import java.util.HashMap;
import java.util.Map;

/**
 * “气球” 的最大数量
 *
 * 给你一个字符串text，你需要使用 text 中的字母来拼凑尽可能多的单词"balloon"（气球）。
 * 字符串text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词"balloon"。
 *
 * 示例 1：
 * 输入：text = "nlaebolko"
 * 输出：1
 *
 * 示例 2：
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 *
 * 示例 3：
 * 输入：text = "leetcode"
 * 输出：0
 *
 * 提示：
 * 1 <= text.length <= 10^4
 * text全部由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
 *
 * Solution1
 * 计算各个字符的出现次数，然后map为可装配的数量，然后找到最小值返回
 */
public class Solution1 {

    public static int maxNumberOfBalloons(String text) {

        Map<Character, Integer> count = new HashMap<>();

        "balloon".chars().forEach(i -> count.put((char) i, 0));

        text
                .chars()
                .forEach(i -> {
                    if (count.containsKey((char) i)) {
                        count.merge((char) i, 1, Integer::sum);
                    }
                });

        return count
                .entrySet()
                .stream()
                .mapToInt(entry -> {
                    if (entry.getKey() == 'l' || entry.getKey() == 'o') {
                        return entry.getValue() / 2;
                    } else {
                        return entry.getValue();
                    }
                })
                .min()
                .orElse(0);
    }
}
