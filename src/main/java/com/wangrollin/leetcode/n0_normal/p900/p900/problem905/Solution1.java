package com.wangrollin.leetcode.n0_normal.p900.p900.problem905;

/**
 * 按奇偶排序数组
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中，A 的所有偶数元素之后跟着所有奇数元素。
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
 * 双指针法
 */
public class Solution1 {

    public int[] sortArrayByParity(int[] A) {

        int left = 0;
        int right = A.length - 1;

        while (left < right) {

            if (A[left] % 2 != 0 && A[right] % 2 == 0) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            } else if (A[left] % 2 == 0) {
                left++;
            } else if (A[right] % 2 != 0) {
                right--;
            }
        }

        return A;
    }
}
