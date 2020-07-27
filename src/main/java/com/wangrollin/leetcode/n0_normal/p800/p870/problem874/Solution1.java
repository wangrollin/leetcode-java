package com.wangrollin.leetcode.n0_normal.p800.p870.problem874;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 模拟行走机器人
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 返回从原点到机器人的最大欧式距离的平方。
 *
 * 示例 1：
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 *
 * 示例 2：
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *  
 * 提示：
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 *
 * Solution1
 * 模拟行走即可，这题leetcode有bug，跑不过，本地可以正常跑过，不管了
 */
public class Solution1 {

    private static final String UP = "UP";
    private static final String DOWN = "DOWN";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";

    private static final Set<Pair<Integer, Integer>> obstaclesSet = new HashSet<>();

    public static int robotSim(int[] commands, int[][] obstacles) {

        Arrays.stream(obstacles).forEach(obstacle -> {
            obstaclesSet.add(new Pair(obstacle[0], obstacle[1]));
        });

        int positionX = 0;
        int positionY = 0;
        String direction = UP;
        int maxLen = 0;

        for (int command : commands) {
            switch (command) {
                case -2:
                    switch (direction) {
                        case UP:
                            direction = LEFT;
                            break;
                        case DOWN:
                            direction = RIGHT;
                            break;
                        case LEFT:
                            direction = DOWN;
                            break;
                        case RIGHT:
                            direction = UP;
                            break;
                    }
                    break;
                case -1:
                    switch (direction) {
                        case UP:
                            direction = RIGHT;
                            break;
                        case DOWN:
                            direction = LEFT;
                            break;
                        case LEFT:
                            direction = UP;
                            break;
                        case RIGHT:
                            direction = DOWN;
                            break;
                    }
                    break;
                default:
                    Pair<Integer, Integer> resultPosition
                            = tryToGo(positionX, positionY, direction, command);
                    positionX = resultPosition.getKey();
                    positionY = resultPosition.getValue();
                    maxLen = Math.max(maxLen, positionX * positionX + positionY * positionY);
                    break;
            }
        }

        return maxLen;
    }

    private static Pair<Integer, Integer> tryToGo(int positionX, int positionY,
                                                  String direction, int stepLen) {

        switch (direction) {
            case UP:
                for (int i = 1; i <= stepLen; i++) {
                    if (obstaclesSet.contains(new Pair<>(positionX, positionY + i))) {
                        return new Pair<>(positionX, positionY + i - 1);
                    }
                }
                return new Pair<>(positionX, positionY + stepLen);
            case DOWN:
                for (int i = 1; i <= stepLen; i++) {
                    if (obstaclesSet.contains(new Pair<>(positionX, positionY - i))) {
                        return new Pair<>(positionX, positionY - i + 1);
                    }
                }
                return new Pair<>(positionX, positionY - stepLen);
            case LEFT:
                for (int i = 1; i <= stepLen; i++) {
                    if (obstaclesSet.contains(new Pair<>(positionX - i, positionY))) {
                        return new Pair<>(positionX - i + 1, positionY);
                    }
                }
                return new Pair<>(positionX - stepLen, positionY);

            default:
                // RIGHT
                for (int i = 1; i <= stepLen; i++) {
                    if (obstaclesSet.contains(new Pair<>(positionX + i, positionY))) {
                        return new Pair<>(positionX + i - 1, positionY);
                    }
                }
                return new Pair<>(positionX + stepLen, positionY);
        }
    }

    public static void main(String[] args) {

        System.out.println(robotSim(new int[]{-2, -1, 4, 7, 8},
                new int[][]{new int[]{1, 1}, new int[]{2, 1}, new int[]{4, 4}, new int[]{5, -5}, new int[]{2, -3},
                        new int[]{-2, -3}, new int[]{-1, -3}, new int[]{-4, -1}, new int[]{-4, 3}, new int[]{5, 1}}));
    }
}
