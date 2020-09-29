package com.wangrollin.leetcode.n0_normal.p900.p990.problem993;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * 提示：
 * 二叉树的节点数介于2 到100之间。
 * 每个节点的值都是唯一的、范围为1 到100的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 *
 * Solution2
 * 迭代
 */
public class Solution2 {

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            if (queue
                    .stream()
                    .filter(treeNode ->
                            treeNode.left != null && treeNode.right != null
                                    && (treeNode.left.val == x && treeNode.right.val == y ||
                                    treeNode.left.val == y && treeNode.right.val == x)
                    )
                    .count() != 0) {

                return false;
            }

            int size = queue.size();

            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }

            List<Integer> vals = new ArrayList<>();
            queue.forEach(treeNode -> vals.add(treeNode.val));
            if (vals.contains(x)) {
                return vals.contains(y);
            } else if (vals.contains(y)) {
                return false;
            }
        }

        return false;
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
