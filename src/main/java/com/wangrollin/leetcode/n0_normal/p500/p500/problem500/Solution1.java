package com.wangrollin.leetcode.n0_normal.p500.p500.problem500;

import java.util.ArrayList;
import java.util.List;

/**
 * 键盘行
 *
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 *
 * 示例：
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *
 * 注意：
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 *
 * Solution1
 * 遍历一遍
 */
public class Solution1 {

    private int whereIs(char c) {
        switch (c) {
            case 'q': case 'w': case 'e': case 'r': case 't':
            case 'y': case 'u': case 'i': case 'o': case 'p':
                return 0;
            case 'a': case 's': case 'd': case 'f': case 'g':
            case 'h': case 'j': case 'k': case 'l':
                return 1;
            default:
                return 2;
        }
    }

    public String[] findWords(String[] words) {

        List<String> result = new ArrayList<>();

        for (String word : words) {
            int whichLine = whereIs(word.toLowerCase().charAt(0));
            boolean isInOneLine = true;
            for (char c : word.toLowerCase().toCharArray()) {
                if (whichLine != whereIs(c)) {
                    isInOneLine = false;
                    break;
                }
            }
            if (isInOneLine) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
