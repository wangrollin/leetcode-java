package com.wangrollin.leetcode.n2_codingInterviews.p30.problem39;

/**
 * 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 限制：
 * 1 <= 数组长度 <= 50000
 *
 * 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
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
