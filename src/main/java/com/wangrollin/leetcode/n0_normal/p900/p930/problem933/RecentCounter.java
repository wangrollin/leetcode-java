package com.wangrollin.leetcode.n0_normal.p900.p930.problem933;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最近的请求次数
 *
 * 写一个RecentCounter类来计算最近的请求。
 * 它只有一个方法：ping(int t)，其中t代表以毫秒为单位的某个时间。
 * 返回从 3000 毫秒前到现在的ping数。
 * 任何处于[t - 3000, t]时间范围之内的 ping都将会被计算在内，包括当前（指 t时刻）的 ping。
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 *
 * 示例：
 * 输入：inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * 输出：[null,1,2,3,3]
 *
 * 提示：
 * 每个测试用例最多调用10000次ping。
 * 每个测试用例会使用严格递增的 t 值来调用ping。
 * 每次调用 ping都有1 <= t <= 10^9。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-recent-calls
 *
 * Solution1
 * 使用队列
 */
public class RecentCounter {

    Queue<Integer> timeQueue = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {

        timeQueue.add(t);
        while (timeQueue.peek() < t - 3000) {
            timeQueue.remove();
        }

        return timeQueue.size();
    }
}
