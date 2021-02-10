package com.wangrollin.leetcode.n0_normal.p400.p440.problem445;

/**
 * 两数相加 II
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 *
 * Solution1
 * 先补齐前缀0，递归
 */
public class Solution1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        int len1 = calLen(l1);
        int len2 = calLen(l2);

        int diff = Math.abs(len1 - len2);
        if (diff != 0) {
            ListNode preZero = new ListNode(0);
            ListNode curZero = preZero;
            while (diff - 1 != 0) {
                curZero.next = new ListNode(0);
                curZero = curZero.next;
                diff--;
            }
            if (len1 < len2) {
                curZero.next = l1;
                l1 = preZero;
            } else {
                curZero.next = l2;
                l2 = preZero;
            }
        }


        Pair preResult = calTwoNumbers(l1, l2);
        if (preResult.carry != 0) {
            ListNode result = new ListNode(preResult.carry);
            result.next = preResult.node;
            return result;
        } else {
            return preResult.node;
        }
    }

    private Pair calTwoNumbers(ListNode node1, ListNode node2) {

        if (node1.next == null) {
            return Pair.of(new ListNode((node1.val + node2.val) % 10), (node1.val + node2.val) / 10);
        }

        Pair preResult = calTwoNumbers(node1.next, node2.next);
        ListNode curResult = new ListNode((node1.val + node2.val + preResult.carry) % 10);
        curResult.next = preResult.node;
        return Pair.of(curResult, (node1.val + node2.val + preResult.carry) / 10);
    }

    private int calLen(ListNode node) {

        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    private static class Pair {

        ListNode node;
        int carry;

        private Pair(ListNode node, int carry) {
            this.node = node;
            this.carry = carry;
        }

        public static Pair of(ListNode node, int carry) {
            return new Pair(node, carry);
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
