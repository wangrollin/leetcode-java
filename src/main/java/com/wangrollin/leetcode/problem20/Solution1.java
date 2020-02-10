package com.wangrollin.leetcode.problem20;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 * Solution1
 * 用栈来匹配，提前终止的条件：长度为奇数、栈的高度大于长度的一半
 */
public class Solution1 {

    public static boolean isAPair(Character a, Character b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }

    public static boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }

        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        int maxStackSize = len / 2;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(' ||s.charAt(i) == '['||s.charAt(i) == '{'){
                if(stack.size() == maxStackSize) {
                    return false;
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                if(stack.size() == 0 || !isAPair(stack.pop(), s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
