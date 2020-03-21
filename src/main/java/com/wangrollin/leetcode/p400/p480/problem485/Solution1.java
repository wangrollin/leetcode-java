package com.wangrollin.leetcode.p400.p480.problem485;

/**
 * 最大连续1的个数
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 *
 * 注意：
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 *
 * Solution1
 * 遍历并记录
 */
public class Solution1 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int maxCount = 0;
        boolean counting = false;
        int curCount = 0;
        for (int num : nums) {
            if (num == 1) {
                if (counting) {
                    curCount++;
                } else {
                    counting = true;
                    curCount = 1;
                }
            } else {
                maxCount = Math.max(maxCount, curCount);
                counting = false;
                curCount = 0;
            }
        }
        maxCount = Math.max(maxCount, curCount);

        return maxCount;
    }
}
