package com.wangrollin.leetcode.n3_interview.problem17_11;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词距离
 *
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 *
 * 提示：
 * words.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-closest-lcci
 *
 * Solution1
 * 关键在于找到一串两色小球中，不同颜色小球的最近距离
 */
public class Solution1 {

    public int findClosest(String[] words, String word1, String word2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                list1.add(i);
            } else if (words[i].equals(word2)) {
                list2.add(i);
            }
        }

        return findMinDistance(list1, list2);
    }

    private int findMinDistance(List<Integer> list1, List<Integer> list2) {

        int num1 = list1.get(0);
        int num2 = list2.get(0);
        int nextIndex1 = 1;
        int nextIndex2 = 1;

        if (num1 < num2) {
            while (true) {
                if (nextIndex1 < list1.size()) {
                    int temp = list1.get(nextIndex1);
                    if (temp < num2) {
                        num1 = temp;
                        nextIndex1++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            while (true) {
                if (nextIndex2 < list2.size()) {
                    int temp = list2.get(nextIndex2);
                    if (temp < num1) {
                        num2 = temp;
                        nextIndex2++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        int min = Math.abs(num1 - num2);

        int curList = num1 < num2 ? 2 : 1;


        while (nextIndex1 < list1.size() && nextIndex2 < list2.size()) {

            if (list1.get(nextIndex1) < list2.get(nextIndex2)) {
                num1 = list1.get(nextIndex1);
                if (curList == 2) {
                    min = Math.min(min, num1 - num2);
                    curList = 1;
                }
                nextIndex1++;
            } else {
                num2 = list2.get(nextIndex2);
                if (curList == 1) {
                    min = Math.min(min, num2 - num1);
                    curList = 2;
                }
                nextIndex2++;
            }
        }

        if (nextIndex1 < list1.size() && curList == 2) {
            min = Math.min(min, list1.get(nextIndex1) - num2);
        } else if (nextIndex2 < list2.size() && curList == 1) {
            min = Math.min(min, list2.get(nextIndex2) - num1);
        }
        return min;
    }
}
