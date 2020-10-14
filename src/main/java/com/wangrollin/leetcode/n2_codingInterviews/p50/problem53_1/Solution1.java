package com.wangrollin.leetcode.n2_codingInterviews.p50.problem53_1;

import java.util.Arrays;

/**
 * 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 
 * 限制：
 * 0 <= 数组长度 <= 50000
 *
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 *
 * Solution1
 * 先用传统二分法找到位置，然后左右寻找边界
 */
public class Solution1 {

    public int search(int[] nums, int target) {

        int index = Arrays.binarySearch(nums, target);

        if (index < 0) {
            return 0;
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

        return right - left + 1;
    }
}
