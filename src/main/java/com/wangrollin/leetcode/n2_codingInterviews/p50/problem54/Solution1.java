package com.wangrollin.leetcode.n2_codingInterviews.p50.problem54;

/**
 * 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *   2
 * 输出: 4
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 *
 * Solution1
 * 递归，深度优先遍历，右->中->左 顺序，在回溯的时候做处理
 */
public class Solution1 {

    private int result = 0;

    private int steps = 0;

    public int kthLargest(TreeNode root, int k) {

        findIt(root, k);
        return result;
    }

    private boolean findIt(TreeNode node, int k) {

        if (node == null) {
            return false;
        }

        if (findIt(node.right, k)) {
            return true;
        }
        steps++;
        if (steps == k) {
            result = node.val;
            return true;
        }
        if (findIt(node.left, k)) {
            return true;
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
