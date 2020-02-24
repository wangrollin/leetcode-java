package com.wangrollin.leetcode.problem203;

/**
 * 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * Solution1
 * 哨兵算法
 */
public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode firstNode = new ListNode(0);
        firstNode.next = head;
        ListNode curNode = firstNode;
        while (curNode.next != null) {
            if (curNode.next.val == val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return firstNode.next;
    }
}
