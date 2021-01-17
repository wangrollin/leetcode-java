package com.wangrollin.leetcode.n0_normal.p100.p140.problem145;

import java.util.*;

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
 * Solution2
 * 遍历
 */
public class Solution2 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root != null) {

            Stack<TreeNode> stack = new Stack<>();
            Set<TreeNode> set = new HashSet<>();
            stack.add(root);

            while (!stack.isEmpty()) {

                TreeNode node = stack.pop();

                if (!set.contains(node)) {
                    set.add(node);
                    stack.push(node);
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                } else {
                    set.remove(node);
                    result.add(node.val);
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
