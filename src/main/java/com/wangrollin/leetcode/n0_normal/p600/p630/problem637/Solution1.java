package com.wangrollin.leetcode.n0_normal.p600.p630.problem637;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层平均值
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 * 示例 1：
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * 
 * 提示：
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 
 * Solution1
 * 递归，超出内存限制，但也是一种思路
 */
public class Solution1 {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> counts = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
        cal(root, counts, sums, 1);

        for (int i = 0; i < counts.size(); i++) {
            result.add((double) sums.get(i) / counts.get(i));
        }
        return result;
    }

    private void cal(TreeNode node, List<Integer> counts, List<Integer> sums, int curDepth) {

        if (counts.size() < curDepth) {
            counts.add(1);
            sums.add(node.val);
        } else {
            counts.set(curDepth - 1, counts.get(curDepth - 1) + 1);
            sums.set(curDepth - 1, sums.get(curDepth - 1) + node.val);
        }
        cal(node, counts, sums, curDepth + 1);
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
