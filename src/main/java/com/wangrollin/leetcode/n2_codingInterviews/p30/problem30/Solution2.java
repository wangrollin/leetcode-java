package com.wangrollin.leetcode.n2_codingInterviews.p30.problem30;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 *
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 *
 * Solution2
 * 维护一个不同步的队列
 */
public class Solution2 {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
    private static class MinStack {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minValueStack = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (minValueStack.isEmpty()) {
                stack.push(x);
                minValueStack.push(x);
            } else {
                stack.push(x);
                if(x<=minValueStack.peek()) {
                    minValueStack.push(x);
                }
            }
        }

        public void pop() {
            int value = stack.pop();
            if(value == minValueStack.peek()) {
                minValueStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minValueStack.peek();
        }
    }
}
