package com.wangrollin.leetcode.p900.p980.problem989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数组形式的整数加法
 *
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * 示例 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 *
 * 示例 3：
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 *
 * 示例 4：
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *  
 * 提示：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 *
 * Solution1
 * 逐位相加
 */
public class Solution1 {

    public List<Integer> addToArrayForm(int[] A, int K) {

        int len = Math.max(A.length, String.valueOf(K).length());
        List<Integer> result = new ArrayList<>();
        int carry = 0;

        for (int i = 0; i < len; i++) {
            int sum;
            if (A.length - 1 - i >= 0) {
                sum = A[A.length - 1 - i] + K % 10 + carry;
            } else {
                sum = K % 10 + carry;
            }
            carry = sum / 10;
            result.add(sum % 10);
            K /= 10;
        }

        if (carry != 0) {
            result.add(carry);
        }

        Collections.reverse(result);
        return result;
    }
}
