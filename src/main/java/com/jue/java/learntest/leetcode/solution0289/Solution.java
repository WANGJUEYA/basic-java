package com.jue.java.learntest.leetcode.solution0289;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public void gameOfLife(int[][] board) {
        Queue<Integer> integers = new LinkedList<>();
        // 普通方法
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                if (i > 0) {
                    count += board[i - 1][j];
                    if (j > 0) {
                        count += board[i - 1][j - 1];
                    }
                    if (j < col - 1) {
                        count += board[i - 1][j + 1];
                    }
                }
                if (j > 0) {
                    count += board[i][j - 1];
                }
                if (i < row - 1) {
                    count += board[i + 1][j];
                    if (j > 0) {
                        count += board[i + 1][j - 1];
                    }
                    if (j < col - 1) {
                        count += board[i + 1][j + 1];
                    }
                }
                if (j < col - 1) {
                    count += board[i][j + 1];
                }
                integers.add((count == 3) || (board[i][j] == 1 && count == 2) ? 1 : 0);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = integers.poll();
            }
        }
    }
}