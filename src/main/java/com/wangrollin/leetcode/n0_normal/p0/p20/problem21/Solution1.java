package com.wangrollin.leetcode.n0_normal.p0.p20.problem21;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * Solution1
 * 太简单了，合并就行了
 */
public class Solution1 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode curRlt = result;
        ListNode curIndex1 = l1;
        ListNode curIndex2 = l2;
        while (true) {
            if (curIndex1 == null) {
                curRlt.next = curIndex2;
                return result.next;
            }
            if (curIndex2 == null) {
                curRlt.next = curIndex1;
                return result.next;
            }
            if (curIndex1.val <= curIndex2.val) {
                curRlt.next = curIndex1;
                curRlt = curRlt.next;
                curIndex1 = curIndex1.next;
            } else {
                curRlt.next = curIndex2;
                curRlt = curRlt.next;
                curIndex2 = curIndex2.next;
            }
        }
    }

    public static void main(String[] args) {

    }
}
