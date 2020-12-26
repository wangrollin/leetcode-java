package com.wangrollin.leetcode.n3_interview.problem08_09;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 括号
 *
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bracket-lcci
 *
 * Solution1
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
