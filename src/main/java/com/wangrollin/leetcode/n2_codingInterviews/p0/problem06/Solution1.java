package com.wangrollin.leetcode.n2_codingInterviews.p0.problem06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 *
 * Solution1
 * Collections.reverse
 */
public class Solution1 {

    public int[] reversePrint(ListNode head) {

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
