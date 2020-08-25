package com.wangrollin.leetcode.n0_normal.p0.p30.problem34;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是O(log n) 级别。
 * 如果数组中不存在目标值，返回[-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * Solution1
 * 先用传统二分法找到位置，然后左右寻找边界
 */
public class Solution1 {

    public int[] searchRange(int[] nums, int target) {

        int index = Arrays.binarySearch(nums, target);

        if (index < 0) {
            return new int[]{-1, -1};
        }

        int right = index;
        if (nums[nums.length - 1] == target) {
            right = nums.length - 1;
        } else {
            for (int i = index; i < nums.length; i++) {
                if (nums[i] != target) {
                    right = i - 1;
                    break;
                }
            }
        }

        int left = index;
        if (nums[0] == target) {
            left = 0;
        } else {
            for (int i = index; i >= 0; i--) {
                if (nums[i] != target) {
                    left = i + 1;
                    break;
                }
            }
        }

        return new int[]{left, right};
    }
}
