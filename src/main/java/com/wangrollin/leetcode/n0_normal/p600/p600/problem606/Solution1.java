package com.wangrollin.leetcode.n0_normal.p600.p600.problem606;

/**
 * 根据二叉树创建字符串
 *
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。
 * 而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 * 输出: "1(2(4))(3)"
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 *
 * 示例 2:
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 * 输出: "1(2()(4))(3)"
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 *
 * Solution1
 * 递归，回溯，前序遍历
 */
public class Solution1 {

    public String tree2str(TreeNode t) {

        if (t == null) {
            return "";
        }

        if (t.right == null && t.left == null) {
            return String.valueOf(t.val);
        } else if (t.right != null && t.left != null) {
            return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        } else if (t.right == null && t.left != null) {
            return t.val + "(" + tree2str(t.left) + ")";
        } else {
            return t.val + "()(" + tree2str(t.right) + ")";
        }
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
