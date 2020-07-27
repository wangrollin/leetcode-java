package com.wangrollin.leetcode.n0_normal.p1100.p1120.problem1122;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 提示：
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 *
 * Solution1
 * stream, 桶，flatmap
 */
public class Solution1 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> numberCount = new HashMap<>();
        List<Integer> notInvolvedArr = new ArrayList<>();

        Arrays.stream(arr2).forEach(i -> numberCount.put(i, 0));

        Arrays.stream(arr1)
                .forEach(i -> {
                    if (numberCount.containsKey(i)) {
                        numberCount.put(i, numberCount.get(i) + 1);
                    } else {
                        notInvolvedArr.add(i);
                    }
                });

        List<Integer> involvedArr
                = Arrays
                .stream(arr2)
                .flatMap(integer -> {
                    int[] tmp = new int[numberCount.get(integer)];
                    Arrays.fill(tmp, integer);
                    return Arrays.stream(tmp);
                })
                .boxed()
                .collect(Collectors.toList());

        notInvolvedArr.sort(Comparator.comparingInt(i -> i));
        involvedArr.addAll(notInvolvedArr);

        return involvedArr.stream().mapToInt(i -> i).toArray();
    }
}
