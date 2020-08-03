package com.wangrollin.leetcode.n0_normal.p400.p440.problem441;

/**
 * 排列硬币
 *
 * 你总共有n枚硬币，你需要将它们摆成一个阶梯形状，第k行就必须正好有k枚硬币。
 * 给定一个数字n，找出可形成完整阶梯行的总行数。
 * n是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 * n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 因为第三行不完整，所以返回2.
 *
 * 示例 2:
 * n = 8
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 因为第四行不完整，所以返回3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 *
 * Solution1
 * 直接用数学方法计算出结果，并向下取整；感觉可能会遇到精确的问题
 */
public class Solution1 {

    public int arrangeCoins(int n) {

        return (int) (Math.sqrt(2.0 * n + 0.25) - 0.5);
    }
}
