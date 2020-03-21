package com.wangrollin.leetcode.p200.p280.problem283;

/**
 * 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 *
 * Solution1
 * 把非零挪好，然后统一刷零
 */
public class Solution1 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int slowPoint = 0;
        int fastPoint = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return;
            }
            if (nums[i] == 0) {
                slowPoint = i;
                fastPoint = i + 1;
                break;
            }
        }

        while (fastPoint < nums.length) {
            if (nums[fastPoint] != 0) {
                nums[slowPoint++] = nums[fastPoint++];
            } else {
                ++fastPoint;
            }
        }

        while(slowPoint<nums.length) {
            nums[slowPoint++] = 0;
        }
    }
}
