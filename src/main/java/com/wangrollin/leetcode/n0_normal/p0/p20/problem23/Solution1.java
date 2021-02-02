package com.wangrollin.leetcode.n0_normal.p0.p20.problem23;

/**
 * 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 *
 * Solution1
 * 每次取出当前切面最小的
 * 也可以每次取两个list合并
 */
public class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = new ListNode(-1);
        ListNode cur = result;

        while (true) {

            ListNode nextNode = null;
            int nextNodeListIndex = 0;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (nextNode == null) {
                        nextNode = lists[i];
                        nextNodeListIndex = i;
                    } else if (nextNode.val > lists[i].val) {
                        nextNode = lists[i];
                        nextNodeListIndex = i;
                    }
                }
            }

            cur.next = nextNode;
            cur = cur.next;

            if (nextNode != null) {
                lists[nextNodeListIndex] = lists[nextNodeListIndex].next;
            } else {
                break;
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
