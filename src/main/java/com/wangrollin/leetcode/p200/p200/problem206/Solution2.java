package com.wangrollin.leetcode.p200.p200.problem206;

/**
 * 反转链表
 *
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶: 你可以迭代或递归地反转链表
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 *
 * Solution2
 * 递归
 */
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        return reverseListRecursion(null, head);
    }

    private ListNode reverseListRecursion(ListNode preNode, ListNode curNode) {
        if (curNode == null) {
            return null;
        }
        if (curNode.next == null) {
            curNode.next = preNode;
            return curNode;
        }
        ListNode result = reverseListRecursion(curNode, curNode.next);
        curNode.next = preNode;
        return result;
    }
}
