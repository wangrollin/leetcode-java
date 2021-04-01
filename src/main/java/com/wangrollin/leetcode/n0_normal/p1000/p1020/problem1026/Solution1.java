package com.wangrollin.leetcode.n0_normal.p1000.p1020.problem1026;

import java.util.ArrayList;
import java.util.List;

/**
 * 节点与其祖先之间的最大差值
 *
 * 给定二叉树的根节点root，找出存在于 不同 节点A 和B之间的最大值 V，其中V = |A.val - B.val|，且A是B的祖先。
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 * 示例 1：
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *
 * 示例 2：
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 *
 * 提示：
 * 树中的节点数在2到5000之间。
 * 0 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor
 *
 * Solution1
 * 回溯时候判断
 * 也可以递归时判断
 */
public class Solution1 {

    public int maxAncestorDiff(TreeNode root) {

        int[] result = new int[1];
        getMaxMinValue(result, root);
        return result[0];
    }

    private int[] getMaxMinValue(int[] result, TreeNode node) {

        List<Integer> vals = new ArrayList<>();
        vals.add(node.val);

        int[] maxMinValues;
        if (node.left != null) {
            maxMinValues = getMaxMinValue(result, node.left);
            result[0] = Math.max(result[0], Math.abs(maxMinValues[0] - node.val));
            result[0] = Math.max(result[0], Math.abs(maxMinValues[1] - node.val));
            vals.add(maxMinValues[0]);
            vals.add(maxMinValues[1]);
        }
        if (node.right != null) {
            maxMinValues = getMaxMinValue(result, node.right);
            result[0] = Math.max(result[0], Math.abs(maxMinValues[0] - node.val));
            result[0] = Math.max(result[0], Math.abs(maxMinValues[1] - node.val));
            vals.add(maxMinValues[0]);
            vals.add(maxMinValues[1]);
        }

        return new int[]{vals.stream().mapToInt(i -> i).max().getAsInt(),
                vals.stream().mapToInt(i -> i).min().getAsInt()};
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
