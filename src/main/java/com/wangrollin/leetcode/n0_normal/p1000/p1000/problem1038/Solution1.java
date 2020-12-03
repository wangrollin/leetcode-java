package com.wangrollin.leetcode.n0_normal.p1000.p1000.problem1038;

/**
 * 把二叉搜索树转换为累加树
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *  - 节点的左子树仅包含键 小于 节点键的节点。
 *  - 节点的右子树仅包含键 大于 节点键的节点。
 *  - 左右子树也必须是二叉搜索树。
 *
 * 注意：该题目与 538:https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ 相同
 *
 * 示例 1：
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * 示例 2：
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 *
 * 示例 3：
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 *
 * 示例 4：
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 *
 * 提示：
 *  - 树中的节点数介于 1 和 100 之间。
 *  - 每个节点的值介于0 和100之间。
 *  - 树中的所有值 互不相同 。
 *  - 给定的树为二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 *
 * Solution1
 * 右-中-左 遍历，强行不使用全局变量
 */
public class Solution1 {

    public TreeNode bstToGst(TreeNode root) {

        if (root == null) {
            return null;
        }

        calc(root, 0);
        return root;
    }

    private int calc(TreeNode node, int curSum) {

        int rightSum = curSum;
        if (node.right != null) {
            rightSum = calc(node.right, curSum);
        }

        node.val += rightSum;

        if (node.left != null) {
            return calc(node.left, node.val);
        } else {
            return node.val;
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
