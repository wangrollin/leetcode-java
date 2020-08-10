package com.wangrollin.leetcode.n2_codingInterviews.p20.problem21;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 *
 * Solution1
 * 双指针相向遍历（首尾双指针）；另一种方法：快慢双指针
 */
public class Solution1 {

    public int[] exchange(int[] nums) {

        int oddIndex = 0;
        int evenIndex = nums.length - 1;

        while (oddIndex < evenIndex) {
            if (nums[oddIndex] % 2 == 1) {
                oddIndex++;
                continue;
            }
            if (nums[evenIndex] % 2 == 0) {
                evenIndex--;
                continue;
            }
            int temp = nums[oddIndex];
            nums[oddIndex] = nums[evenIndex];
            nums[evenIndex] = temp;
            oddIndex++;
            evenIndex--;
        }

        return nums;
    }
}
