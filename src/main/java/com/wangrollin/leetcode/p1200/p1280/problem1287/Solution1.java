package com.wangrollin.leetcode.p1200.p1280.problem1287;

/**
 * 有序数组中出现次数超过25%的元素
 *
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 *
 * 示例：
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 * 提示：
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array
 *
 * Solution1
 * 过一遍
 */
public class Solution1 {

    public int findSpecialInteger(int[] arr) {

        int threshold = arr.length / 4;
        int cur = arr[0];
        int count = 0;

        for (int value : arr) {

            if (value != cur) {
                cur = value;
                count = 1;
            } else {
                count++;
            }

            if (count > threshold) {
                return cur;
            }
        }

        return 0;
    }
}
