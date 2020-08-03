package com.wangrollin.leetcode.n0_normal.p1300.p1360.problem1360;

import java.time.LocalDate;

/**
 * 日期之间隔几天
 *
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 * 日期以字符串形式给出，格式为YYYY-MM-DD，如示例所示。
 *
 * 示例 1：
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 *
 * 示例 2：
 * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：15
 * 
 * 提示：
 * 给定的日期是1971年到 2100年之间的有效日期。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-days-between-two-dates
 *
 * Solution1
 * localDate.toEpochDay()，leetcode还不支持localDate
 */
public class Solution1 {

    public int daysBetweenDates(String date1, String date2) {

        String[] date1Arr = date1.split("-");
        String[] date2Arr = date2.split("-");

        LocalDate localDate1 = LocalDate.of(Integer.parseInt(date1Arr[0]),
                Integer.parseInt(date1Arr[1]),
                Integer.parseInt(date1Arr[2]));

        LocalDate localDate2 = LocalDate.of(Integer.parseInt(date2Arr[0]),
                Integer.parseInt(date2Arr[1]),
                Integer.parseInt(date2Arr[2]));

        return (int) Math.abs(localDate1.toEpochDay() - localDate2.toEpochDay());
    }
}
