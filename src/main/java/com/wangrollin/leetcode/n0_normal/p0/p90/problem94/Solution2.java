package com.wangrollin.leetcode.n0_normal.p0.p90.problem94;

import java.util.*;

/**
 * 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
 * 输出：[2,1]
 *
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 *
 * Solution2
 * 迭代
 */
public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.peek();

            if (!set.contains(node)) {
                set.add(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                stack.pop();
                set.remove(node);
                result.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
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
