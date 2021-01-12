package com.wangrollin.leetcode.n4_real_interview;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class MSInterview {

    /**
     * 2020.01.11
     * 找到最长严格递增子序列的长度
     * 子序列可以不连续
     */
    public int calMostSubLen(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }

        Map<Integer, Integer> curStatus = new HashMap<>();

        for (int num : arr) {

            if (curStatus.isEmpty()) {
                curStatus.put(num, 1);
            } else {

                OptionalInt maxLenLessThanNumOpt = curStatus.entrySet()
                        .stream()
                        .filter(entry -> entry.getKey() < num)
                        .map(Map.Entry::getValue)
                        .mapToInt(i -> i)
                        .max();

                if (curStatus.containsKey(num)
                        && maxLenLessThanNumOpt.isPresent()
                        && maxLenLessThanNumOpt.getAsInt() + 1 > curStatus.get(num)) {

                    curStatus.put(num, maxLenLessThanNumOpt.getAsInt() + 1);
                } else {
                    maxLenLessThanNumOpt.ifPresentOrElse(len -> curStatus.put(num, len + 1),
                            () -> curStatus.put(num, 1));
                }
            }
        }

        return curStatus.values().stream().mapToInt(i -> i).max().getAsInt();
    }
}
