package com.jue.java.learntest.leetcode.solution0200;

class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row <= 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    deal(grid, i, j, row, col);
                }
            }
        }
        return count;
    }

    public void deal(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        deal(grid, i - 1, j, row, col);
        deal(grid, i + 1, j, row, col);
        deal(grid, i, j - 1, row, col);
        deal(grid, i, j + 1, row, col);
    }
}