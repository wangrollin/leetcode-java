package com.wangrollin.leetcode.problem2;

/**
 * 两数相加
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字0之外，这两个数都不会以0开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * Solution1
 * 要小心溢出，所以不用int long，用链表
 */
public class Solution1 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int num1 = 0;
        int num2 = 0;
        ListNode result = null;
        ListNode curRlt = null;
        while (node1 != null || node2 != null || carry != 0) {
            if (node1 != null) {
                num1 = node1.val;
                node1 = node1.next;
            } else {
                num1 = 0;
            }
            if (node2 != null) {
                num2 = node2.val;
                node2 = node2.next;
            } else {
                num2 = 0;
            }
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            if (result == null) {
                result = new ListNode(sum % 10);
                curRlt = result;
            } else {
                curRlt.next = new ListNode(sum % 10);
                curRlt = curRlt.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }

}
