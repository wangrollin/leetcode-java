package com.wangrollin.leetcode.n0_normal.p1300.p1300.problem1305;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 两棵二叉搜索树中的所有元素
 *
 * 给你root1 和 root2这两棵二叉搜索树。
 * 请你返回一个列表，其中包含两棵树中的所有整数并按 升序 排序。.
 *
 * 示例 1：
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 *
 * 示例 2：
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 *
 * 示例 3：
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 *
 * 示例 4：
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 *
 * 示例 5：
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 *
 * 提示：
 * 每棵树最多有5000个节点。
 * 每个节点的值在[-10^5, 10^5]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
 *
 * Solution1
 * 两个有序数组归并排序
 */
public class Solution1 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        Queue<Integer> q1 = new LinkedList<>();
        fillOrderedArr(q1, root1);
        Queue<Integer> q2 = new LinkedList<>();
        fillOrderedArr(q2, root2);

        List<Integer> result = new ArrayList<>(q1.size() + q2.size());

        while (true) {

            if (q1.isEmpty()) {
                result.addAll(q2);
                break;
            } else if (q2.isEmpty()) {
                result.addAll(q1);
                break;
            } else if (q1.peek() < q2.peek()) {
                result.add(q1.poll());
            } else {
                result.add(q2.poll());
            }
        }

        return result;
    }

    private void fillOrderedArr(Queue<Integer> queue, TreeNode node) {

        if (node == null) {
            return;
        }
        fillOrderedArr(queue, node.left);
        queue.add(node.val);
        fillOrderedArr(queue, node.right);
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
