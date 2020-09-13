package com.wangrollin.leetcode.n0_normal.p500.p590.problem590;

import java.util.ArrayList;
import java.util.List;

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
 * Solution1
 * 深度优先遍历，DFS，递归
 */
public class Solution1 {

    public List<Integer> postorder(Node root) {

        List<Integer> result = new ArrayList<>();
        doPostorder(root, result);
        return result;
    }

    private void doPostorder(Node node, List<Integer> result) {

        if (node == null) {
            return;
        }
        node.children.forEach(child -> doPostorder(child, result));
        result.add(node.val);
    }

    private static class Node {

        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
