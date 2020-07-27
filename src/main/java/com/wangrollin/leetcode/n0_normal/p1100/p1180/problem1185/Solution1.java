package com.wangrollin.leetcode.n0_normal.p1100.p1180.problem1185;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * 一周中的第几天
 *
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 * 示例 1：
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 *
 * 示例 2：
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 *
 * 示例 3：
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *
 * 提示：
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
 *
 * Solution1
 * LocalDate大法好
 */
public class Solution1 {

    public String dayOfTheWeek(int day, int month, int year) {

        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);
    }

}
