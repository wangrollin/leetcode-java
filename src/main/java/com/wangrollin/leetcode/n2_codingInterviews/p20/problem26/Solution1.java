package com.wangrollin.leetcode.n2_codingInterviews.p20.problem26;

/**
 * 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *   3
 *   / \
 *  4  5
 *  / \
 * 1  2
 * 给定的树 B：
 *  4
 *  /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 限制：
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 *
 * Solution1
 * 判断每一个节点作为root的情况
 */
public class Solution1 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }

        return isSubStructureInHere(A, B)
                || isSubStructure(A.left, B)
                || isSubStructure(A.right, B);
    }

    private boolean isSubStructureInHere(TreeNode A, TreeNode B) {

        if (A.val == B.val) {

            if (A.left == null && B.left != null || A.right == null && B.right != null) {

                return false;

            } else if (A.left != null && B.left != null && A.right != null && B.right != null) {

                return isSubStructureInHere(A.left, B.left) && isSubStructureInHere(A.right, B.right);

            } else if (A.left != null && B.left != null) {

                return isSubStructureInHere(A.left, B.left);

            } else if (A.right != null && B.right != null) {

                return isSubStructureInHere(A.right, B.right);

            } else {
                return true;
            }
        } else {
            return false;
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
