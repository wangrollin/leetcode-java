package com.wangrollin.leetcode.n0_normal.p100.p140.problem145;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3 
 * 输出: [3,2,1]
 *
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 *
 * Solution1
 * 递归
 */
public class Solution1 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root != null) {
            backOrder(result, root);
        }
        return result;
    }

    private void backOrder(List<Integer> result, TreeNode node) {

        if (node.left != null) {
            backOrder(result, node.left);
        }
        if (node.right != null) {
            backOrder(result, node.right);
        }
        result.add(node.val);
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
