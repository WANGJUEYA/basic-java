package com.jue.java.learntest.leetcode.solution0005;

class Solution {

    public static void main(String[] args) {
        System.out.println((new Solution()).longestPalindrome("babad"));
        System.out.println((new Solution()).longestPalindrome("cbbd"));
        System.out.println((new Solution()).longestPalindrome("a"));
        System.out.println((new Solution()).longestPalindrome("ac"));
        System.out.println((new Solution()).longestPalindrome("aaabaaaa"));
        System.out.println((new Solution()).longestPalindrome("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));

    }

    // 方法1: 首尾依次遍历 空间复杂度 O(1) 时间复杂度 O(n^3?) ! 超时警告->是否第一个找到的即为最长的数据?
    public String longestPalindrome(String s) {
        String result = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int j = len - 1;
            while (j >= i) {
                if (s.charAt(i) == s.charAt(j)) {
                    int p = i, q = j;
                    while (p < q && s.charAt(p) == s.charAt(q)) {
                        p++;
                        q--;
                    }
                    if (p >= q) {
                        String sub = s.substring(i, j + 1);
                        if (sub.length() > len / 2D) {
                            return sub;
                        }
                        if (sub.length() > result.length()) {
                            result = sub;
                        }
                    }
                }
                j--;
            }
        }
        return result;
    }
}

class SolutionPerfect {

    // 方法1: 动态规划-中心扩散 TODO
    public String longestPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {

        }
        return "";
    }
}