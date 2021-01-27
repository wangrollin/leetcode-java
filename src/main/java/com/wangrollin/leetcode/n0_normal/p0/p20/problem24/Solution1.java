package com.wangrollin.leetcode.n0_normal.p0.p20.problem24;

/**
 * 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * 
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 *
 * Solution1
 * 指针的操作，也可以用stack来反转两节点的顺序
 */
public class Solution1 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = new ListNode(0);
        ListNode result = preNode;
        ListNode curNode = head;

        while (true) {
            if (curNode == null || curNode.next == null) {
                preNode.next = curNode;
                break;
            } else {
                ListNode first = curNode;
                ListNode second = curNode.next;

                preNode.next = second;
                preNode = first;
                curNode = second.next;
                second.next = first;
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
