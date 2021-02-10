package com.wangrollin.leetcode.n0_normal.p400.p440.problem445;

import java.util.Stack;

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
 * Solution2
 * 使用栈
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }

        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }

        ListNode result = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                carry += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                carry += stack2.pop();
            }

            ListNode temp = new ListNode(carry % 10);
            carry /= 10;
            temp.next = result;
            result = temp;
        }
        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            temp.next = result;
            result = temp;
        }
        return result;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
