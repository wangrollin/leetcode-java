package com.wangrollin.leetcode.n0_normal.p900.p920.problem925;

import java.util.ArrayList;
import java.util.List;

/**
 * 长按键入
 *
 * 你的朋友正在使用键盘输入他的名字name。偶尔，在键入字符c时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回True。
 *
 * 示例 1：
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 *
 * 示例 2：
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 *
 * 示例 3：
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 *
 * 示例 4：
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 * 
 * 提示：
 * name.length <= 1000
 * typed.length <= 1000
 * name 和typed的字符都是小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 *
 * Solution1
 * 分成小块，进行比较，如(a,2),(c,3)
 */
public class Solution2 {

    public boolean isLongPressedName(String name, String typed) {

        if (name.length() > typed.length()) {
            return false;
        }

        if (name.length() == typed.length()) {
            return name.equals(typed);
        }

        List<Pair<Character, Integer>> nameDivided = new ArrayList<>();
        int count = 0;
        char curChar = name.charAt(0);
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == curChar) {
                count++;
            } else {
                nameDivided.add(new Pair<>(curChar, count));
                curChar = name.charAt(i);
                count = 1;
            }
        }
        nameDivided.add(new Pair<>(curChar, count));

        List<Pair<Character, Integer>> typedDivided = new ArrayList<>();
        count = 0;
        curChar = typed.charAt(0);
        for (int i = 0; i < typed.length(); i++) {
            if (typed.charAt(i) == curChar) {
                count++;
            } else {
                typedDivided.add(new Pair<>(curChar, count));
                curChar = typed.charAt(i);
                count = 1;
            }
        }
        typedDivided.add(new Pair<>(curChar, count));

        if (nameDivided.size() != typedDivided.size()) {
            return false;
        }
        for (int i = 0; i < nameDivided.size(); i++) {
            if (nameDivided.get(i).getKey() != typedDivided.get(i).getKey()
                    || nameDivided.get(i).getValue() > typedDivided.get(i).getValue()) {
                return false;
            }
        }
        return true;
    }


    private static class Pair<K, V> {

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
