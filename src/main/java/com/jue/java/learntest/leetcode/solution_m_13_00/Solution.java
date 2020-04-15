package com.jue.java.learntest.leetcode.solution_m_13_00;

/**
 * @author JUE
 * @date 2020/4/8
 * @note 0 error(s), 0 warning(s)
 **/
class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).movingCount(16, 8, 4));
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] gird = new boolean[m][n];
        return movingCount(gird, 0, 0, m, n, k);
    }

    int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int movingCount(boolean[][] grid, int i, int j, int m, int n, int k) {
        int sum = 0;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j]) {
            return 0;
        }
        // 标记该格子已经到达过了
        grid[i][j] = true;
        int tempI = i, tempJ = j, tempK = 0;
        while (tempI > 0) {
            tempK += tempI % 10;
            tempI /= 10;
        }
        while (tempJ > 0) {
            tempK += tempJ % 10;
            tempJ /= 10;
        }
        if (tempK <= k) {
            sum++;
            for (int[] d : dir) {
                sum += movingCount(grid, i + d[0], j + d[1], m, n, k);
            }
        }
        return sum;
    }
}