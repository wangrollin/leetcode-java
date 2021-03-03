package com.wangrollin.leetcode.n0_normal.p100.p140.problem144;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的前序遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 *
 * Solution1
 * 递归
 */
public class Solution1 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        preorder(result, root);
        return result;
    }

    public void preorder(List<Integer> result, TreeNode node) {

        if (node == null) {
            return;
        }

        result.add(node.val);
        preorder(result, node.left);
        preorder(result, node.right);
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
