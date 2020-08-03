package com.wangrollin.leetcode.n0_normal.p1200.p1290.problem1295;

/**
 * 统计位数为偶数的数字
 *
 * 给你一个整数数组nums，请你返回其中位数为偶数的数字的个数。
 *
 * 示例 1：
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数）
 * 345 是 3 位数字（位数为奇数）
 * 2 是 1 位数字（位数为奇数）
 * 6 是 1 位数字 位数为奇数）
 * 7896 是 4 位数字（位数为偶数）
 * 因此只有 12 和 7896 是位数为偶数的数字
 *
 * 示例 2：
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 *
 * 提示：
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits
 *
 * Solution1
 * string大法好
 */
public class Solution1 {

    public int findNumbers(int[] nums) {

        int count = 0;

        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
