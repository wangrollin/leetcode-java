package com.wangrollin.leetcode.n0_normal.p500.p550.problem559;

import java.util.List;

/**
 * N叉树的最大深度
 *
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 说明:
 * 树的深度不会超过1000。
 * 树的节点总不会超过5000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 *
 * Solution1
 * 递归，后序遍历
 */
public class Solution1 {

    public int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        return root
                .children
                .stream()
                .mapToInt(this::maxDepth)
                .max()
                .orElse(0) + 1;
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
