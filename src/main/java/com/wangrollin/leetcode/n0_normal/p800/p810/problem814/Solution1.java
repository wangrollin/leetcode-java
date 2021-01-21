package com.wangrollin.leetcode.n0_normal.p800.p810.problem814;

/**
 * 二叉树剪枝
 *
 * 给定二叉树根结点root，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 *
 * 示例2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 *
 * 示例3:
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 *
 * 说明:
 * 给定的二叉树最多有100个节点。
 * 每个节点的值只会为0 或1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
 *
 * Solution1
 * 递归
 */
public class Solution1 {

    public TreeNode pruneTree(TreeNode root) {

        if (prune(root) == 0) {
            return null;
        } else {
            return root;
        }
    }

    private int prune(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left;
        if ((left = prune(node.left)) == 0) {
            node.left = null;
        }

        int right;
        if ((right = prune(node.right)) == 0) {
            node.right = null;
        }
        return node.val + left + right == 0 ? 0 : 1;
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
