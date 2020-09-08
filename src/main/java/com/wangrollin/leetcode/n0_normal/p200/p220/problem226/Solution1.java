package com.wangrollin.leetcode.n0_normal.p200.p220.problem226;

/**
 * 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 *
 * Solution1
 * 深度优先遍历，DFS，递归
 */
public class Solution1 {

    public TreeNode invertTree(TreeNode root) {

        if (root != null) {
            invertTree(root.left);
            invertTree((root.right));
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        return root;
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
