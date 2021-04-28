package com.wangrollin.leetcode.n0_normal.p1000.p1020.problem1022;

/**
 * 从根到叶的二进制数之和
 *
 * 给出一棵二叉树，其上每个结点的值都是0或1。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数01101，也就是13。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 * 示例 1：
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * 示例 2：
 * 输入：root = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 *
 * 示例 4：
 * 输入：root = [1,1]
 * 输出：3
 *
 * 提示：
 * 树中的结点数介于 1 和 1000 之间。
 * Node.val 为 0 或 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 *
 * Solution1
 * DFS
 */
public class Solution1 {

    public int sumRootToLeaf(TreeNode root) {

        return cal(root, 0);
    }

    private int cal(TreeNode node, int curValue) {

        if (node == null) {
            return 0;
        }

        curValue = curValue * 2 + node.val;

        if (node.left == null && node.right == null) {
            return curValue;
        } else {
            return cal(node.left, curValue)
                    + cal(node.right, curValue);
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
