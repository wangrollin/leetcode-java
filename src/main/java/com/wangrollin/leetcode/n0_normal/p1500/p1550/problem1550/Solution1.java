package com.wangrollin.leetcode.n0_normal.p1500.p1550.problem1550;

/**
 * 存在连续三个奇数的数组
 *
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 *
 * 示例 2：
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 *
 * 提示：
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-consecutive-odds
 *
 * Solution1
 * 遍历一遍
 */
public class Solution1 {

    public boolean threeConsecutiveOdds(int[] arr) {

        if (arr == null || arr.length <= 2) {
            return false;
        }

        boolean processing = false;
        int count = 0;

        for (int num : arr) {

            if (num % 2 == 1) {
                count++;
                if (count == 3) {
                    return true;
                }
                if (!processing) {
                    processing = true;
                }
            } else if (processing) {
                processing = false;
                count = 0;
            }
        }

        return false;
    }
}
