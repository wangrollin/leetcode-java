package com.wangrollin.leetcode.n2_codingInterviews.p50.problem55_2;

/**
 * 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
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
 * 限制：
 * 1 <= 树的结点个数 <= 10000
 *
 * 注意：本题与主站 110题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
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
