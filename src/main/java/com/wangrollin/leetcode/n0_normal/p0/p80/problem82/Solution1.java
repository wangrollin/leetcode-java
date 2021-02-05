package com.wangrollin.leetcode.n0_normal.p0.p80.problem82;

/**
 * 删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 *
 * 示例1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 *
 * Solution1
 * 主要在于细节的把控
 */
public class Solution1 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode result = new ListNode(-1);
        ListNode sure = result;
        ListNode notSure = head;
        sure.next = notSure;
        ListNode cur = head.next;

        while (cur != null) {

            if (cur.val != notSure.val) {
                sure = notSure;
                notSure = cur;
                cur = cur.next;
            } else {
                while (true) {
                    cur = cur.next;
                    if (cur == null) {
                        sure.next = null;
                        break;
                    } else if (cur.val != notSure.val) {
                        sure.next = cur;
                        notSure = cur;
                        cur = cur.next;
                        break;
                    }
                }
            }
        }

        return result.next;
    }


    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
