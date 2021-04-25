package com.wangrollin.leetcode.n3_interview.problem04_10;

/**
 * 检查子树
 *
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * 注意：此题相对书上原题略有改动。
 *
 * 示例1:
 *  输入：t1 = [1, 2, 3], t2 = [2]
 *  输出：true
 *
 * 示例2:
 *  输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 *  输出：false
 *
 * 提示：
 * 树的节点数目范围为[0, 20000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-subtree-lcci
 *
 * Solution1
 *  用t1上的每个节点和t2做对比，看是否相等
 *  也可以先序列化，先序和中序，如果都是子字符串，就是子树
 */
public class Solution1 {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {

        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }

        if (checkCurNode(t1, t2)) {
            return true;
        } else {
            return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
        }
    }

    private boolean checkCurNode(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null && node2 != null || node1 != null && node2 == null || node1.val != node2.val) {
            return false;
        }

        return checkCurNode(node1.left, node2.left) && checkCurNode(node1.right, node2.right);
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
