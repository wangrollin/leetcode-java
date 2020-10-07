package com.wangrollin.leetcode.n2_codingInterviews.p20.problem24;

/**
 * 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
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
    
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
