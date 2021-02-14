package com.wangrollin.leetcode.n0_normal.p800.p880.problem889;

/**
 * 根据前序和后序遍历构造二叉树
 *
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * pre和post遍历中的值是不同的正整数。
 *
 * 示例：
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 *
 * 提示：
 * 1 <= pre.length == post.length <= 30
 * pre[]和post[]都是1, 2, ..., pre.length的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 *
 * Solution1
 * 递归
 */
public class Solution1 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        if (pre == null || pre.length == 0) {
            return null;
        }

        return buildTree(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] postorder, int postLeft, int postRight) {

        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        } else if (preLeft > preRight) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preLeft]);

        int newPostRight = findIndex(postorder, postLeft, postRight, preorder[preLeft + 1]);

        node.left = buildTree(preorder, preLeft + 1, preLeft + 1 + newPostRight - postLeft,
                postorder, postLeft, newPostRight);

        node.right = buildTree(preorder, preLeft + newPostRight - postLeft + 2, preRight,
                postorder, newPostRight + 1, postRight - 1);

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
