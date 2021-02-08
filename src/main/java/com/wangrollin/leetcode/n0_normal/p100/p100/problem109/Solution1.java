package com.wangrollin.leetcode.n0_normal.p100.p100.problem109;

/**
 * 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 *
 * Solution1
 * 用一个数组来存储
 */
public class Solution1 {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        int len = 0;
        ListNode node = head;

        while (node != null) {
            len++;
            node = node.next;
        }

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = head.val;
            head = head.next;
        }

        return genTreeNode(arr, 0, len - 1);

    }

    private TreeNode genTreeNode(int[] arr, int left, int right) {

        if (left == right) {
            return new TreeNode(arr[left]);
        }

        int middle = left + (right - left) / 2;
        TreeNode node = new TreeNode(arr[middle]);

        if (left < middle) {
            node.left = genTreeNode(arr, left, middle - 1);
        }
        if (right > middle) {
            node.right = genTreeNode(arr, middle + 1, right);
        }

        return node;
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
