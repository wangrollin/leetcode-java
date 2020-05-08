package com.wangrollin.leetcode.p900.p920.problem922;

/**
 * 按奇偶排序数组 II
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 *
 * Solution1
 * 双指针法
 */
public class Solution1 {

    public int[] sortArrayByParityII(int[] A) {

        int evenIndex = 0;
        int oddIndex = 1;

        while (evenIndex < A.length && oddIndex < A.length) {
            if (A[evenIndex] % 2 == 1 && A[oddIndex] % 2 == 0) {
                int tmp = A[evenIndex];
                A[evenIndex] = A[oddIndex];
                A[oddIndex] = tmp;
                evenIndex += 2;
                oddIndex += 2;
            } else if (A[evenIndex] % 2 == 0) {
                evenIndex += 2;
            } else if (A[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }
        }

        return A;
    }
}
