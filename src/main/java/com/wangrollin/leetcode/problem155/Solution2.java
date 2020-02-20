package com.wangrollin.leetcode.problem155;

import java.util.Stack;

/**
 * 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 示例:
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
 * 链接：https://leetcode-cn.com/problems/min-stack
 *
 * Solution2
 * 维护一个不同步的队列
 */
public class Solution2 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minValueStack = new Stack<>();

    public Solution2() {

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

    public int getMin() {
        return minValueStack.peek();
    }
}
