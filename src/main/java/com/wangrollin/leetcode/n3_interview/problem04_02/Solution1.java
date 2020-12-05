package com.wangrollin.leetcode.n3_interview.problem04_02;

/**
 * 最小高度树
 *
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
 *
 * Solution1
 * 递归生成
 */
public class Solution1 {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        return generateTree(nums, 0, nums.length - 1);
    }

    public TreeNode generateTree(int[] nums, int startIndex, int endIndex) {

        int midIndex = (startIndex + endIndex) / 2;
        TreeNode node = new TreeNode(nums[midIndex]);

        if (midIndex > startIndex) {
            node.left = generateTree(nums, startIndex, midIndex - 1);
        }

        if (midIndex < endIndex) {
            node.right = generateTree(nums, midIndex + 1, endIndex);
        }

        return node;
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
