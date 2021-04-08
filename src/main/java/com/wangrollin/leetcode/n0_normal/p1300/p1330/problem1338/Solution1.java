package com.wangrollin.leetcode.n0_normal.p1300.p1330.problem1338;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数组大小减半
 *
 * 给你一个整数数组arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * 返回至少能删除数组中的一半整数的整数集合的最小大小。
 *
 * 示例 1：
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 *
 * 示例 2：
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 *
 * 示例 3：
 * 输入：arr = [1,9]
 * 输出：1
 *
 * 示例 4：
 * 输入：arr = [1000,1000,3,7]
 * 输出：1
 *
 * 示例 5：
 * 输入：arr = [1,2,3,4,5,6,7,8,9,10]
 * 输出：5
 *
 * 提示：
 * 1 <= arr.length <= 10^5
 * arr.length为偶数
 * 1 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reduce-array-size-to-the-half
 *
 * Solution1
 * 统计出现次数，降序，然后找次数之和
 */
public class Solution1 {

    public int minSetSize(int[] arr) {

        Map<Integer, Integer> numCount = new HashMap<>();

        for (int num : arr) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        List<Integer> frequncy =
                numCount.values().stream()
                        .sorted((a, b) -> b - a)
                        .collect(Collectors.toList());

        int result = 0;
        int curCountSum = 0;

        for (Integer singleCount : frequncy) {

            curCountSum += singleCount;
            result++;

            if (curCountSum >= arr.length / 2) {
                break;
            }
        }

        return result;
    }
}
