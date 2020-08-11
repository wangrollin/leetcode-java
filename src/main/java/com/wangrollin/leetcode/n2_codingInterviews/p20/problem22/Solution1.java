package com.wangrollin.leetcode.n2_codingInterviews.p20.problem22;

/**
 * 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 *
 * Solution1
 * 快慢双指针
 */
public class Solution1 {

    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode slowNode = head;
        ListNode fastNode = head;

        for (int i = 0; i < k; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        return slowNode;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
