package com.wangrollin.leetcode.n0_normal.p200.p260.problem260;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 只出现一次的数字 III
 *
 * 给定一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 *
 * 注意：
 * 结果输出的顺序并不重要，对于上面的例子，[5, 3]也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 *
 * Solution1
 * 首先全部异或，得到的二进制序列中位为'1'的，说明这一位是两个结果中不同的一位
 * 以这一位作为区分，所有数字分为两组，分别异或，即可得出答案
 * 小心负数，Integer.valueOf()失效
 */
public class Solution1 {

    public int[] singleNumber(int[] nums) {

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
