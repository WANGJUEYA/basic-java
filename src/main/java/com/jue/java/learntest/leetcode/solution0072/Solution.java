package com.jue.java.learntest.leetcode.solution0072;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).minDistance("horse", "ros")); // 3
        System.out.println((new Solution()).minDistance("intention", "execution")); // 5
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i * j == 0) {
                    dp[i][j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    temp = Math.min(temp, dp[i - 1][j - 1]);
                    dp[i][j] = temp + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}