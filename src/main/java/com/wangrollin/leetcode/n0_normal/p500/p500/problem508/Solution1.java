package com.wangrollin.leetcode.n0_normal.p500.p500.problem508;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 出现次数最多的子树元素和
 *
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。
 * 一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 示例 1：
 * 输入:
 *   5
 *  /  \
 * 2   -3
 * 返回[2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例2：
 * 输入：
 *   5
 *  /  \
 * 2   -5
 * 返回[2]，只有 2 出现两次，-5 只出现 1 次。
 *
 * 提示：假设任意子树元素和均可以用 32 位有符号整数表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 *
 * Solution1
 * 递归找出所有，然后找到频率最高的
 */
public class Solution1 {

    public int[] findFrequentTreeSum(TreeNode root) {

        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> counter = new HashMap<>();
        getSum(counter, root);

        int maxCount = counter.values()
                .stream()
                .max(Comparator.comparingInt(i -> i))
                .get();

        return counter.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxCount)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private int getSum(Map<Integer, Integer> counter, TreeNode node) {

        if (node == null) {
            return 0;
        }

        int sum = node.val + getSum(counter, node.left) + getSum(counter, node.right);
        counter.put(sum, counter.getOrDefault(sum, 0) + 1);
        return sum;
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
