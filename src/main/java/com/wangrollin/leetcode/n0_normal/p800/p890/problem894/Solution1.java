package com.wangrollin.leetcode.n0_normal.p800.p890.problem894;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 所有可能的满二叉树
 *
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * 答案中每个树的每个结点都必须有 node.val=0。
 * 你可以按任何顺序返回树的最终列表。
 *
 * 示例：
 * 输入：7
 * 输出：
 * [[0,0,0,null,null,0,0,null,null,0,0],
 * [0,0,0,null,null,0,0,0,0],
 * [0,0,0,0,0,0,0],
 * [0,0,0,0,0,null,null,null,null,0,0],
 * [0,0,0,0,0,null,null,0,0]]
 *
 * 提示：
 * 1 <= N <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 *
 * Solution1
 * 递归，动态规划，保留过程结果
 */
public class Solution1 {

    public List<TreeNode> allPossibleFBT(int N) {

        if (N % 2 == 0) {
            return new ArrayList<>();
        }
        return calAllTree(new HashMap<>(), N / 2);
    }

    public List<TreeNode> calAllTree(Map<Integer, List<TreeNode>> knownResult, int totalNum) {

        if (totalNum == 0) {
            return Collections.singletonList(new TreeNode(0));
        }

        if (!knownResult.containsKey(totalNum)) {

            List<TreeNode> result = new ArrayList<>();

            for (int i = 0; i < totalNum; i++) {

                List<TreeNode> leftAllPossibleChildren = calAllTree(knownResult, i);
                List<TreeNode> rightAllPossibleChildren = calAllTree(knownResult, totalNum - 1 - i);

                leftAllPossibleChildren.forEach(leftChild -> {
                    rightAllPossibleChildren.forEach(rightChild -> {
                        TreeNode root = new TreeNode(0);
                        root.left = copyTree(leftChild);
                        root.right = copyTree(rightChild);
                        result.add(root);
                    });
                });
            }

            knownResult.put(totalNum, result);
        }

        return knownResult.get(totalNum)
                .stream()
                .map(this::copyTree)
                .collect(Collectors.toList());
    }

    public TreeNode copyTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> originQueue = new LinkedList<>();
        originQueue.add(root);

        Queue<TreeNode> clonedQueue = new LinkedList<>();
        TreeNode result = new TreeNode(root.val);
        clonedQueue.add(result);

        while (!originQueue.isEmpty()) {
            TreeNode originNode = originQueue.poll();
            TreeNode clonedNode = clonedQueue.poll();

            if (originNode.left != null) {
                clonedNode.left = new TreeNode(originNode.left.val);
                originQueue.add(originNode.left);
                clonedQueue.add(clonedNode.left);
            }
            if (originNode.right != null) {
                clonedNode.right = new TreeNode(originNode.right.val);
                originQueue.add(originNode.right);
                clonedQueue.add(clonedNode.right);
            }
        }

        return result;
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
