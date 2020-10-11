package com.wangrollin.leetcode.n2_codingInterviews.p20.problem25;

/**
 * 合并两个排序的链表
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
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

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
