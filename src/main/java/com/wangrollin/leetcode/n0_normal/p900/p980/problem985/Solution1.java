package com.wangrollin.leetcode.n0_normal.p900.p980.problem985;

/**
 * 查询后的偶数和
 *
 * 给出一个整数数组A和一个查询数组queries。
 * 对于第i次查询，有val =queries[i][0], index= queries[i][1]，我们会把val加到A[index]上。
 * 然后，第i次查询的答案是 A 中偶数值的和。
 * （此处给定的index = queries[i][1]是从 0 开始的索引，每次查询都会永久修改数组A。）
 * 返回所有查询的答案。你的答案应当以数组answer给出，answer[i]为第i次查询的答案。
 *
 * 示例：
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 *
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 *
 * Solution1
 * 算出初始的偶数和，然后没执行一次就跟新一次偶数和
 */
public class Solution1 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int curSum = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                curSum += i;
            }
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            if (A[queries[i][1]] % 2 == 0) {
                curSum -= A[queries[i][1]];
            }
            A[queries[i][1]] += queries[i][0];
            if (A[queries[i][1]] % 2 == 0) {
                curSum += A[queries[i][1]];
            }
            result[i] = curSum;
        }

        return result;
    }
}
