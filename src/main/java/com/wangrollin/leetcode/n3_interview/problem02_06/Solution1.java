package com.wangrollin.leetcode.n3_interview.problem02_06;

/**
 * 回文链表
 *
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 *
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 *
 * Solution1
 * 快慢指针找到中间节点，反转后半部分链表，进行比较
 */
public class Solution1 {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int secondStart = len / 2 + len % 2;

        cur = head;
        while (secondStart > 0) {
            cur = cur.next;
            secondStart--;
        }

        ListNode head2 = reverse(cur);

        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {

        if (node.next == null) {
            return node;
        }

        ListNode last = reverse(node.next);
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
