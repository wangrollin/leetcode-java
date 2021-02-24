package com.wangrollin.leetcode.n0_normal.p100.p160.problem169;

/**
 * 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 *
 * Solution1
 * 摩尔投票：火拼，最后留下的是属于大多数的
 * 也可以：hashmap统计次数，排序直捣中间值
 */
public class Solution1 {

    public int majorityElement(int[] nums) {

        int curNum = 0;
        int curNumCount = 0;

        for (int num : nums) {

            if (curNumCount == 0) {
                curNum = num;
                curNumCount++;
            } else {
                if (curNum == num) {
                    curNumCount++;
                } else {
                    curNumCount--;
                }
            }
        }

        return curNum;
    }
}
