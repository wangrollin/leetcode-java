package com.wangrollin.leetcode.n0_normal.p0.p50.problem53;

/**
 * 最大子序和
 *
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 *
 * Solution3
 * 动态规划，递归 + 非记忆，状态转移方程 以下标n开始的最大和：f(n) = max{arr[n] + f(n+1), arr[n]}
 */
public class Solution3 {

    public int maxSubArray(int[] nums) {

        int maxAns = nums[nums.length - 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            maxAns = Math.max(maxAns, max(nums, i));
        }

        return maxAns;
    }

    private int max(int[] nums, int index) {

        if (index > nums.length - 1) {
            return 0;
        }
        return Math.max(nums[index], nums[index] + max(nums, index + 1));
    }
}