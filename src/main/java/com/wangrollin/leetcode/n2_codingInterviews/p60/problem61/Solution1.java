package com.wangrollin.leetcode.n2_codingInterviews.p60.problem61;

import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 *
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 
 * 示例2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 *
 * Solution1
 * 没有重复（0除外），max - min < 5,
 */
public class Solution1 {

    public boolean isStraight(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num == 0) {
                continue;
            }

            if (set.contains(num)) {
                return false;
            } else {
                set.add(num);
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
        }

        return max - min < 5;
    }
}