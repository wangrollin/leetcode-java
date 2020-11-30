package com.wangrollin.leetcode.n0_normal.p0.p70.problem78;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 *
 * Solution1
 * 递归遍历，0或1
 */
public class Solution1 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        calc(result, nums, 0, new ArrayList<>());
        return result;
    }

    private void calc(List<List<Integer>> result, int[] nums, int curIndex, List<Integer> curList) {

        if (curIndex == nums.length) {
            result.add(curList);
            return;
        }

        calc(result, nums, curIndex + 1, curList);

        List<Integer> newList = new ArrayList<>(curList);
        newList.add(nums[curIndex]);
        calc(result, nums, curIndex + 1, newList);
    }
}
