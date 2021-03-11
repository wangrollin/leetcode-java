package com.wangrollin.leetcode.n0_normal.p700.p700.problem707;

/**
 * 设计链表
 *
 * 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val和next。val是当前节点的值，next是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *  - get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
 *  - addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
 *  - addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
 *  - addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。
 *      如果index等于链表的长度，则该节点将附加到链表的末尾。
 *      如果 index 大于链表长度，则不会插入节点。
 *      如果index小于0，则在头部插入节点。
 *  - deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
 * 
 * 示例：
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 * 提示：
 * 所有val值都在[1, 1000]之内。
 * 操作次数将在[1, 1000]之内。
 * 请不要使用内置的 LinkedList 库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 *
 * Solution1
 * 单链表实现，没有使用pre占位节点，可以使用
 */
public class Solution1 {

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    private static class MyLinkedList {

        private ListNode head = null;
        private int size = 0;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {

        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {

            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = head;
            while (index != 0) {
                cur = cur.next;
                index--;
            }
            return cur.val;
        }

        /**
         * Add a node of value val before the first element of the linked list.
         * After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {

            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {

            if (size == 0) {
                head = new ListNode(val);
            } else {
                ListNode cur = head;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = new ListNode(val);
            }
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list.
         * If index equals to the length of linked list, the node will be appended to the end of linked list.
         * If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {

            if (index <= 0) {
                addAtHead(val);
            } else if (index > 0 && index <= size) {
                ListNode pre = head;
                while (index - 1 != 0) {
                    index--;
                    pre = pre.next;
                }
                ListNode newNode = new ListNode(val);
                newNode.next = pre.next;
                pre.next = newNode;
                size++;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {

            if (index >= 0 && index < size) {

                if (index == 0) {
                    head = head.next;
                } else {
                    ListNode pre = head;
                    while (index - 1 != 0) {
                        index--;
                        pre = pre.next;
                    }
                    pre.next = pre.next.next;
                }
                size--;
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
}
