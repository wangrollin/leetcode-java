package com.wangrollin.leetcode.n0_normal.p1600.p1640.problem1641;

/**
 * 统计字典序元音字符串的数目
 *
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 *
 * 示例 3：
 * 输入：n = 33
 * 输出：66045
 *
 * 提示：
 * 1 <= n <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
 *
 * Solution1
 * 动态规划，只需存储前五个值
 * f(a, 5)代表以a开头的长度为5的字符串数量
 * 状态转移方程: f(a, 5) = f(a, 4) + f(e, 4) + f(i, 4) + f(o, 4) + f(u, 4)
 */
public class Solution1 {

    public int countVowelStrings(int n) {

        int uNum = 1;
        int oNum = 1;
        int iNum = 1;
        int eNum = 1;
        int aNum = 1;

        while (n-- > 1) {

            oNum += uNum;
            iNum += oNum;
            eNum += iNum;
            aNum += eNum;
        }

        return uNum + oNum + iNum + eNum + aNum;
    }
}
