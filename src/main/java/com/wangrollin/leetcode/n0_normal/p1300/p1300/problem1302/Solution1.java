package com.wangrollin.leetcode.n0_normal.p1300.p1300.problem1302;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层数最深叶子节点的和
 *
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 * 示例：
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *
 * 提示：
 * 树中节点数目在1到10^4之间。
 * 每个节点的值在1到100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deepest-leaves-sum
 *
 * Solution1
 * 层级遍历
 */
public class Solution1 {

    public int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = root.val;

        while (!queue.isEmpty()) {

            sum = 0;
            int size = queue.size();
            while (size > 0) {

                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                size--;
            }
        }

        return sum;
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
