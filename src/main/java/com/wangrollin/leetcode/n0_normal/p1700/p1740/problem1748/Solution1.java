package com.wangrollin.leetcode.n0_normal.p1700.p1740.problem1748;

import java.util.*;

/**
 * 唯一元素的和
 *
 * 给你一个整数数组nums。数组中唯一元素是那些只出现恰好一次的元素。
 * 请你返回 nums中唯一元素的 和。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 *
 * 示例 2：
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 *
 * 示例 3 ：
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-unique-elements
 *
 * Solution1
 * map记录，stream计算
 */
public class Solution1 {

    public int sumOfUnique(int[] nums) {

        int sum = 0;

        Map<Integer, Integer> numCnt = new HashMap<>();

        for (int num : nums) {
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
        }

        return numCnt.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .sum();
    }
}
