package com.wangrollin.leetcode.n0_normal.p500.p560.problem563;

/**
 * 二叉树的坡度
 *
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。
 * 空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 示例：
 * 输入：
 *          1
 *        /   \
 *       2     3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *
 * 提示：
 * 任何子树的结点的和不会超过 32 位整数的范围。
 * 坡度的值不会超过 32 位整数的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 *
 * Solution1
 * 递归，回溯，后序遍历
 */
public class Solution1 {

    public int findTilt(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Pair<Integer, Integer> leftResult = cal(root.left);
        Pair<Integer, Integer> rightResult = cal(root.right);

        return Math.abs(leftResult.getValue() - rightResult.getValue())
                + leftResult.getKey()
                + rightResult.getKey();
    }

    public Pair<Integer, Integer> cal(TreeNode node) {

        // key: 坡度，value: 节点之和
        if (node == null) {
            return new Pair<>(0, 0);
        }

        Pair<Integer, Integer> leftResult = cal(node.left);
        Pair<Integer, Integer> rightResult = cal(node.right);

        int tilt = Math.abs(leftResult.getValue() - rightResult.getValue())
                + leftResult.getKey()
                + rightResult.getKey();
        int sum = leftResult.getValue() + rightResult.getValue() + node.val;
        return new Pair<>(tilt, sum);
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Pair<K, V> {

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
