package com.wangrollin.leetcode.n0_normal.p200.p250.problem257;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 *
 * Solution2
 * 广度优先遍历，BFS，迭代
 */
public class Solution2 {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        Queue<String> pathQueue = new LinkedList<>();
        pathQueue.add(String.valueOf(root.val));

        while (!nodeQueue.isEmpty()) {

            TreeNode node = nodeQueue.poll();
            String curPath = pathQueue.poll();

            if (node.left == null && node.right == null) {
                result.add(curPath);
            } else {
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    pathQueue.add(curPath + "->" + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    pathQueue.add(curPath + "->" + node.right.val);
                }
            }
        }

        return result;
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
