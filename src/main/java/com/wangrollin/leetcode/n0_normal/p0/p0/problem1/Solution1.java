package com.wangrollin.leetcode.n0_normal.p0.p0.problem1;

/**
 * 两数之和
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 *
 * Solution1
 * 最简单的遍历方法
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        // 假设给的数据都是OK的，不做异常处理
        int len = nums.length;
        for(int i = 1; i<len ; ++i) {
            for (int j = 0; j < i; ++j) {
                if(nums[j] + nums[i] == target) {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }
}
