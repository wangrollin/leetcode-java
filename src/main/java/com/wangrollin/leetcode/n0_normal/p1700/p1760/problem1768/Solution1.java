package com.wangrollin.leetcode.n0_normal.p1700.p1760.problem1768;

/**
 * 交替合并字符串
 *
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 *
 * 示例 1：
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 *
 * 示例 2：
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 *
 * 示例 3：
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 *
 * 提示：
 * 1 <= word1.length, word2.length <= 100
 * word1 和 word2 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-strings-alternately
 *
 * Solution1
 * 交替加入，当某个结束，另一个尾巴接上
 */
public class Solution1 {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder result = new StringBuilder();
        int curIndex = 0;

        while (true) {

            result.append(word1.charAt(curIndex))
                    .append(word2.charAt(curIndex));
            curIndex++;

            if (curIndex == word1.length()) {
                result.append(word2.substring(curIndex));
                break;
            }
            if (curIndex == word2.length()) {
                result.append(word1.substring(curIndex));
                break;
            }
        }

        return result.toString();
    }
}
