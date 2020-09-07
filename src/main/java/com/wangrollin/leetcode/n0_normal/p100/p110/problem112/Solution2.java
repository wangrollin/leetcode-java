package com.wangrollin.leetcode.n0_normal.p100.p110.problem112;

import java.util.LinkedList;
import java.util.Queue;

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
 * Solution2
 * 广度优先遍历，BFS，迭代
 */
public class Solution2 {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        Queue<Integer> sumQueue = new LinkedList<>();
        sumQueue.add(root.val);

        while (!nodeQueue.isEmpty()) {

            int size = nodeQueue.size();
            while (size > 0) {
                TreeNode node = nodeQueue.poll();
                int curSum = sumQueue.poll();
                if (node.left == null && node.right == null && curSum == sum) {
                    return true;
                }
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    sumQueue.add(curSum + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    sumQueue.add(curSum + node.right.val);
                }
                size--;
            }
        }

        return false;
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
