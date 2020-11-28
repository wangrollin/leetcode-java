package com.wangrollin.leetcode.n0_normal.p0.p40.problem46;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 *
 * Solution1
 * 递归去添加可能的结果
 */
public class Solution1 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> newNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        calc(result, newNums, new ArrayList<>());
        return result;
    }

    private void calc(List<List<Integer>> result, Set<Integer> nums, List<Integer> curList) {

        if (nums.isEmpty()) {

            result.add(curList);
            return;
        }

        for (Integer num : nums) {

            List<Integer> newList = new ArrayList<>(curList);
            newList.add(num);
            Set<Integer> newNums = new HashSet<>(nums);
            newNums.remove(num);
            calc(result, newNums, newList);
        }
    }
}
