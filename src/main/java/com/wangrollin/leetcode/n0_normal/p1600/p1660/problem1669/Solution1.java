package com.wangrollin.leetcode.n0_normal.p1600.p1660.problem1669;

/**
 * 合并两个链表
 *
 * 给你两个链表list1 和list2，它们包含的元素分别为n 个和m 个。
 * 请你将list1中第a个节点到第b个节点删除，并将list2接在被删除节点的位置。
 * 请你返回结果链表的头指针。
 *
 * 示例 1：
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 *
 * 示例 2：
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 *
 * 提示：
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
 *
 * Solution1
 * 寻找到相应的节点即可
 */
public class Solution1 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode leftNode = list1;
        ListNode rightNode = list1;
        for (int i = 0; i <= b; i++) {
            if (i < a - 1) {
                leftNode = leftNode.next;
            }
            rightNode = rightNode.next;
        }

        leftNode.next = list2;

        while (true) {
            if (list2.next == null) {
                break;
            }
            list2 = list2.next;
        }

        list2.next = rightNode;

        return list1;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
