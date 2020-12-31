package com.wangrollin.leetcode.n0_normal.p700.p720.problem728;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数
 *
 * 自除数是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 * 输入：上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 * 注意：
 * 每个输入参数的边界满足1 <= left <= right <= 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 *
 * Solution1
 * 一一判断
 */
public class Solution1 {

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> results = new ArrayList<>();

        for (int i = left; i <= right; i++) {

            String numStr = String.valueOf(i);
            if (numStr.indexOf('0') == -1) {
                int finalI = i;

                if (numStr.chars()
                        .distinct()
                        .allMatch(ch -> finalI % (ch - '0') == 0)) {
                    results.add(i);
                }
            }
        }

        return results;
    }
}
