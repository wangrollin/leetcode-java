package com.wangrollin.leetcode.n2_codingInterviews.p50.problem56_2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 数组中数字出现的次数 II
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 * 限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 *
 * Solution1
 * 根据位数模3，如果是出现三次，那就自动归零，只有出现一次的会留下痕迹
 */
public class Solution1 {

    public int singleNumber(int[] nums) {

        List<String> reverseBiStr = Arrays.stream(nums)
                .mapToObj(Integer::toBinaryString)
                .map(((Function<? super String, StringBuilder>) StringBuilder::new)
                        .andThen(StringBuilder::reverse)
                        .andThen(StringBuilder::toString))
                .collect(Collectors.toList());

        int maxLen = reverseBiStr.stream()
                .mapToInt(String::length)
                .max()
                .getAsInt();

        int[] reverseOneCount = new int[maxLen];
        Arrays.fill(reverseOneCount, 0);

        reverseBiStr.forEach(str -> {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    reverseOneCount[i] = (reverseOneCount[i] + 1) % 3;
                }
            }
        });

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            if (reverseOneCount[i] == 1) {
                result.append('1');
            } else {
                result.append('0');
            }
        }

        return Integer.valueOf(result.reverse().toString(), 2);
    }
}
