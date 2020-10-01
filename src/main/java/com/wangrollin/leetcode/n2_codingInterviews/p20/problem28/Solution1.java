package com.wangrollin.leetcode.n2_codingInterviews.p20.problem28;

/**
 * 对称的二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 *   1
 *  / \
 *  2  2
 * / \ / \
 * 3 4 4 3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *   1
 *  / \
 *  2  2
 *  \  \
 *  3  3
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 *
 * Solution1
 * 深度优先遍历，DFS，递归
 */
public class Solution1 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return checkLeftAndRight(root.left, root.right);
    }

    private boolean checkLeftAndRight(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null || left.val != right.val) {
            return false;
        } else {
            return checkLeftAndRight(left.left, right.right)
                    && checkLeftAndRight(left.right, right.left);
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
