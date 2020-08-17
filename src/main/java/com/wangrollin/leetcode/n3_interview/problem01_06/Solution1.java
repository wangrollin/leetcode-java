package com.wangrollin.leetcode.n3_interview.problem01_06;

/**
 * 字符串压缩
 *
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 示例2:
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * 提示：
 * 字符串长度在[0, 50000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 *
 * Solution1
 * 遍历一遍，进行压缩
 */
public class Solution1 {

    public String compressString(String S) {

        if (S.length() <= 2) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        char curChar = S.charAt(0);
        int charCount = 1;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != curChar) {
                sb.append(curChar).append(charCount);
                curChar = S.charAt(i);
                charCount = 1;
            } else {
                charCount++;
            }
        }
        sb.append(curChar).append(charCount);

        return sb.length() < S.length() ? sb.toString() : S;
    }
}
