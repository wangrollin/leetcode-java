package com.wangrollin.leetcode.n0_normal.p700.p780.problem783;

/**
 * 二叉搜索树节点最小距离
 *
 * 给定一个二叉搜索树的根节点root，返回树中任意两节点的差的最小值。
 *
 * 示例：
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * 
 * 注意：
 * 二叉树的大小范围在 2 到100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 *
 * Solution1
 * 递归，中序遍历，记录二叉搜索树中的preNode
 */
public class Solution1 {

    private int ans = 0;

    private TreeNode preNode = null;

    public int minDiffInBST(TreeNode root) {

        calMin(root);
        return ans;
    }

    private void calMin(TreeNode node) {

        if (node.left != null) {
            calMin(node.left);
        }

        if (preNode != null) {
            int diff = node.val - preNode.val;
            if (ans == 0 || diff < ans) {
                ans = diff;
            }
        }
        preNode = node;

        if (node.right != null) {
            calMin(node.right);
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
