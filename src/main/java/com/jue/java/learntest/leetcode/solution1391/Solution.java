package com.jue.java.learntest.leetcode.solution1391;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] array = {{1, 1, 2}};
        int[][] array1 = {{2, 4, 3}, {6, 5, 2}};
        int[][] array2 = {{4, 1}, {6, 1}};
        int[][] array3 = {{2, 6}};
//        System.out.println((new Solution()).hasValidPath(array));
//        System.out.println((new Solution()).hasValidPath(array2));
        System.out.println((new Solution()).hasValidPath(array3));
    }

    public boolean hasValidPath(int[][] grid) {
        int row = grid.length;
        if (row <= 0) {
            return false;
        }
        int col = grid[0].length;
        if (col <= 0) {
            return false;
        }
        hasValidPath(grid, new boolean[row][col], 0, 0, row, col, ALL);
        return result;
    }

    private boolean result = false;
    private static int ALL = 0, UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;

    public void hasValidPath(int[][] grid, boolean[][] flag, int i, int j, int row, int col, int last) {
        boolean True = true;
        while (i >= 0 && i < row && j >= 0 && j < col && !flag[i][j] && True) {
            flag[i][j] = true;
            switch (grid[i][j]) {
                case 1:
                    if (last == ALL || last == LEFT) {
                        j++;
                        last = LEFT;
                    } else if (last == RIGHT) {
                        j--;
                        last = RIGHT;
                    } else {
                        flag[i][j] = false;
                        True = false;
                    }
                    break;
                case 2:
                    if (last == ALL || last == UP) {
                        i++;
                        last = UP;
                    } else if (last == DOWN) {
                        i--;
                        last = DOWN;
                    } else {
                        flag[i][j] = false;
                        True = false;
                    }
                    break;
                case 3:
                    if (last == ALL || last == LEFT) {
                        i++;
                        last = UP;
                    } else if (last == DOWN) {
                        j--;
                        last = RIGHT;
                    } else {
                        flag[i][j] = false;
                        True = false;
                    }
                    break;
                case 4:
                    if (last == ALL) {
                        hasValidPath(grid, Arrays.copyOf(flag, row), i + 1, j, row, col, UP);
                        hasValidPath(grid, Arrays.copyOf(flag, row), i, j + 1, row, col, LEFT);
                        True = false;
                    } else if (last == RIGHT) {
                        i++;
                        last = UP;
                    } else if (last == DOWN) {
                        j++;
                        last = LEFT;
                    } else {
                        flag[i][j] = false;
                        True = false;
                    }
                    break;
                case 5:
                    if (last == UP) {
                        j--;
                        last = RIGHT;
                    } else if (last == LEFT) {
                        i--;
                        last = DOWN;
                    } else {
                        flag[i][j] = false;
                        True = false;
                    }
                    break;
                case 6:
                    if (last == ALL || last == UP) {
                        j++;
                        last = LEFT;
                    } else if (last == RIGHT) {
                        i--;
                        last = DOWN;
                    } else {
                        flag[i][j] = false;
                        True = false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("wrong connect!");
            }
        }
        if (True && flag[row - 1][col - 1]) {
            result = true;
        }
    }
}