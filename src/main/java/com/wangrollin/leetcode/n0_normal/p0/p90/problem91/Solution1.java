package com.wangrollin.leetcode.n0_normal.p0.p90.problem91;

/**
 * 解码方法
 *
 * 一条包含字母A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 题目数据保证答案肯定是一个 32 位的整数。
 *
 * 示例 1：
 * 输入："12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2：
 * 输入："226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 示例 3：
 * 输入：s = "0"
 * 输出：0
 *
 * 示例 4：
 * 输入：s = "1"
 * 输出：1
 *
 * 示例 5：
 * 输入：s = "2"
 * 输出：1
 *
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含数字，并且可以包含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 *
 * Solution1
 * 存储两个结果，迭代
 * f(i)表示从开始到第i位，一共有几种解释方法
 * f(i) = (f(i-1)+1) + (f(i-2)+1) 若f(i-1)或者f(i-2)为0，则过滤掉
 */
public class Solution1 {

    public int numDecodings(String s) {

        if (s.startsWith("0")) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2) {

            int count = 0;
            if (isLetter(s.substring(1))) {
                count += 1;
            }
            if (isLetter(s)) {
                count += 1;
            }
            return count;
        }

        int first = 1;

        int second = 0;
        if (isLetter(s.substring(1, 2))) {
            second += 1;
        }
        if (isLetter(s.substring(0, 2))) {
            second += 1;
        }

        for (int i = 2; i < s.length(); i++) {

            int count = 0;
            if (isLetter(s.substring(i - 1, i + 1))) {
                count += first;
            }
            if (isLetter(s.substring(i, i + 1))) {
                count += second;
            }
            if (count == 0) {
                return 0;
            } else {
                first = second;
                second = count;
            }
        }

        return second;
    }

    private boolean isLetter(String str) {

        if (str.startsWith("0")) {
            return false;
        }

        int num = Integer.parseInt(str);
        return num >= 1 && num <= 26;
    }
}
