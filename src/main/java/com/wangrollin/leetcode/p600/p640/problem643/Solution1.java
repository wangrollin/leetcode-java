package com.wangrollin.leetcode.p600.p640.problem643;

/**
 * 子数组最大平均数 I
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * 注意:
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 *
 * Solution1
 * 减去最前面的，加上最后面的，一个变量存当前，一个变量存最大
 */
public class Solution1 {

    public double findMaxAverage(int[] nums, int k) {

        int curSum = 0;

        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }
        int maxSum = curSum;

        for (int i = 0; i < nums.length - k; i++) {
            curSum = curSum - nums[i] + nums[i + k];
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum / (double)k;
    }
}
