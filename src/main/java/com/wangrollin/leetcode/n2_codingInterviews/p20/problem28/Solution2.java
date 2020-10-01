package com.wangrollin.leetcode.n2_codingInterviews.p20.problem28;

import java.util.LinkedList;
import java.util.Queue;

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
 * Solution2
 * 广度优先遍历，BFS，迭代
 */
public class Solution2 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return checkLeftAndRight(root.left, root.right);
    }

    private boolean checkLeftAndRight(TreeNode left, TreeNode right) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(left);
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.add(right);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            } else {
                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.right);
                queue2.add(node2.left);
            }
        }

        return true;
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
