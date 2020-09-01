package com.wangrollin.leetcode.n0_normal.p100.p100.problem101;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 *
 * Solution2
 * 广度优先遍历，BFS，迭代
 */
public class Solution2 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return checkLeftAndRight(root.left, root.right);
    }

    private boolean checkLeftAndRight(TreeNode left, TreeNode right) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(left);
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.add(right);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            } else {
                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.right);
                queue2.add(node2.left);
            }
        }

        return true;
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