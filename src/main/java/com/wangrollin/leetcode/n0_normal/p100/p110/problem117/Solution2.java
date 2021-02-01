package com.wangrollin.leetcode.n0_normal.p100.p110.problem117;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针 II
 *
 * 给定一个二叉树
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * 示例：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 * 提示：
 * 树中的节点数小于 6000
 * -100<= node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 *
 * Solution2
 * 递归：遍历树的过程中将当前节点下面的next指针都建立了，深度优先，该方法要去求解当前节点下面左边最靠右的，右边最靠左的节点
 */
public class Solution2 {

    public Node connect(Node root) {

        travelTheTree(root);
        return root;
    }

    private void travelTheTree(Node node) {

        if (node == null) {
            return;
        }

        List<Node> rights = findLeftSideNodes(node);
        List<Node> lefts = findRightSideNodes(node);
        int min = Math.min(lefts.size(), rights.size());

        for (int i = 0; i < min; i++) {
            lefts.get(i).next = rights.get(i);
        }

        travelTheTree(node.left);
        travelTheTree(node.right);
    }

    private List<Node> findRightSideNodes(Node node) {

        List<Node> result = new ArrayList<>();

        if (node.left == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node.left);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node n = null;
            while (size > 0) {
                size--;
                n = queue.poll();
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            result.add(n);
        }

        return result;
    }

    private List<Node> findLeftSideNodes(Node node) {


        List<Node> result = new ArrayList<>();

        if (node.right == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node.right);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node n = null;
            while (size > 0) {
                size--;
                n = queue.poll();
                if (n.right != null) {
                    queue.add(n.right);
                }
                if (n.left != null) {
                    queue.add(n.left);
                }
            }
            result.add(n);
        }

        return result;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
