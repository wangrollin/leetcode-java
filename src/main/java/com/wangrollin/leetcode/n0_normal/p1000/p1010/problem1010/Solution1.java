package com.wangrollin.leetcode.n0_normal.p1000.p1010.problem1010;

import java.util.Arrays;

/**
 * 总持续时间可被 60 整除的歌曲
 *
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 * 示例 1：
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 *
 * 示例 2：
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 *  
 * 提示：
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
 *
 * Solution1
 * 最naive的方式是两两相加，但是会超时间；过一遍，把歌曲%60放到桶里，0和30的都是内部处理，k(k-1)/2，其他的互补，mn
 */
public class Solution1 {

    public int numPairsDivisibleBy60(int[] time) {

        int[] mode = new int[60];
        Arrays.stream(time).forEach(t -> mode[t % 60]++);

        int result = 0;
        result += mode[0] * (mode[0] - 1) / 2 + mode[30] * (mode[30] - 1) / 2;

        for (int i = 1; i <= 29; i++) {
            result += mode[i] * mode[60 - i];
        }

        return result;
    }
}
