package com.wangrollin.leetcode.n0_normal.p100.p110.problem112;

/**
 * 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 *
 * Solution1
 * 深度优先遍历，DFS，递归
 */
public class Solution1 {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        return calSum(root, 0, sum);
    }

    private boolean calSum(TreeNode node, int curSum, final int targetSum) {

        if (node.left == null && node.right == null) {
            return curSum + node.val == targetSum;
        } else {
            boolean leftResult = false;
            if (node.left != null) {
                leftResult = calSum(node.left, curSum + node.val, targetSum);
            }
            if (leftResult) {
                return true;
            }
            boolean rightResult = false;
            if (node.right != null) {
                rightResult = calSum(node.right, curSum + node.val, targetSum);
            }
            return rightResult;
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
