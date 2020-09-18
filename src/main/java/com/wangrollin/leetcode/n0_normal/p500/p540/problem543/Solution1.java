package com.wangrollin.leetcode.n0_normal.p500.p540.problem543;

/**
 * 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 *
 * Solution1
 * 递归，回溯，后序遍历
 */
public class Solution1 {

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Pair<Integer, Integer> leftResult = cal(root.left);
        Pair<Integer, Integer> rightResult = cal(root.right);

        int innerD = Math.max(leftResult.getValue(), rightResult.getValue());
        return Math.max(innerD, leftResult.getKey() + rightResult.getKey() + 1) - 1;
    }

    private Pair<Integer, Integer> cal(TreeNode node) {

        // Pair第一个int代表高度，第二个代表内直径

        if (node == null) {
            return new Pair<>(0, 0);
        }

        Pair<Integer, Integer> leftResult = cal(node.left);
        Pair<Integer, Integer> rightResult = cal(node.right);

        int height = Math.max(leftResult.getKey(), rightResult.getKey()) + 1;
        int innerD = Math.max(leftResult.getValue(), rightResult.getValue());
        innerD = Math.max(innerD, leftResult.getKey() + rightResult.getKey() + 1);

        return new Pair<>(height, innerD);
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
