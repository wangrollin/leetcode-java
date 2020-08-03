package com.wangrollin.leetcode.n0_normal.p700.p700.problem704;

/**
 * 二分查找
 *
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
 * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 
 * 提示：
 * 你可以假设 nums中的所有元素是不重复的。
 * n将在[1, 10000]之间。
 * nums的每个元素都将在[-9999, 9999]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 *
 * Solution1
 * 要用cur = (right - left) / 2 + left，防止溢出
 */
public class Solution1 {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            if (left == right) {
                if (nums[left] == target) {
                    return left;
                } else {
                    return -1;
                }
            }
            int cur = (right - left) / 2 + left;
            if (nums[cur] == target) {
                return cur;
            } else if (nums[cur] > target) {
                right = cur - 1;
            } else {
                left = cur + 1;
            }
        }

        return -1;
    }
}
