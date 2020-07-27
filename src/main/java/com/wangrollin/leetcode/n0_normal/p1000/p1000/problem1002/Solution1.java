package com.wangrollin.leetcode.n0_normal.p1000.p1000.problem1002;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 查找常用字符
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 *
 * Solution1
 * 第一个string的letter逐步经受其他的string的考验
 */
public class Solution1 {

    public List<String> commonChars(String[] A) {

        if (A.length == 1) {
            return A[0].chars()
                    .mapToObj(i -> String.valueOf((char) i))
                    .collect(Collectors.toList());
        }

        Map<String, Integer> letterMap = new ConcurrentHashMap<>();
        A[0].chars()
                .mapToObj(i -> String.valueOf((char) i))
                .forEach(str -> letterMap.put(str, letterMap.getOrDefault(str, 0) + 1));

        Arrays.stream(Arrays.copyOfRange(A, 1, A.length))
                .forEach(str -> {
                    Map<String, Integer> curLetterMap = new HashMap<>();
                    str.chars()
                            .mapToObj(i -> String.valueOf((char) i))
                            .forEach(letter -> {
                                if (letterMap.containsKey(letter)) {
                                    curLetterMap.put(letter, curLetterMap.getOrDefault(letter, 0) + 1);
                                }
                            });
                    letterMap.forEach((key, value) -> {
                        if (!curLetterMap.containsKey(key)) {
                            letterMap.remove(key);
                        } else {
                            letterMap.put(key,
                                    Math.min(value, curLetterMap.get(key)));
                        }
                    });
                });


        return letterMap.entrySet().stream()
                .flatMap(entry -> {
                    String[] list = new String[entry.getValue()];
                    Arrays.fill(list, entry.getKey());
                    return Arrays.stream(list);
                }).collect(Collectors.toList());
    }
}
