package com.wangrollin.leetcode.n0_normal.p1000.p1030.problem1033;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 移动石子直到连续
 *
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。
 * 从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？
 * 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 *
 * 示例 1：
 * 输入：a = 1, b = 2, c = 5
 * 输出：[1, 2]
 * 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
 *
 * 示例 2：
 * 输入：a = 4, b = 3, c = 2
 * 输出：[0, 0]
 * 解释：我们无法进行任何移动。
 * 
 * 提示：
 * 1 <= a <= 100
 * 1 <= b <= 100
 * 1 <= c <= 100
 * a != b, b != c, c != a
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/moving-stones-until-consecutive
 *
 * Solution1
 * max = z-x-2
 * min = 如果紧挨着，0；如果有一个位置的空隙，1；如果空隙都大于1，2；
 */
public class Solution1 {

    public int[] numMovesStones(int a, int b, int c) {

        List<Integer> input = Arrays.asList(a, b, c);
        input.sort(Comparator.comparingInt(x -> x));

        if (input.get(2) - input.get(1) == 1 && input.get(1) - input.get(0) == 1) {
            return new int[]{0, 0};
        } else if ((input.get(2) - input.get(1) == 2 || input.get(1) - input.get(0) == 2)
                || (input.get(2) - input.get(1) == 1 || input.get(1) - input.get(0) == 1)) {
            return new int[]{1, input.get(2) - input.get(0) - 2};
        } else {
            return new int[]{2, input.get(2) - input.get(0) - 2};
        }
    }
}
