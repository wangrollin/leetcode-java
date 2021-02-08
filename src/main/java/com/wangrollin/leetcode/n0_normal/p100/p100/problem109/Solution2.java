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
 * Solution2
 * 使用快慢指针找中间节点，慢指针走1步，快指针走2步
 */
public class Solution2 {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        return genTreeNode(head);
    }

    private TreeNode genTreeNode(ListNode head) {

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode beforeMiddleNode = getBeforeMiddleNode(head);
        ListNode middleNode = beforeMiddleNode.next;
        beforeMiddleNode.next = null;

        ListNode head2 = middleNode.next;

        TreeNode node = new TreeNode(middleNode.val);

        if (head != middleNode) {
            node.left = genTreeNode(head);
        }
        if (head2 != null) {
            node.right = genTreeNode(head2);
        }

        return node;
    }

    private ListNode getBeforeMiddleNode(ListNode head) {

        ListNode beforeHead = new ListNode(-1);
        beforeHead.next = head;
        ListNode slow = beforeHead;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
