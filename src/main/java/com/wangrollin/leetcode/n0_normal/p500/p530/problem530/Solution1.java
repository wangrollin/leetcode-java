package com.wangrollin.leetcode.n0_normal.p500.p530.problem530;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 二叉搜索树的最小绝对差
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 * 输出：
 * 1
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 提示：
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 *
 * Solution1
 * 遍历一遍
 */
public class Solution1 {

    public int getMinimumDifference(TreeNode root) {

        AtomicInteger minDiff = new AtomicInteger(Integer.MAX_VALUE);

        diff(minDiff, new AtomicInteger(-1), root);

        return minDiff.get();
    }

    private void diff(AtomicInteger minDiff, AtomicInteger preNum, TreeNode node) {

        if (node == null) {
            return;
        }

        diff(minDiff, preNum, node.left);

        if (preNum.get() != -1) {
            minDiff.set(Math.min(minDiff.get(), node.val - preNum.get()));
        }
        preNum.set(node.val);

        diff(minDiff, preNum, node.right);
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
