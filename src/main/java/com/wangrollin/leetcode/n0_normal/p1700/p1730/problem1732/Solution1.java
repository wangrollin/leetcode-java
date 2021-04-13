package com.wangrollin.leetcode.n0_normal.p1700.p1730.problem1732;

/**
 * 找到最高海拔
 *
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由n + 1个不同海拔的点组成。自行车手从海拔为 0的点0开始骑行。
 * 给你一个长度为 n的整数数组gain，其中 gain[i]是点 i和点 i + 1的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔。
 *
 * 示例 1：
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 *
 * 示例 2：
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 *
 * 提示：
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-highest-altitude
 *
 * Solution1
 * 计算一遍
 */
public class Solution1 {

    public int largestAltitude(int[] gain) {

        int max = 0;
        int cur = 0;

        for (int diff : gain) {
            cur += diff;
            max = Math.max(max, cur);
        }

        return max;
    }
}
