package com.wangrollin.leetcode.n0_normal.p1100.p1100.problem1108;

/**
 * IP 地址无效化
 *
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * 示例 1：
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 *
 * 示例 2：
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *  
 * 提示：
 * 给出的 address 是一个有效的 IPv4 地址
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/defanging-an-ip-address
 *
 * Solution1
 * 直接用replaceAll()
 */
public class Solution1 {

    public String defangIPaddr(String address) {

        return address.replaceAll("\\.", "[.]");
    }
}
