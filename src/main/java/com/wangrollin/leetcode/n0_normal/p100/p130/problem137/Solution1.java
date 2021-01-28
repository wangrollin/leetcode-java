package com.wangrollin.leetcode.n0_normal.p100.p130.problem137;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 只出现一次的数字 II
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 *
 * 示例2:
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 *
 * Solution1
 * 用二进制的视角来看，把每一位上的1相加模3，剩下的就是出现一次的数字
 */
public class Solution1 {

    public int singleNumber(int[] nums) {

        int maxLen =
                Arrays.stream(nums)
                        .mapToObj(Integer::toBinaryString)
                        .map(String::length)
                        .mapToInt(i -> i)
                        .max()
                        .getAsInt();

        int[] biArr = new int[maxLen];
        Arrays.fill(biArr, 0);

        Arrays.stream(nums)
                .mapToObj(Integer::toBinaryString)
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .map(StringBuilder::toString)
                .forEach(str -> {
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == '1') {
                            biArr[i] = (biArr[i] + 1) % 3;
                        }
                    }
                });

        final String withZeroNumStr =
                new StringBuilder(Arrays.stream(biArr).mapToObj(i -> "" + (char) ('0' + i)).collect(Collectors.joining()))
                        .reverse()
                        .toString()
                        .replaceAll("^[0]*", "");

        if (withZeroNumStr.length() == 0) {
            return 0;
        }

        return Arrays.stream(nums)
                .filter(num -> Integer.toBinaryString(num).equals(withZeroNumStr))
                .findFirst()
                .getAsInt();
    }
}
