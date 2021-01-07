package com.wangrollin.leetcode.n0_normal.p1600.p1630.problem1637;

import java.util.Arrays;

/**
 * 两点之间不包含任何点的最宽垂直面积
 *
 * 给你n个二维平面上的点 points ，其中points[i] = [xi, yi]，请你返回两点之间内部不包含任何点的最宽垂直面积的宽度。
 * 垂直面积 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直面积为宽度最大的一个垂直面积。
 * 请注意，垂直区域边上的点不在区域内。
 *
 * 示例 1：
 * 输入：points = [[8,7],[9,9],[7,4],[9,7]]
 * 输出：1
 * 解释：红色区域和蓝色区域都是最优区域。
 *
 * 示例 2：
 * 输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * 输出：3
 *
 * 提示：
 * n == points.length
 * 2 <= n <= 105
 * points[i].length == 2
 * 0 <= xi, yi<= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/widest-vertical-area-between-two-points-containing-no-points
 *
 * Solution1
 * 根据x坐标排序，然后遍历找到最大空间
 */
public class Solution1 {

    public int maxWidthOfVerticalArea(int[][] points) {

        int[] sorted =
                Arrays.stream(points)
                        .mapToInt(point -> point[0])
                        .sorted()
                        .toArray();

        int max = 0;

        for (int i = 1; i < sorted.length; i++) {
            max = Math.max(max, sorted[i] - sorted[i - 1]);
        }

        return max;
    }
}
