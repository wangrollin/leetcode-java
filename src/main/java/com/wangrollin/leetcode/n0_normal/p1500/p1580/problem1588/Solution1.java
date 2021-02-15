package com.wangrollin.leetcode.n0_normal.p1500.p1580.problem1588;

import java.util.Arrays;

/**
 * 所有奇数长度子数组的和
 *
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr中 所有奇数长度子数组的和 。
 *
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 *
 * 示例 3：
 * 输入：arr = [10,11,12]
 * 输出：66
 *
 * 提示：
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 *
 * Solution1
 * 一点点算，存储滑动窗口值
 */
public class Solution1 {

    public int sumOddLengthSubarrays(int[] arr) {

        int sum = Arrays.stream(arr).sum();

        for (int subLen = 3; subLen <= arr.length; subLen += 2) {

            int left = 0;
            int right = left + subLen - 1;
            int subSum = 0;
            int windowSum = 0;
            for (int i = left; i <= right; i++) {
                windowSum += arr[i];
            }

            subSum += windowSum;
            left++;
            right++;

            for (; right < arr.length; left++, right++) {
                windowSum += arr[right] - arr[left - 1];
                subSum += windowSum;
            }

            sum += subSum;
        }

        return sum;
    }
}
