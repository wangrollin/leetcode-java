package com.wangrollin.leetcode.n0_normal.p1400.p1440.problem1448;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 统计二叉树中好节点的数目
 *
 * 给你一棵根为root的二叉树，请你返回二叉树中好节点的数目。
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 *
 * 示例 1：
 * 输入：root = [3,1,4,3,null,1,5]
 * 输出：4
 * 解释：图中蓝色节点为好节点。
 * 根节点 (3) 永远是个好节点。
 * 节点 4 -> (3,4) 是路径中的最大值。
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 *
 * 示例 2：
 * 输入：root = [3,3,null,4,2]
 * 输出：3
 * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 * 解释：根节点是好节点。
 *
 * 提示：
 * 二叉树中节点数目范围是[1, 10^5]。
 * 每个节点权值的范围是[-10^4, 10^4]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree
 *
 * Solution1
 * 使用数组记录上游的数值进行比较
 * 也可以直接传递当前分支curMax
 */
public class Solution1 {

    public int goodNodes(TreeNode root) {

        AtomicInteger cnt = new AtomicInteger(0);
        traverseTree(cnt, new Stack<>(), root);
        return cnt.intValue();
    }

    private void traverseTree(AtomicInteger cnt, Stack<Integer> curNums, TreeNode node) {

        if (node == null) {
            return;
        }

        if (curNums.stream().noneMatch(num -> num > node.val)) {
            cnt.incrementAndGet();
        }

        curNums.push(node.val);
        traverseTree(cnt, curNums, node.left);
        traverseTree(cnt, curNums, node.right);
        curNums.pop();
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
