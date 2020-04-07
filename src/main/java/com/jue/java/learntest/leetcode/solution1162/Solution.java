package com.jue.java.learntest.leetcode.solution1162;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int maxDistance(int[][] grid) {
        int row = grid.length;
        if (row <= 0) {
            return -1;
        }
        int col = grid[0].length;
        if (col <= 0) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        // 先将所有陆地入栈
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int max = -1;
        int[][] area = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int[] a : area) {
                int i = temp[0] + a[0];
                int j = temp[1] + a[1];
                if (i >= 0 && i < row && j >= 0 && j < col && grid[i][j] == 0) {
                    grid[i][j] = grid[temp[0]][temp[1]] + 1;
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                    }
                    queue.add(new int[]{i, j});
                }
            }
        }
        return max;
    }
}