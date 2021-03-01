package com.wangrollin.leetcode.n0_normal.p100.p140.problem143;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 重排链表
 *
 * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 *
 * Solution1
 * 本方法：找到中间点，前面的放在Queue里，后面的放在stack里
 * 方法2：直接用arrayList存储链表，然后重新连接
 * 方法3：找到中间节点，递归反转后半段链表，然后双表merge
 */
public class Solution1 {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        int len = 0;
        ListNode cur = head.next;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        boolean isOdd = len % 2 == 1;

        cur = head.next;
        Queue<ListNode> small = new LinkedList<>();
        int count = len / 2;
        while (count != 0) {
            count--;
            small.add(cur);
            cur = cur.next;
        }

        ListNode middle = null;
        if (isOdd) {
            middle = cur;
            cur = cur.next;
            middle.next = null;
        }

        Stack<ListNode> large = new Stack<>();
        count = len / 2;
        while (count != 0) {
            count--;
            large.push(cur);
            cur = cur.next;
        }

        count = len / 2;
        cur = head;
        while (count != 0) {
            count--;
            cur.next = large.pop();
            cur.next.next = small.poll();
            cur = cur.next.next;
        }

        cur.next = middle;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
