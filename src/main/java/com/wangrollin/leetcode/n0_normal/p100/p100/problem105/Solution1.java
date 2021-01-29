package com.wangrollin.leetcode.n0_normal.p100.p100.problem105;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 *
 * Solution1
 * 递归
 */
public class Solution1 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {

        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        } else if (preLeft > preRight) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preLeft]);

        int inMiddle = findIndex(inorder, inLeft, inRight, preorder[preLeft]);

        node.left = buildTree(preorder, preLeft + 1, preLeft + inMiddle - inLeft,
                inorder, inLeft, inMiddle - 1);

        node.right = buildTree(preorder, preLeft + inMiddle - inLeft + 1, preRight,
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
