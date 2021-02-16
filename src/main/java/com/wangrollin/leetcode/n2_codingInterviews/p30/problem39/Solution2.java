package com.wangrollin.leetcode.n2_codingInterviews.p30.problem39;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 限制：
 * 1 <= 数组长度 <= 50000
 *
 * 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
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
