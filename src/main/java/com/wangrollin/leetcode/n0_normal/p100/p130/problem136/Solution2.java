package com.wangrollin.leetcode.n0_normal.p100.p130.problem136;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 *
 * Solution2
 * set
 */
public class Solution2 {

    public int singleNumber(int[] nums) {

        Set<Integer> counter = new HashSet<>();

        Arrays.stream(nums)
                .forEach(i -> {
                    if (counter.contains(i)) {
                        counter.remove(i);
                    } else {
                        counter.add(i);
                    }
                });

        return counter.stream().findFirst().get();
    }
}
