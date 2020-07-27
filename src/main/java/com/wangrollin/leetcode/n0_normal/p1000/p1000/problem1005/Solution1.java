package com.wangrollin.leetcode.n0_normal.p1000.p1000.problem1005;

/**
 * K 次取反后最大化的数组和
 *
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，
 * 然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * 以这种方式修改数组后，返回数组可能的最大和。
 *
 * 示例 1：
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 *
 * 示例 2：
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 *
 * 示例 3：
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 *
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 *
 * Solution1
 * 可以排序，然后从后向前对于负数翻转，如果负数翻转完了，剩余次数%2==1，翻转最小的非负数
 * Solution2（最好）
 * 因为限制了范围，所以排序可以使用桶排序
 */
public class Solution1 {

    public int largestSumAfterKNegations(int[] A, int K) {

        int[] sorted = new int[201];

        int min = Integer.MAX_VALUE;
        for (int integer : A) {
            min = Math.min(min, Math.abs(integer));
            sorted[integer + 100]++;
        }

        int sum = 0;

        for (int i = 0; i < sorted.length; i++) {

            if (sorted[i] != 0) {
                if (K == 0) {
                    sum += (i - 100) * sorted[i];
                } else if (i >= 100) {
                    if (K % 2 == 1) {
                        // 如果绝对值的最小值所在是非正数
                        if (sorted[-1 * min + 100] != 0) {
                            sum -= 2 * min;
                            sum += (i - 100) * sorted[i];
                        } else {
                            sum += (i - 100) * (sorted[i] - 1) - (i - 100);
                        }
                    } else {
                        sum += (i - 100) * sorted[i];
                    }
                    K = 0;
                } else {
                    if (K >= sorted[i]) {
                        sum -= (i - 100) * sorted[i];
                        K -= sorted[i];
                    } else {
                        sum += (i - 100) * (sorted[i] - K);
                        sum -= (i - 100) * K;
                        K = 0;
                    }
                }
            }
        }

        return sum;
    }
}
