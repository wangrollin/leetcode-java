package com.wangrollin.leetcode.n0_normal.p600.p650.problem654;

/**
 * 最大二叉树
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *  - 二叉树的根是数组中的最大元素。
 *  - 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 *  - 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 *
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * 示例 ：
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * 提示：
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 *
 * Solution1
 * 递归，很简单
 */
public class Solution1 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int nums[], int start, int end) {

        int mid = findIndexOfMax(nums, start, end);
        TreeNode node = new TreeNode(nums[mid]);
        if (mid > start) {
            node.left = buildTree(nums, start, mid - 1);
        }
        if (mid < end) {
            node.right = buildTree(nums, mid + 1, end);
        }
        return node;
    }

    private int findIndexOfMax(int[] nums, int startIndex, int endIndex) {

        int index = startIndex;
        int max = nums[startIndex];
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
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
