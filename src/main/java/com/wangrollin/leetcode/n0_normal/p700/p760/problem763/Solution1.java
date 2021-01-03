package com.wangrollin.leetcode.n0_normal.p700.p760.problem763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 划分字母区间
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 示例：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 *
 * Solution1
 * 倒序遍历，记录字母的lastIndex，然后正序遍历，不断推进右边界
 */
public class Solution1 {

    public List<Integer> partitionLabels(String S) {

        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);
        for (int i = S.length() - 1; i >= 0; i--) {
            if (lastIndex[S.charAt(i) - 'a'] == -1) {
                lastIndex[S.charAt(i) - 'a'] = i;
            }
        }

        List<Integer> result = new ArrayList<>();

        int left = 0;
        int curIndex = 0;
        int right = 0;

        while (left < S.length()) {

            right = Math.max(right, lastIndex[S.charAt(curIndex) - 'a']);
            if (++curIndex >= right) {
                result.add(right - left + 1);
                right++;
                left = right;
                curIndex = right;
            }
        }

        return result;
    }
}
