package com.wangrollin.leetcode.n0_normal.p100.p160.problem169;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 *
 * Solution2
 * 二进制位置01统计
 */
public class Solution2 {

    public int majorityElement(int[] nums) {

        int maxLen =
                Arrays.stream(nums)
                        .mapToObj(Integer::toBinaryString)
                        .map(String::length)
                        .max(Comparator.comparingInt(Integer::intValue))
                        .get();

        int[] biArr = new int[maxLen];

        Arrays.stream(nums)
                .mapToObj(Integer::toBinaryString)
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .map(StringBuilder::toString)
                .forEach(str -> {
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == '1') {
                            biArr[i]++;
                        }
                    }
                });

        String result =
                new StringBuilder(Arrays.stream(biArr).mapToObj(i -> i > nums.length / 2 ? "1" : "0").collect(Collectors.joining()))
                        .reverse()
                        .toString()
                        .replaceFirst("^0*", "");

        if (result.length() == 0) {
            return 0;
        } else {
            return Arrays.stream(nums)
                    .filter(num -> Integer.toBinaryString(num).equals(result))
                    .findFirst()
                    .getAsInt();
        }
    }
}
