package com.wangrollin.leetcode.n2_codingInterviews.p0.problem09;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 *
 * Solution1
 * 双栈，tailStack ｜ headStack
 */
public class Solution1 {

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    class CQueue {

        private Stack<Integer> tailStack = new Stack<>();

        private Stack<Integer> headStack = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {

            tailStack.push(value);
        }

        public int deleteHead() {

            if (headStack.isEmpty()) {
                if (tailStack.isEmpty()) {
                    return -1;
                } else {
                    while (!tailStack.isEmpty()) {
                        headStack.push(tailStack.pop());
                    }
                }
            }

            return headStack.pop();
        }
    }
}
