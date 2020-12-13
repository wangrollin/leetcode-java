package com.wangrollin.leetcode.n3_interview.problem08_04;

import java.util.ArrayList;
import java.util.List;

/**
 * 幂集
 *
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *  [3],
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
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
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
