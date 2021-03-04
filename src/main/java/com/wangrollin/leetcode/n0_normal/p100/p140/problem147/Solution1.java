package com.wangrollin.leetcode.n0_normal.p100.p140.problem147;

/**
 * 对链表进行插入排序
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *  - 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 *  - 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 *
 * Solution1
 * 直接实现排序逻辑就可以
 */
public class Solution1 {

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = cur.next;

        while (true) {

            pre.next = null;
            cur.next = null;

            ListNode node = new ListNode(-1);
            node.next = head;

            while (true) {
                if (cur.val < node.next.val) {
                    if (node.next == head) {
                        cur.next = head;
                        head = cur;
                    } else {
                        cur.next = node.next;
                        node.next = cur;
                    }
                    break;
                }
                if (node.next == pre) {
                    cur.next = next;
                    pre.next = cur;
                    pre = cur;
                    break;
                } else {
                    node = node.next;
                }
            }

            if (next == null) {
                break;
            }
            cur = next;
            next = next.next;
        }

        return head;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
