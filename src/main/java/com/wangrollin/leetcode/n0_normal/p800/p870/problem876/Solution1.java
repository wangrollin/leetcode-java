package com.wangrollin.leetcode.n0_normal.p800.p870.problem876;

/**
 * 链表的中间结点
 *
 * 给定一个带有头结点head的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 *
 * 示例2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * 
 * 提示：
 * 给定链表的结点数介于1和100之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 *
 * Solution1
 * 遍历两遍
 */
public class Solution1 {

    public ListNode middleNode(ListNode head) {

        int len = 1;
        ListNode countNode = head;
        while ((countNode = countNode.next) != null) {
            len++;
        }
        for (int i = 0; i < len / 2; i++) {
            head = head.next;
        }
        return head;
    }
}
