package com.wangrollin.leetcode.n0_normal.p100.p100.problem106;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 *
 * Solution1
 * 递归
 */
public class Solution1 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || inorder.length == 0) {
            return null;
        }

        return buildTree(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight, int[] inorder, int inLeft, int inRight) {

        if (postLeft == postRight) {
            return new TreeNode(postorder[postLeft]);
        } else if (postLeft > postRight) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postRight]);

        int inMiddle = findIndex(inorder, inLeft, inRight, postorder[postRight]);

        node.left = buildTree(postorder, postLeft, postLeft + inMiddle - inLeft - 1,
                inorder, inLeft, inMiddle - 1);

        node.right = buildTree(postorder, postLeft + inMiddle - inLeft, postRight - 1,
                inorder, inMiddle + 1, inRight);

        return node;
    }

    private int findIndex(int[] arr, int left, int right, int target) {

        for (int i = left; i <= right; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
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
