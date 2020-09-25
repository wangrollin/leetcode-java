package com.wangrollin.leetcode.n0_normal.p800.p890.problem897;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增顺序查找树
 *
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * 示例 ：
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 * /        / \
 * 1        7   9
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *  1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *            \
 *             7
 *              \
 *               8
 *                \
 *                  9
 *
 * 提示：
 * 给定树中的结点数介于 1 和100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 *
 * Solution2
 * 放在数组里，然后连接
 */
public class Solution2 {

    public TreeNode increasingBST(TreeNode root) {

        List<TreeNode> nodes = new ArrayList<>();
        addToList(root, nodes);

        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i + 1);
        }
        nodes.get(nodes.size() - 1).left = null;

        return nodes.get(0);
    }

    private void addToList(TreeNode node, List<TreeNode> nodes) {

        if (node.left != null) {
            addToList(node.left, nodes);
        }
        nodes.add(node);
        if (node.right != null) {
            addToList(node.right, nodes);
        }
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
