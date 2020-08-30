package com.wangrollin.leetcode.n3_interview.problem17_04;

import java.util.Arrays;

/**
 * 消失的数字
 *
 * 数组nums包含从0到n的所有整数，但其中缺了一个。
 * 请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * 注意：本题相对书上原题稍作改动
 *
 * 示例 1：
 * 输入：[3,0,1]
 * 输出：2
 *
 * 示例 2：
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number-lcci
 *
 * Solution1
 * 利用数学方法，算出 0 + 1 + ... + n 的和，然后减去数组中元素之和，即为缺失的元素
 */
public class Solution1 {

    public int missingNumber(int[] nums) {

        return nums.length * (nums.length + 1) / 2
                - Arrays.stream(nums).sum();
    }
}