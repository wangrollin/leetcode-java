package com.wangrollin.leetcode.p900.p900.problem905;

import java.util.Arrays;

/**
 * 按奇偶排序数组
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 * 提示：
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 *
 * Solution1
 * 针对 i%2 排序
 */
public class Solution2 {

    public int[] sortArrayByParity(int[] A) {

        return Arrays
                .stream(A)
                .boxed()
                .sorted((a, b) -> Integer.compare(a % 2, b % 2))
                .mapToInt(i -> i)
                .toArray();
    }
}
