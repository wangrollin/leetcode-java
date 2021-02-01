package com.wangrollin.leetcode.n0_normal.p100.p110.problem117;

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
 * Solution1
 * 迭代：使用已经建立好的next指针，广度优先
 * 也可以使用：层级遍历
 */
public class Solution1 {

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node curNode = findNextNodeWithChild(root);

        Node nextLevelFist = null;

        if (curNode != null) {
            if (curNode.left != null) {
                nextLevelFist = curNode.left;
            } else {
                nextLevelFist = curNode.right;
            }
        }

        while (nextLevelFist != null) {

            Node curChild = nextLevelFist;

            while (curNode != null) {

                if (curChild == curNode.left && curNode.right != null) {
                    curChild.next = curNode.right;
                    curChild = curNode.right;
                }

                curNode = findNextNodeWithChild(curNode.next);
                if (curNode != null) {
                    if (curNode.left != null) {
                        curChild.next = curNode.left;
                        curChild = curNode.left;
                    } else {
                        curChild.next = curNode.right;
                        curChild = curNode.right;
                    }
                }
            }

            curNode = findNextNodeWithChild(nextLevelFist);
            nextLevelFist = null;

            if (curNode != null) {
                if (curNode.left != null) {
                    nextLevelFist = curNode.left;
                } else {
                    nextLevelFist = curNode.right;
                }
            }
        }

        return root;
    }

    private Node findNextNodeWithChild(Node curNode) {

        while (curNode != null) {

            if (curNode.left != null || curNode.right != null) {
                return curNode;
            }
            curNode = curNode.next;
        }

        return null;
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
