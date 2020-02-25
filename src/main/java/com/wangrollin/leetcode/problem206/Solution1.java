package com.wangrollin.leetcode.problem206;

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
 * Solution1
 * 指针迭代
 */
public class Solution1 {

    public ListNode reverseList(ListNode head) {

        ListNode firstNode = null;
        ListNode middleNode = head;
        ListNode lastNode = middleNode == null ? null : middleNode.next;

        while (middleNode != null) {
            middleNode.next = firstNode;
            firstNode = middleNode;
            middleNode = lastNode;
            lastNode = lastNode == null ? null : lastNode.next;
        }

        return firstNode;
    }
}
