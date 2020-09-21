package com.wangrollin.leetcode.n0_normal.p600.p670.problem671;

/**
 * 二叉树中第二小的节点
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 *
 * 示例 2:
 * 输入:
 *     2
 *    / \
 *   2   2
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 *
 * Solution1
 * 递归
 */
public class Solution1 {

    private int min;
    private int ans = -1;

    public int findSecondMinimumValue(TreeNode root) {

        if (root == null || root.left == null) {
            return -1;
        }

        min = root.val;

        find(root);
        return ans;
    }

    private void find(TreeNode node) {

        if (node == null) {
            return;
        }
        if (node.val > min && (ans == -1 || node.val < ans)) {
            ans = node.val;
        }
        find(node.left);
        find(node.right);
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
