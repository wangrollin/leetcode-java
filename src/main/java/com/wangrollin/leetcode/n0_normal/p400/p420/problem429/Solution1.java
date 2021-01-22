package com.wangrollin.leetcode.n0_normal.p400.p420.problem429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N 叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 *
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 * 提示：
 * 树的高度不会超过1000
 * 树的节点总数在 [0,10^4] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 *
 * Solution1
 * 迭代
 */
public class Solution1 {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> subResult = new ArrayList<>();

            while (size > 0) {
                size--;

                Node node = queue.poll();
                if (node != null) {
                    subResult.add(node.val);
                    queue.addAll(node.children);
                }
            }
            if (!subResult.isEmpty()) {
                result.add(subResult);
            }
        }

        return result;
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
