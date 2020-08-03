package com.wangrollin.leetcode.n0_normal.p800.p850.problem859;

import java.util.HashSet;
import java.util.Set;

/**
 * 亲密字符串
 *
 * 给定两个由小写字母构成的字符串A和B，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回true；否则返回 false 。
 *
 * 示例 1：
 * 输入： A = "ab", B = "ba"
 * 输出： true
 *
 * 示例 2：
 * 输入： A = "ab", B = "ab"
 * 输出： false
 *
 * 示例 3:
 * 输入： A = "aa", B = "aa"
 * 输出： true
 *
 * 示例 4：
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 *
 * 示例 5：
 * 输入： A = "", B = "aa"
 * 输出： false
 * 
 * 提示：
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A和B仅由小写字母构成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 *
 * Solution1
 * 区分长度，如果字符串相等需要有重复字符串，如果字符串不相等需要只有两个不相等且可互换就相等
 */
public class Solution1 {

    public boolean buddyStrings(String A, String B) {

        if (A.length() != B.length()) {

            return false;

        } else if (A.equals(B)) {

            Set<Character> letters = new HashSet<>();
            A.chars().forEach(ch -> letters.add((char) ch));
            return letters.size() != A.length();

        } else {

            int firstIndex = -1;
            int secondIndex = -1;

            for (int i = 0; i < A.length(); i++) {

                if (A.charAt(i) != B.charAt(i)) {
                    if (firstIndex == -1) {
                        firstIndex = i;
                    } else if (secondIndex == -1) {
                        secondIndex = i;
                    } else {
                        return false;
                    }
                }
            }

            if (firstIndex == -1 || secondIndex == -1) {
                return false;
            }
            return A.charAt(firstIndex) == B.charAt(secondIndex)
                    && A.charAt(secondIndex) == B.charAt(firstIndex);
        }
    }
}
