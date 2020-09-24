package com.wangrollin.leetcode.n0_normal.p800.p870.problem872;

import java.util.ArrayList;
import java.util.List;

/**
 * 叶子相似的树
 *
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
 * 举个例子，给定一颗叶值序列为(6, 7, 4, 9, 8)的树。
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
 * 如果给定的两个头结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
 *
 * 提示：
 * 给定的两颗树可能会有1到 200个结点。
 * 给定的两颗树上的值介于 0 到 200 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 *
 * Solution1
 * 递归
 */
public class Solution1 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        return generateLeavesList(root1, new ArrayList<>())
                .equals(generateLeavesList(root2, new ArrayList<>()));
    }

    private List<Integer> generateLeavesList(TreeNode node, List<Integer> leaves) {

        if (node == null) {
            return leaves;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        generateLeavesList(node.left, leaves);
        generateLeavesList(node.right, leaves);
        return leaves;
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
