package com.wangrollin.leetcode.n0_normal.p100.p140.problem148;

/**
 * 排序链表
 *
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 * 链表中节点的数目在范围[0, 5 * 104]内
 * -105<= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 *
 * Solution1
 * 本方法：在回溯中归并排序
 * 方法2：在递归中排序，在回溯中连接；sortList1()方法超时，因为选取head作为middle节点，
 *       极端情况会超时，递归深度变成n，时间复杂度变成O(n*n)
 */
public class Solution1 {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(head2));
    }

    private ListNode merge(ListNode node1, ListNode node2) {

        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;

        while (true) {

            if (node1 != null && node2 != null) {
                if (node1.val < node2.val) {
                    cur.next = node1;
                    cur = cur.next;
                    node1 = node1.next;
                } else {
                    cur.next = node2;
                    cur = cur.next;
                    node2 = node2.next;
                }
            } else if (node1 == null) {
                cur.next = node2;
                break;
            } else {
                cur.next = node1;
                break;
            }
        }

        return preHead.next;
    }

    public ListNode sortList1(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode smaller = null;
        ListNode curSmaller = null;
        ListNode larger = null;
        ListNode curLarger = null;

        ListNode middle = head;
        head = head.next;
        middle.next = null;

        while (head != null) {
            if (head.val > middle.val) {
                if (larger == null) {
                    larger = head;
                } else {
                    curLarger.next = head;
                }
                curLarger = head;
            } else {
                if (smaller == null) {
                    smaller = head;
                } else {
                    curSmaller.next = head;
                }
                curSmaller = head;
            }
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }

        ListNode sortedHead = null;
        if (smaller != null) {
            sortedHead = sortList1(smaller);
            ListNode cur = sortedHead;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = middle;
        } else {
            sortedHead = middle;
        }
        middle.next = sortList1(larger);

        return sortedHead;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
