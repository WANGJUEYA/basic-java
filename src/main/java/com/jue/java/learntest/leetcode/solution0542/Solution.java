package com.jue.java.learntest.leetcode.solution0542;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] memory = new int[row][col];
        int[][] steps = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 采用广度遍历的方式
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int i, j;
        while (queue.size() > 0) {
            int[] item = queue.poll();
            for (int[] step : steps) {
                i = item[0] + step[0];
                j = item[1] + step[1];
                if (i >= 0 && i < row && j >= 0 && j < col && matrix[i][j] != 0 && memory[i][j] == 0) {
                    memory[i][j] = memory[item[0]][item[1]] + 1;
                    queue.add(new int[]{i, j});
                }
            }
        }
        return memory;
    }
}