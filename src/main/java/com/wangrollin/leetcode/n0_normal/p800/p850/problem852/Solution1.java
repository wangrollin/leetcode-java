package com.wangrollin.leetcode.n0_normal.p800.p850.problem852;

/**
 * 山脉数组的峰顶索引
 *
 * 我们把符合下列属性的数组A称作山脉：
 * A.length >= 3
 * 存在 0 < i< A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]的 i的值。
 *
 * 示例 1：
 * 输入：[0,1,0]
 * 输出：1
 *
 * 示例 2：
 * 输入：[0,2,1,0]
 * 输出：1
 * 
 * 提示：
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 *
 * Solution1
 * 二分查找，middle = left + (right - left) / 2;
 */
public class Solution1 {

    public int peakIndexInMountainArray(int[] A) {

        int len = A.length;
        int left = 0;
        int right = A.length;
        int middle = left + (right - left) / 2;

        while (true) {
            if (A[middle - 1] < A[middle] && A[middle + 1] < A[middle]) {
                return middle;
            } else if (A[middle - 1] < A[middle]) {
                left = middle;
                middle = left + (right - left) / 2;
            } else {
                right = middle;
                middle = left + (right - left) / 2;
            }
        }
    }
}
