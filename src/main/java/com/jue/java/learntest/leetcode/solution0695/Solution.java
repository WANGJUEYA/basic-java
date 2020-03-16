package com.jue.java.learntest.leetcode.solution0695;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, maxAreaOfIsland(grid, i, j, row, col));
            }
        }
        return max;
    }

    public int maxAreaOfIsland(int[][] grid, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1
                + maxAreaOfIsland(grid, i + 1, j, row, col)
                + maxAreaOfIsland(grid, i - 1, j, row, col)
                + maxAreaOfIsland(grid, i, j + 1, row, col)
                + maxAreaOfIsland(grid, i, j - 1, row, col);
    }
}