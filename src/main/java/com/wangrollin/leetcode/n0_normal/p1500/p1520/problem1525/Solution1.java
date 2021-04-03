package com.wangrollin.leetcode.n0_normal.p1500.p1520.problem1525;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 字符串的好分割数目
 *
 * 给你一个字符串s，一个分割被称为 「好分割」当它满足：将s分割成 2 个字符串p 和q，它们连接起来等于s且 p和 q中不同字符的数目相同。
 * 请你返回 s中好分割的数目。
 *
 * 示例 1：
 * 输入：s = "aacaba"
 * 输出：2
 * 解释：总共有 5 种分割字符串 "aacaba" 的方法，其中 2 种是好分割。
 * ("a", "acaba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aa", "caba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aac", "aba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aaca", "ba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aacab", "a") 左边字符串和右边字符串分别包含 3 个和 1 个不同的字符。
 *
 * 示例 2：
 * 输入：s = "abcd"
 * 输出：1
 * 解释：好分割为将字符串分割成 ("ab", "cd") 。
 *
 * 示例 3：
 * 输入：s = "aaaaa"
 * 输出：4
 * 解释：所有分割都是好分割。
 *
 * 示例 4：
 * 输入：s = "acbadbaada"
 * 输出：2
 *
 * 提示：
 * s只包含小写英文字母。
 * 1 <= s.length <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-ways-to-split-a-string
 *
 * Solution1
 * 记录每个字母的开始和结束位置，从而计算两侧的数量
 */
public class Solution1 {

    public int numSplits(String s) {

        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);

        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);

        for (int i = 0; i < s.length(); i++) {
            if (firstIndex[s.charAt(i) - 'a'] == -1) {
                firstIndex[s.charAt(i) - 'a'] = i;
            }
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Set<Integer> lastIndexSet = Arrays.stream(lastIndex)
                .filter(i -> i != -1)
                .boxed()
                .collect(Collectors.toSet());

        Set<Integer> firstIndexSet = Arrays.stream(firstIndex)
                .filter(i -> i != -1)
                .boxed()
                .collect(Collectors.toSet());

        int leftDiffLetter = 0;
        int rightDiffLetter = lastIndexSet.size();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (lastIndexSet.contains(i)) {
                rightDiffLetter--;
            }
            if (firstIndexSet.contains(i)) {
                leftDiffLetter++;
            }
            if (leftDiffLetter == rightDiffLetter) {
                result++;
            }
            if (leftDiffLetter > rightDiffLetter) {
                break;
            }
        }

        return result;
    }
}
