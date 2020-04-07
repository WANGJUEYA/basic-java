package com.jue.java.learntest.leetcode.solution0931;

class Solution {
    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        if (row <= 0) {
            return 0;
        }
        int col = A[0].length;
        if (col <= 0) {
            return 0;
        }
        int[] pre = new int[col], current;
        int result = 0;
        for (int[] ints : A) {
            current = new int[col];
            result = Integer.MAX_VALUE;
            for (int j = 0; j < row; j++) {
                int min = pre[j];
                if (j - 1 >= 0) {
                    min = Math.min(min, pre[j - 1]);
                }
                if (j + 1 < col) {
                    min = Math.min(min, pre[j + 1]);
                }
                result = Math.min(result, (current[j] = min + ints[j]));
            }
            pre = current;
        }
        return result;
    }

    public int minFallingPathSum_PlaceLarger(int[][] A) {
        int row = A.length;
        if (row <= 0) {
            return 0;
        }
        int col = A[0].length;
        if (col <= 0) {
            return 0;
        }
        int[][] dp = new int[row + 1][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            result = Integer.MAX_VALUE;
            for (int j = 0; j < row; j++) {
                int min = dp[i][j];
                if (j - 1 >= 0) {
                    min = Math.min(min, dp[i][j - 1]);
                }
                if (j + 1 < col) {
                    min = Math.min(min, dp[i][j + 1]);
                }
                result = Math.min(result, (dp[i + 1][j] = min + A[i][j]));
            }
        }
        return result;
    }
}