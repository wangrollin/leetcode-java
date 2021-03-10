package com.wangrollin.leetcode.n0_normal.p600.p640.problem648;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单词替换
 *
 * 在英语中，我们有一个叫做词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。
 * 例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 *
 * 示例 1：
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 * 示例 2：
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 *
 * 示例 3：
 * 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 * 输出："a a a a a a a a bbb baba a"
 *
 * 示例 4：
 * 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 * 示例 5：
 * 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
 * 输出："it is ab that this solution is ac"
 *
 * 提示：
 * 1 <= dictionary.length<= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i]仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence没有前导或尾随空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-words
 *
 * Solution2
 * 前缀树，一步到位，迅速判断
 */
public class Solution2 {

    public String replaceWords(List<String> dictionary, String sentence) {

        if (dictionary == null || dictionary.size() == 0) {
            return sentence;
        }
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }

        PreTreeNode rootTree = new PreTreeNode(' ');
        rootTree.str = "";

        dictionary.forEach(root -> {
            PreTreeNode curNode = rootTree;
            for (int i = 0; i < root.length(); i++) {
                String curStr = curNode.str;
                if (!curNode.children.containsKey(root.charAt(i))) {
                    curNode.children.put(root.charAt(i), new PreTreeNode(root.charAt(i)));
                }
                curNode = curNode.children.get(root.charAt(i));
                if (curNode.str == null) {
                    curNode.str = curStr + curNode.curChar;
                }
                if (i == root.length() - 1) {
                    curNode.isWord = true;
                }
            }
        });

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = getPrefix(rootTree, words[i]);
        }

        return String.join(" ", words);
    }

    private String getPrefix(PreTreeNode node, String str) {

        for (int i = 0; i < str.length(); i++) {
            if (node.children.containsKey(str.charAt(i))) {
                node = node.children.get(str.charAt(i));
                if (node.isWord) {
                    return node.str;
                }
            } else {
                break;
            }
        }

        return str;
    }

    private static class PreTreeNode {

        char curChar;
        String str;
        boolean isWord;
        Map<Character, PreTreeNode> children = new HashMap<>();

        public PreTreeNode(char curChar) {
            this.curChar = curChar;
        }
    }
}
