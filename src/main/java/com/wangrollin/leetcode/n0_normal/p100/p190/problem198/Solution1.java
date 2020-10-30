package com.wangrollin.leetcode.n0_normal.p100.p190.problem198;

/**
 * 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *     偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 *
 * Solution1
 * 迭代，存储两个值
 * f(i)代表偷了这一家的情况下，从1到i的最大收入
 * 状态转移方程：f(i) = cur_i + max(f(i-2), f(i-3))
 */
public class Solution1 {

    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int firstMax = nums[0];
        if (nums.length == 1) {
            return firstMax;
        }

        int secondMax = nums[1];
        if (nums.length == 2) {
            return Math.max(firstMax, secondMax);
        }

        int thirdMax = firstMax + nums[2];
        if (nums.length == 3) {
            return Math.max(secondMax, thirdMax);
        }

        for (int i = 3; i <= nums.length - 1; i++) {
            int temp = nums[i] + Math.max(firstMax, secondMax);
            firstMax = secondMax;
            secondMax = thirdMax;
            thirdMax = temp;
        }

        return Math.max(secondMax, thirdMax);
    }
}
