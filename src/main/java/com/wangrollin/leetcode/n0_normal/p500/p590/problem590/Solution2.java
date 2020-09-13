package com.wangrollin.leetcode.n0_normal.p500.p590.problem590;

import java.util.*;

/**
 * N叉树的后序遍历
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 说明:递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 *
 * Solution2
 * 广度优先遍历，BFS，迭代；也可以先用类似全序遍历的方式得到result，然后reverse就是后序遍历
 */
public class Solution2 {

    public List<Integer> postorder(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        Set<Node> set = new HashSet<>();

        while (!stack.isEmpty()) {

            Node node = stack.peek();
            if (set.contains(node)) {
                set.remove(node);
                stack.pop();
                result.add(node.val);
            } else {
                set.add(node);
                Collections.reverse(node.children);
                node.children.forEach(stack::push);
            }
        }

        return result;
    }

    private static class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
