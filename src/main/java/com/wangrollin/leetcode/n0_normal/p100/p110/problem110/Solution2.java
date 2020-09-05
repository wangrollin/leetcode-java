package com.wangrollin.leetcode.n0_normal.p100.p110.problem110;

/**
 * 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 *
 * Solution2
 * 深度优先遍历，DFS，自下而上递归，判断每个节点都是平衡的
 */
public class Solution2 {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            return getHeight(root) != -1;
        }
    }

    public int getHeight(TreeNode node) {

        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            if (leftHeight == -1 || rightHeight == -1) {
                return -1;
            } else if (Math.abs(leftHeight - rightHeight) <= 1) {
                return Math.max(leftHeight, rightHeight) + 1;
            } else {
                return -1;
            }
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
