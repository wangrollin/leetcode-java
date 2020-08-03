package com.wangrollin.leetcode.n0_normal.p1200.p1200.problem1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小绝对差
 *
 * 给你个整数数组arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 *
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 *
 * 示例 3：
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *
 * 提示：
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
 *
 * Solution1
 * 先排序，然后找
 */
public class Solution1 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int curMin = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < curMin) {
                curMin = arr[i] - arr[i - 1];
                result.clear();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (arr[i] - arr[i - 1] == curMin) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
