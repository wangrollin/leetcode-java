package com.wangrollin.leetcode.n0_normal.p900.p930.problem937;

import java.util.Arrays;

/**
 * 重新排列日志文件
 *
 * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
 * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
 * 标识符后面的每个字将仅由小写字母组成，或；
 * 标识符后面的每个字将仅由数字组成。
 * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
 * 将日志重新排序，使得所有字母日志都排在数字日志之前。
 * 字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。
 * 返回日志的最终顺序。
 *
 * 示例 ：
 * 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * 
 * 提示：
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i]保证有一个标识符，并且标识符后面有一个字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-data-in-log-files
 *
 * Solution1
 * 先把数字log挪到后面去，然后给字母log排序
 */
public class Solution1 {

    public String[] reorderLogFiles(String[] logs) {

        moveNumLogToTheEnd(logs);

        int firstNumLogIndex = logs.length;
        for (int i = 0; i < logs.length; i++) {
            if (isNumLog(logs[i])) {
                firstNumLogIndex = i;
                break;
            }
        }

        Arrays.sort(logs, 0, firstNumLogIndex, this::stringComparator);

        return logs;
    }

    private void moveNumLogToTheEnd(String[] logs) {
        boolean noNumLogAnyMore = false;

        for (int i = logs.length - 1; i > 0; i--) {
            if (noNumLogAnyMore) {
                break;
            }
            if (!isNumLog(logs[i])) {
                for (int j = i - 1; j >= 0; j--) {
                    if (j == 0) {
                        noNumLogAnyMore = true;
                    }
                    if (isNumLog(logs[j])) {
                        String tmp = logs[i];
                        logs[i] = logs[j];
                        logs[j] = tmp;
                        break;
                    }
                }
            }
        }
    }

    private boolean isNumLog(String log) {

        return Character.isDigit(log.split(" ")[1].charAt(0));
    }

    private int stringComparator(String first, String second) {

        String[] firstWords = first.split(" ");
        String[] secondWords = second.split(" ");

        int len = Math.min(firstWords.length, secondWords.length);

        for (int i = 1; i < len; i++) {
            if (firstWords[i].compareTo(secondWords[i]) < 0) {
                return -1;
            } else if (firstWords[i].compareTo(secondWords[i]) > 0) {
                return 1;
            }
        }

        if (firstWords.length > secondWords.length) {
            return 1;
        } else if (first.length() < second.length()) {
            return -1;
        } else {
            return firstWords[0].compareTo(secondWords[0]);
        }

    }
}
