package com.wangrollin.leetcode.n0_normal.p1600.p1650.problem1652;

import java.util.Arrays;

/**
 * 拆炸弹
 *
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为n的循环数组code以及一个密钥k。
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会同时被替换。
 * 如果k > 0，将第i个数字用 接下来k个数字之和替换。
 * 如果k < 0，将第i个数字用 之前k个数字之和替换。
 * 如果k == 0，将第i个数字用0替换。
 * 由于code是循环的，code[n-1]下一个元素是code[0]，且code[0]前一个元素是code[n-1]。
 * 给你 循环数组code和整数密钥k，请你返回解密后的结果来拆除炸弹！
 *
 * 示例 1：
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 *
 * 示例 2：
 * 输入：code = [1,2,3,4], k = 0
 * 输出：[0,0,0,0]
 * 解释：当 k 为 0 时，所有数字都被 0 替换。
 *
 * 示例 3：
 * 输入：code = [2,4,9,3], k = -2
 * 输出：[12,5,6,13]
 * 解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
 *
 * 提示：
 * n == code.length
 * 1 <= n<= 100
 * 1 <= code[i] <= 100
 * -(n - 1) <= k <= n - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/defuse-the-bomb
 *
 * Solution1
 * 模拟计算
 */
public class Solution1 {

    public int[] decrypt(int[] code, int k) {

        int[] result = new int[code.length];

        if (k == 0) {
            Arrays.fill(result, 0);
            return result;
        }

        int start, end;
        if (k > 0) {
            start = getNextIndex(code, 0);
            end = k % code.length;
        } else {
            start = (code.length - Math.abs(k)) % code.length;
            end = (code.length - 1) % code.length;
        }

        int sum = 0;
        if (start == end) {
            sum = code[start];
        } else if (start < end) {
            for (int i = start; i <= end; i++) {
                sum += code[i];
            }
        } else {
            for (int i = start; i < code.length; i++) {
                sum += code[i];
            }
            for (int i = 0; i <= end; i++) {
                sum += code[i];
            }
        }

        for (int i = 0; i < code.length; i++) {
            result[i] = sum;
            sum -= code[start];
            start = getNextIndex(code, start);
            end = getNextIndex(code, end);
            sum += code[end];
        }
        return result;
    }

    private int getNextIndex(int[] code, int curIndex) {

        return (curIndex + 1) % code.length;
    }
}
