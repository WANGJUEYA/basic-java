package com.jue.java.learntest.leetcode.solution1064;

class Solution {
    // FIXME 并没有考虑截取的部分是否满足整除
    public String gcdOfStrings(String str1, String str2) {
        // 当长度相等
        if (str1.length() == str2.length()) {
            return str1.equals(str2) ? str1 : "";
        }

//        // 不相等则间接说明了不存在字符串X
//        if (str1 + str2 !== str2 + str1) {
//            return "";
//        }

        // 类似使用数学的最大公因式方法
        String maxString = str1.length() < str2.length() ? str2 : str1;
        String minString = str1.length() < str2.length() ? str1 : str2;
        return gcdOfStrings(minString, maxString.substring(Math.min(str1.length(), str2.length())));
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).gcdOfStrings("ABCABC", "ABC"));
        System.out.println((new Solution()).gcdOfStrings("ABABAB", "AB"));
        System.out.println((new Solution()).gcdOfStrings("LEET", "CODE"));
    }
}