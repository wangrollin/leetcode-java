package com.wangrollin.leetcode.n0_normal.p900.p990.problem997;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 找到小镇的法官
 *
 * 在一个小镇里，按从 1 到 N 标记了N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * 如果小镇的法官真的存在，那么：
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组trust，该数组由信任对 trust[i] = [a, b]组成，表示标记为 a 的人信任标记为 b 的人。
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *
 * 示例 1：
 * 输入：N = 2, trust = [[1,2]]
 * 输出：2
 *
 * 示例 2：
 * 输入：N = 3, trust = [[1,3],[2,3]]
 * 输出：3
 *
 * 示例 3：
 * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 *
 * 示例 4：
 * 输入：N = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 *
 * 示例 5：
 * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 * 
 * 提示：
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i]是完全不同的
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-town-judge
 *
 * Solution1
 * 遍历一遍trust，找到信任和被信任set，然后遍历一遍人，找到符合条件的
 */
public class Solution1 {

    public int findJudge(int N, int[][] trust) {

        if (N == 1) {
            return 1;
        }

        Map<Integer, Set<Integer>> trusted = new HashMap<>();
        Map<Integer, Set<Integer>> beTrusted = new HashMap<>();

        for (int[] oneTrust : trust) {

            trusted.compute(oneTrust[0], (k, v) -> {
                if (v == null) {
                    Set<Integer> set = new HashSet<>();
                    set.add(oneTrust[1]);
                    return set;
                } else {
                    v.add(oneTrust[1]);
                    return v;
                }
            });

            beTrusted.compute(oneTrust[1], (k, v) -> {
                if (v == null) {
                    Set<Integer> set = new HashSet<>();
                    set.add(oneTrust[0]);
                    return set;
                } else {
                    v.add(oneTrust[0]);
                    return v;
                }
            });
        }

        int cnt = 0;
        int judge = -1;
        for (int i = 1; i <= N; i++) {
            if (!trusted.containsKey(i) && beTrusted.containsKey(i) && beTrusted.get(i).size() == N - 1) {
                cnt++;
                judge = i;
                if (cnt > 1) {
                    return -1;
                }
            }
        }
        return judge;
    }
}
