package com.wangrollin.leetcode.n0_normal.p1500.p1500.problem1507;

import java.util.HashMap;
import java.util.Map;

/**
 * 转变日期格式
 *
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 * Year 的范围在 ​[1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 * YYYY 表示 4 位的年份。
 * MM 表示 2 位的月份。
 * DD 表示 2 位的天数。
 *  
 * 示例 1：
 * 输入：date = "20th Oct 2052"
 * 输出："2052-10-20"
 *
 * 示例 2：
 * 输入：date = "6th Jun 1933"
 * 输出："1933-06-06"
 *
 * 示例 3：
 * 输入：date = "26th May 1960"
 * 输出："1960-05-26"
 *  
 * 提示：
 * 给定日期保证是合法的，所以不需要处理异常输入。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reformat-date
 *
 * Solution1
 * 字符串解析
 */
public class Solution1 {

    public String reformatDate(String date) {

        String[] dates = date.split(" ");
        StringBuilder sb = new StringBuilder();
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> monthMap = new HashMap<>();
        for (int i = 0; i < months.length; i++) {
            monthMap.put(months[i], i + 1);
        }

        sb.append(dates[2])
                .append('-')
                .append(String.format("%02d", monthMap.get(dates[1])))
                .append('-')
                .append(String.format("%02d", Integer.parseInt(dates[0].substring(0, dates[0].length() - 2))));

        return sb.toString();
    }
}
