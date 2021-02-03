package com.wangrollin.leetcode.n0_normal.p0.p20.problem25;

/**
 * K 个一组翻转链表
 *
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当k= 2 时，应当返回: 2->1->4->3->5
 * 当k= 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * Solution1
 * 写个函数进行专门翻转工作，主要在于控制细节
 */
public class Solution1 {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1 || head == null) {
            return head;
        }

        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode curBefore = result;
        ListNode curAfter = null;
        boolean finished = false;

        while (!finished) {

            ListNode first = curBefore.next;
            ListNode cur = curBefore.next;

            for (int i = 0; i < k; i++) {
                if (cur == null) {
                    finished = true;
                    break;
                }
                if (i != k - 1) {
                    cur = cur.next;
                }
            }

            if (!finished) {

                ListNode last = cur;
                curAfter = cur.next;
                reverse(first, k);
                curBefore.next = last;
                first.next = curAfter;

                curBefore = first;
                curAfter = null;
            }
        }

        return result.next;
    }

    private void reverse(ListNode first, int k) {

        ListNode node1 = first;
        ListNode node2 = first.next;
        ListNode node3 = first.next.next;
        node1.next = null;

        while (k - 1 > 0) {
            node2.next = node1;

            node1 = node2;
            node2 = node3;
            node3 = node3 == null ? null : node3.next;
            k--;
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
