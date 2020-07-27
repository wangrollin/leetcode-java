package com.wangrollin.leetcode.n0_normal.p1400.p1490.problem1496;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 判断路径是否相交
 *
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 *
 * 示例 1：
 * 输入：path = "NES"
 * 输出：false
 * 解释：该路径没有在任何位置相交。
 *
 * 示例 2：
 * 输入：path = "NESWW"
 * 输出：true
 * 解释：该路径经过原点两次。
 *
 * 提示：
 * 1 <= path.length <= 10^4
 * path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-crossing
 *
 * Solution1
 * 使用set保存曾经到过的点，hashCode() equals()
 */
public class Solution1 {

    public boolean isPathCrossing(String path) {

        int x = 0;
        int y = 0;
        Set<Position> set = new HashSet<>();
        set.add(new Position(x, y));

        for (int i = 0; i < path.length(); i++) {

            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            Position position = new Position(x, y);
            if (set.contains(position)) {
                return true;
            } else {
                set.add(position);
            }
        }

        return false;
    }

    private class Position {

        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Position)) {
                return false;
            }

            Position position = (Position) obj;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
