package com.wangrollin.leetcode.n0_normal.p100.p110.problem111;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定二叉树[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 *
 * Solution2
 * 广度优先遍历，BFS，迭代
 */
public class Solution2 {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth + 1;
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                size--;
            }
            depth++;
        }

        return depth;
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
