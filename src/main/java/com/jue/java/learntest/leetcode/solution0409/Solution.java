package com.jue.java.learntest.leetcode.solution0409;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        boolean[] array = new boolean[52]; // A 位于 a 之前
        int count = 0;
        for (char c : s.toCharArray()) {
            int index = c >= 'a' ? 26 + c - 'a' : c - 'A';
            if (array[index]) {
                array[index] = false;
                count += 2;
            } else {
                array[index] = true;
            }
        }
        return count < s.length() ? count + 1 : count;
    }
}