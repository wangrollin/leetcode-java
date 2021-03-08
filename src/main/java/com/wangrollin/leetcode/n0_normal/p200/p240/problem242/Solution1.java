package com.wangrollin.leetcode.n0_normal.p200.p240.problem242;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 *
 * Solution1
 * 判断26个字母的个数
 * 也可以按照字典序排序比较
 */
public class Solution1 {

    public boolean isAnagram(String s, String t) {

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        Arrays.fill(arr1, 0);
        Arrays.fill(arr2, 0);

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 24; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
