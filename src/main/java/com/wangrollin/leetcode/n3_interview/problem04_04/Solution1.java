package com.wangrollin.leetcode.n3_interview.problem04_04;

/**
 * 检查平衡性
 *
 * 实现一个函数，检查二叉树是否平衡。
 * 在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
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
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 
 * Solution1
 * 深度优先遍历，DFS，自上而下递归，判断每个节点都是平衡的
 */
public class Solution1 {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }
    }

    private int getHeight(TreeNode node) {

        if (node == null) {
            return 0;
        } else {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
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
