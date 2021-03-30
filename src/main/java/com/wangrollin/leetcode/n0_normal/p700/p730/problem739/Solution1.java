package com.wangrollin.leetcode.n0_normal.p700.p730.problem739;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 每日温度
 *
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 *
 * 例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在[30, 100]范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 *
 * Solution1
 * 使用map存储需要找到更高天气的温度的坐标
 * 也可以使用单调栈，维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减
 */
public class Solution1 {

    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];
        Map<Integer, List<Integer>> history = new HashMap<>();
        for (int i = 30; i <= 100; i++) {
            history.put(i, new ArrayList<>());
        }

        for (int i = 0; i < T.length; i++) {

            history.get(T[i]).add(i);
            int rightDay = i;

            for (int j = 30; j < T[i]; j++) {

                List<Integer> indexes = history.get(j);
                indexes.forEach(index -> {
                    result[index] = rightDay - index;
                });
                indexes.clear();
            }
        }

        history.values().forEach(list ->
                list.forEach(index -> result[index] = 0)
        );

        return result;
    }
}
