package com.wangrollin.leetcode.n2_codingInterviews.p40.problem42;

/**
 * 连续子数组的最大和
 *
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 * 提示：
 * 1 <=arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 *
 * Solution2
 * 动态规划，迭代，状态转移方程 以下标n开始的最大和：f(n) = max{arr[n] + f(n+1), arr[n]}
 */
public class Solution2 {

    public int maxSubArray(int[] nums) {

        int after = 0;
        int maxAns = nums[nums.length - 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            after = Math.max(nums[i], nums[i] + after);
            maxAns = Math.max(maxAns, after);
        }

        return maxAns;
    }
}
