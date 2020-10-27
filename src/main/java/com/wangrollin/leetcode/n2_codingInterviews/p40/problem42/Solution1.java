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
 * Solution1
 * 动态规划，迭代，状态转移方程 以下标n结尾的最大和：f(n) = max{arr[n] + f(n-1), arr[n]}
 */
public class Solution1 {

    public int maxSubArray(int[] nums) {

        int pre = 0;
        int maxAns = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }

        return maxAns;
    }
}