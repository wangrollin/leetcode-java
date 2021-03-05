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
 * Solution2
 * 使用迭代进行自下而上的归并排序，从而摆脱递归调用栈的空间占用
 */
public class Solution2 {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int subLen = 1;
        while (true) {

            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode node1 = pre.next;
            ListNode node2 = nextN(node1, subLen);
            if (node2 == null) {
                return node1;
            }
            nextN(node1, subLen - 1).next = null;
            ListNode last = nextN(node2, subLen);
            ListNode node2Tail = nextN(node2, subLen - 1);
            if (node2Tail != null) {
                node2Tail.next = null;
            }

            head = null;

            while (true) {
                ListNode result = merge(node1, node2);
                if (head == null) {
                    head = result;
                }
                pre.next = result;
                ListNode tail = getTail(result);
                tail.next = last;
                if (last == null) {
                    break;
                }

                pre = tail;
                node1 = last;
                node2 = nextN(node1, subLen);
                if (node2 == null) {
                    break;
                }

                last = nextN(node2, subLen);
                nextN(node1, subLen - 1).next = null;
                node2Tail = nextN(node2, subLen - 1);
                if (node2Tail != null) {
                    node2Tail.next = null;
                }
            }
            subLen *= 2;
        }
    }

    private ListNode getTail(ListNode node) {

        if (node == null) {
            return null;
        }
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    private ListNode nextN(ListNode node, int step) {

        while (step-- != 0) {
            node = node.next;
            if (node == null) {
                return null;
            }
        }
        return node;
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

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
