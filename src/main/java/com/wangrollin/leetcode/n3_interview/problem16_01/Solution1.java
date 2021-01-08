package com.wangrollin.leetcode.n3_interview.problem16_01;

/**
 * 交换数字
 *
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 *
 * 提示：
 * numbers.length == 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-numbers-lcci
 *
 * Solution1
 * 异或大法好
 */
public class Solution1 {

    public int[] swapNumbers(int[] numbers) {

        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
}
