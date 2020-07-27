package com.wangrollin.leetcode.n0_normal.p600.p690.problem697;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度
 *
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 示例 2:
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 *
 * 注意:
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 *
 * Solution1
 * 遍历一遍，动态更新数据
 */
public class Solution1 {

    public static int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> len = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int maxCount = 1;
        int minLen = 1;

        for (int i = 0; i < nums.length; i++) {
            if (!left.containsKey(nums[i])) {
                left.put(nums[i], i);
                right.put(nums[i], i);
                len.put(nums[i], 1);
                count.put(nums[i], 1);
            } else {
                right.put(nums[i], i);
                len.put(nums[i], right.get(nums[i]) - left.get(nums[i]) + 1);
                count.put(nums[i], count.get(nums[i]) + 1);
                if (count.get(nums[i]) > maxCount) {
                    maxCount = count.get(nums[i]);
                    minLen = len.get(nums[i]);
                } else if (count.get(nums[i]) == maxCount) {
                    minLen = Math.min(minLen, len.get(nums[i]));
                }
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }
}
