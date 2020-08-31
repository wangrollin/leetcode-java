package com.wangrollin.leetcode.n0_normal.p100.p100.problem100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 * 输出: true
 *
 * 示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 * 输出: false
 *
 * 示例3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 *
 * Solution2
 * 广度优先遍历，BFS，迭代
 */
public class Solution2 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(p);
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            } else {
                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.left);
                queue2.add(node2.right);
            }
        }

        return true;
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

