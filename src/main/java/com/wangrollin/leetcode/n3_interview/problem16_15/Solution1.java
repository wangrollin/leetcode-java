package com.wangrollin.leetcode.n3_interview.problem16_15;

import java.util.HashMap;
import java.util.Map;

/**
 * 珠玑妙算
 *
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。
 * 作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。
 * 要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
 * 注意，“猜中”不能算入“伪猜中”。
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，
 * 返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 *
 * 示例：
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 *
 * 提示：
 * len(solution) = len(guess) = 4
 * solution和guess仅包含"R","G","B","Y"这4种字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/master-mind-lcci
 *
 * Solution1
 * 用Map存储各个字符的计数，然后得出相似的计数，减去完全相同的计数，就是伪猜中的次数
 */
public class Solution1 {

    public int[] masterMind(String solution, String guess) {

        Map<Character, Integer> realMap = new HashMap<>();
        solution
                .chars()
                .forEach(ch -> realMap.put((char) ch, realMap.getOrDefault((char) ch, 0) + 1));


        Map<Character, Integer> guessMap = new HashMap<>();
        guess
                .chars().
                forEach(ch -> guessMap.put((char) ch, guessMap.getOrDefault((char) ch, 0) + 1));


        int realCorrect = 0;
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                realCorrect++;
            }
        }

        int notRealCorrect
                = Math.min(realMap.getOrDefault('R', 0), guessMap.getOrDefault('R', 0))
                + Math.min(realMap.getOrDefault('G', 0), guessMap.getOrDefault('G', 0))
                + Math.min(realMap.getOrDefault('B', 0), guessMap.getOrDefault('B', 0))
                + Math.min(realMap.getOrDefault('Y', 0), guessMap.getOrDefault('Y', 0))
                - realCorrect;

        return new int[]{realCorrect, notRealCorrect};
    }
}

