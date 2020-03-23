package com.jue.java.learntest.leetcode.solution0214;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).shortestPalindrome("abc"));
        System.out.println((new Solution()).shortestPalindrome("aaaaa"));
        System.out.println((new Solution()).shortestPalindrome("aabba"));
        System.out.println((new Solution()).shortestPalindrome("aaaabbaa"));
    }

    public String shortestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        String str = s + reverse;
        len = str.length();
        int[] next = new int[len + 1];
        next[0] = -1;
        int j = -1, i = 0;
        // 找出最长前后缀
        while (i < len) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        if (next[len] == len - 1) {
            return s;
        } else if (next[len] > len / 2) {
            return reverse.substring(0, (len - next[len]) / 2 + 1) + s;
        } else {
            return reverse.substring(0, len / 2 - next[len]) + s;
        }
    }
}