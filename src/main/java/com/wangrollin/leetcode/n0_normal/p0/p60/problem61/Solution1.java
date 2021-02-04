package com.wangrollin.leetcode.n0_normal.p0.p60.problem61;

/**
 * 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 *
 * 示例1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步:0->1->2->NULL
 * 向右旋转 4 步:2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 *
 * Solution1
 * 找出新的头尾，然后缝合即可
 */
public class Solution1 {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        int len = 0;
        ListNode node = head;

        while (node != null) {
            len++;
            node = node.next;
        }

        k %= len;

        if (k == 0) {
            return head;
        }

        ListNode left = head;
        ListNode right = head;

        while (k > 0) {
            k--;
            right = right.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        right.next = head;
        ListNode result = left.next;
        left.next = null;

        return result;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
