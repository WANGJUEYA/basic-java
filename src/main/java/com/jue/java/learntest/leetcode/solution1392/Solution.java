package com.jue.java.learntest.leetcode.solution1392;

import java.util.Arrays;

class Solution {
    public String longestPrefix(String s) {
        int[] next = getNext(s);
        int n = next[s.length()];
        return s.substring(0, n);
    }

    int[] getNext(String s) {
        int[] next = new int[s.length() + 1];
        int i = 0, j = -1;
        // j为前缀, i为后缀
        next[0] = -1;
        while (i < s.length()) {
            System.out.println("------------------");
            System.out.println(i + "," + j);
            if (j == -1 || s.charAt(j) == s.charAt(i))
                // 已有 [0, ..., j - 1] 与 [i - j, ..., i - 1] 匹配, 同时 s[j] == s[i]
                next[++i] = ++j;
                // 匹配长度增加 1, 查看下一个匹配位置
            else
                j = next[j];
            // 不匹配, 说明当前查看的前缀太长, 将 j 跳回到上一个可能的匹配位置=
            System.out.println(i + "," + j);
            System.out.println(Arrays.toString(next));
        }
        return next;
    }
}

class Solution_OUTTIME {
    public static void main(String[] args) {
        System.out.println((new Solution()).longestPrefix("acccbaaacccbaac"));
//        System.out.println((new Solution()).longestPrefix("bba"));
//        System.out.println((new Solution()).longestPrefix("level"));
//        System.out.println((new Solution()).longestPrefix("ababab"));
//        System.out.println((new Solution()).longestPrefix("abcabcabc"));
//        System.out.println((new Solution()).longestPrefix("aaaaaaab"));
//        System.out.println((new Solution()).longestPrefix("aaaaaaabaaaaaaa"));
    }

    public String longestPrefix(String s) {
        int len = s.length();
        if (len <= 1) {
            return "";
        }
        int subLen = len - 1;
        char[] ss = s.toCharArray();
        char begin = ss[0];
        for (int index = 1; index < len; index++, subLen--) {
            // 开始遍历
            if (begin == ss[index]) {
                if (String.valueOf(ss, 0, subLen).equals(String.valueOf(ss, index, subLen))) {
                    return String.valueOf(ss, 0, subLen);
                }
            }
        }
        return "";
    }
}