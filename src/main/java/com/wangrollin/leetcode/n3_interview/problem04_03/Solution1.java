package com.wangrollin.leetcode.n3_interview.problem04_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 特定深度节点链表
 *
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 *
 * 示例：
 * 输入：[1,2,3,4,5,null,7,8]
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 *
 * Solution1
 * 层级遍历
 */
public class Solution1 {

    public ListNode[] listOfDepth(TreeNode tree) {

        if (tree == null) {
            return new ListNode[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        List<ListNode> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int size = queue.size();
            ListNode first = new ListNode(-1);
            ListNode cur = first;

            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                cur.next = new ListNode(node.val);
                cur = cur.next;
                size--;
            }
            result.add(first.next);
        }

        return result.toArray(new ListNode[0]);
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
