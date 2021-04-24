package com.wangrollin.leetcode.n3_interview.problem04_08;

/**
 * 首个共同祖先
 *
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
 *     3
 *    / \
 *   5   1
 *  / \ / \
 * 6  2 0  8
 *   / \
 *  7   4
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-common-ancestor-lcci
 *
 * Solution1
 * 可以DFS进行比较
 * 也可以遍历的时候记录上游的节点，遇到目标节点就保存一份，然后对比两个数组
 */
public class Solution1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode[] result = new TreeNode[1];
        findTargetValue(result, root, p.val, q.val);
        return result[0];
    }

    private int findTargetValue(TreeNode[] result, TreeNode node, int pNum, int qNum) {

        if (node == null) {
            return 0;
        }

        int left = findTargetValue(result, node.left, pNum, qNum);
        if (left == -1) {
            return -1;
        } else if (left == 1 && (node.val == pNum || node.val == qNum)) {
            result[0] = node;
            return -1;
        }

        int right = findTargetValue(result, node.right, pNum, qNum);
        if (right == -1) {
            return -1;
        } else if (right == 1) {
            if ((node.val == pNum || node.val == qNum) || left == 1) {
                result[0] = node;
                return -1;
            }
        }

        if (node.val == pNum || node.val == qNum) {
            return 1;
        } else {
            return left + right;
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
