package com.jue.java.learntest.leetcode.solution0892;

class Solution {
    public static void main(String[] args) {
        int[][] array = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] array1 = {{1, 2}, {3, 4}};
        System.out.println((new Solution()).surfaceArea(array1));
    }

    public int surfaceArea(int[][] grid) {
        int row = grid.length;
        if (row <= 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col <= 0) {
            return 0;
        }

        // 上/下/左/右/前/后
        int total = 0;
        int temp = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 上下
                if (grid[i][j] > 0) {
                    total += 2;
                }
                //左
                if (i == 0) {
                    total += grid[i][j];
                } else {
                    temp = grid[i][j] - grid[i - 1][j];
                    if (temp > 0) {
                        total += temp;
                    }
                }
                //右
                if (i == row - 1) {
                    total += grid[i][j];
                } else {
                    temp = grid[i][j] - grid[i + 1][j];
                    if (temp > 0) {
                        total += temp;
                    }
                }
                //前
                if (j == 0) {
                    total += grid[i][j];
                } else {
                    temp = grid[i][j] - grid[i][j - 1];
                    if (temp > 0) {
                        total += temp;
                    }
                }
                //后
                if (j == col - 1) {
                    total += grid[i][j];
                } else {
                    temp = grid[i][j] - grid[i][j + 1];
                    if (temp > 0) {
                        total += temp;
                    }
                }
            }
        }
        return total;
    }
}