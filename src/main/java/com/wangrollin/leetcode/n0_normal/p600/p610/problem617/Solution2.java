package com.wangrollin.leetcode.n0_normal.p600.p610.problem617;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 合并二叉树
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
 * 那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例1:
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * 注意:合并必须从两个树的根节点开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 *
 * Solution2
 * 迭代
 */
public class Solution2 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        t1.val += t2.val;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(t1);
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(t2);

        while (!q1.isEmpty()) {
            int size = q1.size();
            while (size > 0) {
                TreeNode node1 = q1.poll();
                TreeNode node2 = q2.poll();
                if (node1.left != null && node2.left != null) {
                    node1.left.val += node2.left.val;
                    q1.add(node1.left);
                    q2.add(node2.left);
                } else if (node1.left == null && node2.left != null) {
                    node1.left = node2.left;
                }

                if (node1.right != null && node2.right != null) {
                    node1.right.val += node2.right.val;
                    q1.add(node1.right);
                    q2.add(node2.right);
                } else if (node1.right == null && node2.right != null) {
                    node1.right = node2.right;
                }
                size--;
            }
        }

        return t1;
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
