package com.jue.java.learn.tooffer.solution19;

public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).movingCount(5, 10, 10));
    }

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }
        boolean[][] map = new boolean[rows][cols];
        return movingCount(threshold, 0, 0, map);
    }

    private int movingCount(int threshold, int i, int j, boolean[][] map) {
        int count = 0;
        if (check(threshold, i, j, map)) {
            map[i][j] = true;
            count = 1 + movingCount(threshold, i + 1, j, map)
                    + movingCount(threshold, i - 1, j, map)
                    + movingCount(threshold, i, j + 1, map)
                    + movingCount(threshold, i, j - 1, map);
        }
        return count;
    }

    private boolean check(int threshold, int i, int j, boolean[][] map) {
        if (i >= 0 && i < map.length && j >= 0 && j < map[0].length) {
            if (map[i][j]) {
                //该格子已经走过？是否按照不能到达？
                return false;
            }
            int count = 0;
            while (i > 0) {
                count += i % 10;
                i = i / 10;
            }
            while (j > 0) {
                count += j % 10;
                j = j / 10;
            }
            return (count <= threshold);
        }
        return false;
    }

}