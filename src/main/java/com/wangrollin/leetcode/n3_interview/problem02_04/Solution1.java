package com.wangrollin.leetcode.n3_interview.problem02_04;

/**
 * 分割链表
 *
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
 * 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 *
 * Solution1
 * 分割，然后连接上
 */
public class Solution1 {

    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode preSmall = new ListNode(-1);
        ListNode curSmall = preSmall;
        ListNode preLarge = new ListNode(-1);
        ListNode curLarge = preLarge;

        while (head != null) {

            if (head.val >= x) {
                curLarge.next = head;
                curLarge = head;
                head = head.next;
                curLarge.next = null;
            } else {
                curSmall.next = head;
                curSmall = head;
                head = head.next;
                curSmall.next = null;
            }
        }

        if (preSmall.next != null) {
            curSmall.next = preLarge.next;
            return preSmall.next;
        } else {
            return preLarge.next;
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
