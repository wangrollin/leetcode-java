package com.wangrollin.leetcode.n0_normal.p0.p80.problem86;

/**
 * 分隔链表
 *
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例：
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 *
 * Solution1
 * 两个list分别存储大的和小的
 */
public class Solution1 {

    public ListNode partition(ListNode head, int x) {

        ListNode bigger = new ListNode(-1);
        ListNode biggerLast = bigger;
        ListNode less = new ListNode(-1);
        ListNode lessLast = less;

        while (head != null) {
            if (head.val >= x) {
                biggerLast.next = head;
                biggerLast = biggerLast.next;
            } else {
                lessLast.next = head;
                lessLast = lessLast.next;
            }
            head = head.next;
        }

        if (less != lessLast) {
            lessLast.next = biggerLast == bigger ? null : bigger.next;
            biggerLast.next = null;
            return less.next;
        } else {
            biggerLast.next = null;
            return bigger.next;
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
