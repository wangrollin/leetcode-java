package com.wangrollin.leetcode.problem119;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 优化算法到 O(k) 空间复杂度
 *
 * Solution1
 * 遍历的时候复用数组
 */
public class Solution1 {

    public static List<Integer> getRow(int rowIndex) {
        rowIndex += 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowIndex; ++i) {
            int carry = 1;
            int tmp;
            for (int j = 0; j < i + 1; ++j) {
                if (i == 0) {
                    result.add(1);
                } else if (j != 0 && j != i) {
                    tmp = result.get(j);
                    result.set(j, carry + tmp);
                    carry = tmp;
                } else if (j == i) {
                    result.add(1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = getRow(5);
        for (Integer i : result) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
