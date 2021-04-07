package com.wangrollin.leetcode.n0_normal.p1100.p1160.problem1161;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最大层内元素和
 *
 * 给你一个二叉树的根节点root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中最小 的那个。
 *
 * 示例 1：
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 *
 * 示例 2：
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 *
 * 提示：
 * 树中的节点数介于1和10^4之间
 * -10^5 <= node.val <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree
 *
 * Solution1
 * 层级遍历
 */
public class Solution1 {

    public int maxLevelSum(TreeNode root) {

        int minLevel = 1;
        int maxValueSum = Integer.MIN_VALUE;
        int curLevel = 1;

        if (root == null) {
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            int curSum = 0;
            while (size != 0) {
                TreeNode node = queue.poll();
                curSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            if (curSum > maxValueSum) {
                maxValueSum = curSum;
                minLevel = curLevel;
            }
            curLevel++;
        }

        return minLevel;
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
