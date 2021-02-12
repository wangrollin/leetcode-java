package com.wangrollin.leetcode.n0_normal.p700.p780.problem784;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 * 输入：S = "12345"
 * 输出：["12345"]
 *
 * 提示：
 * S的长度不超过12。
 * S仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 *
 * Solution1
 * 递归，也可以迭代
 */
public class Solution1 {

    public List<String> letterCasePermutation(String S) {

        List<String> result = new ArrayList<>();

        if (S == null || S.length() == 0) {
            return result;
        }

        cal(result, S, "", 0);
        return result;
    }

    private void cal(List<String> result, String originStr, String curStr, int curIndex) {

        if (curIndex == originStr.length()) {
            result.add(curStr);
            return;
        }

        int charIndex = findFirstLetter(originStr, curIndex);

        if (charIndex == -1) {
            curStr += originStr.substring(curIndex);
            result.add(curStr);
            return;
        }

        curStr += originStr.substring(curIndex, charIndex);
        String newUpperCaseStr = curStr + Character.toUpperCase(originStr.charAt(charIndex));
        String newLowerCaseStr = curStr + Character.toLowerCase(originStr.charAt(charIndex));
        cal(result, originStr, newUpperCaseStr, charIndex + 1);
        cal(result, originStr, newLowerCaseStr, charIndex + 1);
    }

    private int findFirstLetter(String str, int fromIndex) {

        for (int i = fromIndex; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                return i;
            }
        }

        return -1;
    }
}
