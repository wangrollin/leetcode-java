package com.wangrollin.leetcode.n0_normal.p900.p970.problem977;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 有序数组的平方
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 *
 * Solution1
 * 可以先平方，再排序
 *
 * Solution2
 * 找到正负分界线，双指针向外移动并merge
 *
 * Solution3（最好）
 * 从外向内merge，不需要找分界线，然后reverse
 */
public class Solution1 {

    public int[] sortedSquares(int[] A) {

        List<Integer> result = new ArrayList<>(A.length);
        int left = 0;
        int right = A.length - 1;
        while (left != right) {
            if (A[left] * A[left] > A[right] * A[right]) {
                result.add(A[left] * A[left]);
                left++;
            } else {
                result.add(A[right] * A[right]);
                right--;
            }
        }
        result.add(A[left] * A[left]);

        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
