package com.wangrollin.leetcode.n0_normal.p1200.p1290.problem1299;

/**
 * 将每个元素替换为右侧最大元素
 *
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 *
 * 示例：
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 *
 * 提示：
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side
 *
 * Solution1
 * 不断更新最大值
 */
public class Solution1 {

    public int[] replaceElements(int[] arr) {

        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(tmp, max);
        }

        return arr;
    }
}
