package com.wangrollin.leetcode.n0_normal.p0.p20.problem22;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 括号生成
 *
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 * Solution1
 * 和 problem08_09 相同
 * 要存储过程结果，n=5: (n=0)n=4, (n=1)n=3, (n=2)n=2, (n=3)n=1, (n=4)n=0
 */
public class Solution1 {

    private Map<Integer, List<String>> pMap = new HashMap<>();

    {
        pMap.put(1, Collections.singletonList("()"));
    }

    public List<String> generateParenthesis(int n) {

        if (pMap.containsKey(n)) {
            return pMap.get(n);
        }

        List<String> result =
                generateParenthesis(n - 1)
                        .stream()
                        .flatMap(str -> Stream.of("()" + str, "(" + str + ")"))
                        .distinct()
                        .collect(Collectors.toList());

        for (int i = 1; i < n - 1; i++) {

            int finalI = i;
            result.addAll(pMap.get(i).stream()
                    .map(str -> "(" + str + ")")
                    .flatMap(str -> pMap.get(n - 1 - finalI).stream().map(str2 -> str + str2))
                    .distinct()
                    .collect(Collectors.toList()));
        }

        result = result.stream()
                .distinct()
                .collect(Collectors.toList());

        pMap.put(n, result);
        return result;
    }
}
