package com.wangrollin.leetcode.n3_interview.problem16_17;

/**
 * 连续数列
 *
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶：
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci
 *
 * Solution1
 * 记忆上一轮的值，迭代完成
 * f(i)代表以第i位结尾的最大总和
 * f(i) = max(f(i-1)+arr_i, arr_i)
 */
public class Solution1 {

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {

            pre = Math.max(pre + nums[i], nums[i]);
            result = Math.max(pre, result);
        }

        return result;
    }
}
