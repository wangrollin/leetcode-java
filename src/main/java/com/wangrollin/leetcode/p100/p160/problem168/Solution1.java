package com.wangrollin.leetcode.p100.p160.problem168;

/**
 * Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 *
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 *
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 *
 * Solution1
 * 本质上是一个进制转换问题，26进制，但是要注意没有A0被AZ表示了
 */
public class Solution1 {

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            result.append((char) ((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
    }
}
