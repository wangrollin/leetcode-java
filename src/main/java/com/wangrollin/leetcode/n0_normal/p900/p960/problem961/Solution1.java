package com.wangrollin.leetcode.n0_normal.p900.p960.problem961;

import java.util.HashSet;
import java.util.Set;

/**
 * 重复 N 次的元素
 *
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
 *
 * 示例 1：
 * 输入：[1,2,3,3]
 * 输出：3
 *
 * 示例 2：
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 *
 * 示例 3：
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *
 * 提示：
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 *
 * Solution1
 * 用set找到第一个重复的元素
 */
public class Solution1 {

    public int repeatedNTimes(int[] A) {

        Set<Integer> numSet = new HashSet<>();

        for (int num : A) {
            if (numSet.contains(num)) {
                return num;
            } else {
                numSet.add(num);
            }
        }

        return 0;
    }
}
