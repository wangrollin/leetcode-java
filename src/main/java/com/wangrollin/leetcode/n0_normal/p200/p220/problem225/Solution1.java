package com.wangrollin.leetcode.n0_normal.p200.p220.problem225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * 使用队列实现栈的下列操作：
 * - push(x) -- 元素 x 入栈
 * - pop() -- 移除栈顶元素
 * - top() -- 获取栈顶元素
 * - empty() -- 返回栈是否为空
 *
 * 注意:
 * 你只能使用队列的基本操作-- 也就是push to back, peek/pop from front, size, 和is empty这些操作是合法的。
 * 你所使用的语言也许不支持队列。你可以使用 list 或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 *
 * Solution1
 * 每次放入都整理一遍顺序
 */
public class Solution1 {

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    class MyStack {

        Queue<Integer> queue = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {

            int size = queue.size();
            queue.add(x);
            for (int i = 0; i < size; i++) {
                queue.add(queue.remove());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {

            return queue.remove();
        }

        /**
         * Get the top element.
         */
        public int top() {

            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {

            return queue.isEmpty();
        }
    }
}
