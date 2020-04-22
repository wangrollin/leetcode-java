package com.wangrollin.leetcode.p800.p820.problem821;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符的最短距离
 *
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 示例 1:
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 * 说明:
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 *
 * Solution1
 * 没啥难度
 */
public class Solution1 {

    public int[] shortestToChar(String S, char C) {

        List<Integer> indexList = new ArrayList<>();
        int index = -1;
        while ((index = S.indexOf(C, index + 1)) != -1) {
            indexList.add(index);
        }

        int[] result = new int[S.length()];

        for (int i = 0; i < indexList.size(); i++) {
            if (i == 0 && indexList.size() == 1) {
                int curIndex = indexList.get(i);
                for (int j = 0; j <= curIndex; j++) {
                    result[j] = curIndex - j;
                }
                for (int j = curIndex + 1; j < result.length; j++) {
                    result[j] = j - curIndex;
                }
            } else if (i == 0) {
                int curIndex = indexList.get(i);
                for (int j = 0; j <= curIndex; j++) {
                    result[j] = curIndex - j;
                }
            } else if (i != indexList.size() - 1) {
                int leftIndex = indexList.get(i - 1);
                int rightIndex = indexList.get(i);
                for (int j = leftIndex + 1; j < rightIndex; j++) {
                    result[j] = Math.min(j - leftIndex, rightIndex - j);
                }
            } else {
                int leftIndex = indexList.get(i - 1);
                int rightIndex = indexList.get(i);
                for (int j = leftIndex + 1; j < rightIndex; j++) {
                    result[j] = Math.min(j - leftIndex, rightIndex - j);
                }
                for (int j = rightIndex; j < result.length; j++) {
                    result[j] = j - rightIndex;
                }
            }
        }

        return result;
    }
}
