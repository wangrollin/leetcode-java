package com.wangrollin.leetcode.n0_normal.p300.p300.problem303;

/**
 * 区域和检索 - 数组不可变
 *
 * 给定一个整数数组 nums，求出数组从索引i到j(i≤j) 范围内元素的总和，包含i, j两点。
 *
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用sumRange方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 *
 * Solution1
 * 1.每次都去累加的话，很慢
 * 2.做缓存，在初始化的时候，把n*n中可能的ij组合的结果都计算出来
 * 3.做缓存，在初始化的时候，把所有从0到i的和都计算出来，然后返回sum[j] - sum[i-1]
 */
public class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {

        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[0] = nums[0];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {

        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}
