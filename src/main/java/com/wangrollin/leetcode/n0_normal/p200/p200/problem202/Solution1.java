package com.wangrollin.leetcode.n0_normal.p200.p200.problem202;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *  - 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 *  - 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 *  - 如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 * 示例 1：
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 *
 * 提示：
 * 1 <= n <= 2**31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 *
 * Solution1
 * 哈希表判断
 * 也可以用快慢指针，本质上判断链表是否有环
 * 也可以直接用数学算法求解：会发现只有一个循环：4→16→37→58→89→145→42→20→4。所有其他数字都在进入这个循环的链上，或者在进入 1 的链上
 */
public class Solution1 {

    public boolean isHappy(int n) {

        Set<Integer> nums = new HashSet<>();

        while (n != 1) {
            if (nums.contains(n)) {
                return false;
            } else {
                nums.add(n);
                String str = Integer.toString(n);
                n = 0;
                for (int i = 0; i < str.length(); i++) {
                    n += (str.charAt(i) - '0') * (str.charAt(i) - '0');
                }
            }
        }

        return true;
    }
}
