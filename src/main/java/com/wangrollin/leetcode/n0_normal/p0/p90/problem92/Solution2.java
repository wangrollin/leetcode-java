package com.wangrollin.leetcode.n0_normal.p0.p90.problem92;

/**
 * 反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤m≤n≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 *
 * Solution2
 * 递归，实际改变链表结构
 */
public class Solution2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n) {
            return head;
        }

        ListNode result = new ListNode(-1);
        result.next = head;

        ListNode nodeM = null;
        ListNode nodeBeforeM = result;

        ListNode nodeN = result;
        ListNode nodeAfterN = null;

        int k = n - m + 1;
        while (m - 1 > 0) {
            m--;
            nodeBeforeM = nodeBeforeM.next;
        }
        nodeM = nodeBeforeM.next;

        while (n > 0) {
            n--;
            nodeN = nodeN.next;
        }
        nodeAfterN = nodeN.next;

        reverse(nodeM, k);
        nodeBeforeM.next = nodeN;
        nodeM.next = nodeAfterN;

        return result.next;
    }

    private ListNode reverse(ListNode node, int k) {

        if (k == 1) {
            node.next = null;
            return node;
        }

        ListNode last = reverse(node.next, k - 1);
        node.next.next = node;
        node.next = null;
        return last;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
