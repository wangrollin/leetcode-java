package com.wangrollin.leetcode.n3_interview.problem03_02;

import java.util.Stack;

/**
 * 栈的最小值
 *
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，
 * 该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 * 示例：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 *
 * Solution1
 * 双栈，一个普通栈，一个min栈
 */
public class Solution1 {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    class MinStack {

        private Stack<Integer> stack = new Stack<>();

        private Stack<Integer> minStack = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {

            stack.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {

            if (!stack.isEmpty() && minStack.peek().equals(stack.pop())) {
                minStack.pop();
            }
        }

        public int top() {

            return stack.peek();
        }

        public int getMin() {

            return minStack.peek();
        }
    }
}
