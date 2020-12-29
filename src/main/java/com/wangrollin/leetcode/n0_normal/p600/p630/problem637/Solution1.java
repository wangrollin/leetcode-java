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
 * 递归
 */
public class Solution1 {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> counts = new ArrayList<>();
        List<Double> avgs = new ArrayList<>();
        cal(root, counts, avgs, 1);

        return avgs;
    }

    private void cal(TreeNode node, List<Integer> counts, List<Double> avgs, int curDepth) {

        if (counts.size() < curDepth) {
            counts.add(1);
            avgs.add((double) node.val);
        } else {
            avgs.set(curDepth - 1, ((double) counts.get(curDepth - 1)) / (counts.get(curDepth - 1) + 1) * avgs.get(curDepth - 1)
                    + ((double) node.val) / (counts.get(curDepth - 1) + 1));
            counts.set(curDepth - 1, counts.get(curDepth - 1) + 1);
        }

        if (node.left != null) {
            cal(node.left, counts, avgs, curDepth + 1);
        }
        if (node.right != null) {
            cal(node.right, counts, avgs, curDepth + 1);
        }
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
