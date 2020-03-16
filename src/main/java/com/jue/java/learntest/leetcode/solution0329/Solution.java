package com.jue.java.learntest.leetcode.solution0329;

class Solution {

    private int[][] flag;

    // 动态规划
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if (row <= 0) {
            return 0;
        }
        int col = matrix[0].length;
        if (col <= 0) {
            return 0;
        }
        flag = new int[row][col];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, longestIncreasingPath(matrix, i, j, row, col));
            }
        }
        return max;
    }

    public int longestIncreasingPath(int[][] matrix, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return 0;
        }
        if (flag[i][j] <= 0) {
            int max = 0;
            int x = i + 1, y = j;
            if (x < row && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, longestIncreasingPath(matrix, x, y, row, col));
            }
            x = i - 1;
            y = j;
            if (x >= 0 && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, longestIncreasingPath(matrix, x, y, row, col));
            }
            x = i;
            y = j + 1;
            if (y < col && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, longestIncreasingPath(matrix, x, y, row, col));
            }
            x = i;
            y = j - 1;
            if (y >= 0 && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, longestIncreasingPath(matrix, x, y, row, col));
            }
            flag[i][j] = max + 1;
        }
        return flag[i][j];
    }

    public static void main(String[] args) {
        int[][] nums = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println((new Solution()).longestIncreasingPath(nums));
    }
}

