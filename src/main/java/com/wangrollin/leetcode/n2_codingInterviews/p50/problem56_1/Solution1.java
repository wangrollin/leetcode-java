package com.wangrollin.leetcode.n2_codingInterviews.p50.problem56_1;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * 
 * 限制：
 * 2 <= nums.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 
 * Solution1
 * 首先全部异或，得到的二进制序列中位为'1'的，说明这一位是两个结果中不同的一位
 * 以这一位作为区分，所有数字分为两组，分别异或，即可得出答案
 * 小心负数，Integer.valueOf()失效
 */
public class Solution1 {

    public int[] singleNumbers(int[] nums) {

        int diffNum = Arrays.stream(nums)
                .reduce((a, b) -> a ^ b)
                .getAsInt();

        final int finalDiffIndex =
                new StringBuilder(Integer.toBinaryString(diffNum))
                        .reverse()
                        .toString()
                        .indexOf('1');

        int[] results = new int[2];

        results[0] = Arrays.stream(nums)
                .filter(num -> {
                    String numStr = new StringBuilder(Integer.toBinaryString(num)).reverse().toString();
                    return numStr.length() > finalDiffIndex && numStr.charAt(finalDiffIndex) == '1';
                })
                .reduce((a, b) -> a ^ b)
                .getAsInt();

        results[1] = Arrays.stream(nums)
                .filter(num -> {
                    String numStr = new StringBuilder(Integer.toBinaryString(num)).reverse().toString();
                    return numStr.length() <= finalDiffIndex || numStr.charAt(finalDiffIndex) != '1';
                })
                .reduce((a, b) -> a ^ b)
                .getAsInt();

        return results;
    }

    private Stream<String> genStream(int[] nums) {

        return
                Arrays.stream(nums)
                        .mapToObj(Integer::toBinaryString)
                        .map(((Function<? super String, StringBuilder>) StringBuilder::new)
                                .andThen(StringBuilder::reverse)
                                .andThen(StringBuilder::toString));
    }
}
