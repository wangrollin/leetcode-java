package com.wangrollin.leetcode.n0_normal.p1300.p1310.problem1315;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 祖父节点值为偶数的节点和
 *
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 *  - 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回0 。
 *
 * 示例：
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 *
 * 提示：
 * 树中节点的数目在1 到10^4之间。
 * 每个节点的值在1 到100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 *
 * Solution1
 * 层级遍历
 */
public class Solution1 {

    public int sumEvenGrandparent(TreeNode root) {

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size > 0) {

                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.val % 2 == 0) {
                    result += calSum(node);
                }
                size--;
            }
        }

        return result;
    }

    private int calSum(TreeNode node) {

        int result = 0;

        if (node.left != null) {
            if (node.left.left != null) {
                result += node.left.left.val;
            }
            if (node.left.right != null) {
                result += node.left.right.val;
            }
        }
        if (node.right != null) {
            if (node.right.left != null) {
                result += node.right.left.val;
            }
            if (node.right.right != null) {
                result += node.right.right.val;
            }
        }

        return result;
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
