package com.wangrollin.leetcode.n0_normal.p300.p340.problem342;

import java.util.HashSet;
import java.util.Set;

/**
 * 4的幂
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4的幂次方。
 *
 * 示例 1:
 * 输入: 16
 * 输出: true
 *
 * 示例 2:
 * 输入: 5
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 *
 * Solution2
 * int范围内的结果只有那几种，计算出来就可以了
 */
public class Solution2 {

    public boolean isPowerOfFour(int num) {
        return PreparedClass.isPowerOfFour(num);
    }

    static class PreparedClass {

        private static Set<Integer> set = new HashSet<>();

        static {
            set.add(1);
            int tmp = 1;
            for (int i = 0; i < 15; i++) {
                set.add(tmp *= 4);
            }
        }

        public static boolean isPowerOfFour(int num) {
            return set.contains(num);
        }
    }
}
