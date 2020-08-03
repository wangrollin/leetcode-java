package com.wangrollin.leetcode.n0_normal.p500.p530.problem532;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组中的K-diff数对
 *
 * 给定一个整数数组和一个整数k, 你需要在数组里找到不同的k-diff 数对。这里将k-diff数对定义为一个整数对 (i, j),
 * 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是k.
 *
 * 示例 1:
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 *
 * 示例2:
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 *
 * 示例 3:
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 *
 * 注意:
 * 数对 (i, j) 和数对(j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在[-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
 *
 * Solution1
 * o(n)时间的算法，用set记录两个数中较小的那个
 */
public class Solution1 {

    public int findPairs(int[] nums, int k) {

        if(k < 0) {
            return 0;
        }

        Set<Integer> result = new HashSet<>();
        Set<Integer> numSet = new HashSet<>();

        Arrays.stream(nums).forEach(num -> {

            if (numSet.contains(num + k)) {
                result.add(num);
            }
            if (numSet.contains(num - k)) {
                result.add(num - k);
            }
            numSet.add(num);
        });
        for (Integer i :
                result) {
            System.out.println(i);
        }
        return result.size();
    }
}
