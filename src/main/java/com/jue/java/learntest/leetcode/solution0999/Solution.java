package com.jue.java.learntest.leetcode.solution0999;

class Solution {
    public static void main(String[] args) {
        char[][] array = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println((new Solution()).numRookCaptures(array));
    }

    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    int count = 0;
                    // 上
                    int up = i - 1;
                    while (up >= 0 && board[up][j] == '.') {
                        up--;
                    }
                    if (up >= 0 && board[up][j] == 'p') {
                        count++;
                    }
                    // 下
                    int down = i + 1;
                    while (down < 8 && board[down][j] == '.') {
                        down++;
                    }
                    if (down < 8 && board[down][j] == 'p') {
                        count++;
                    }
                    // 左
                    int left = j - 1;
                    while (left >= 0 && board[i][left] == '.') {
                        left--;
                    }
                    if (left >= 0 && board[i][left] == 'p') {
                        count++;
                    }
                    // 右
                    int right = j + 1;
                    while (right < 8 && board[i][right] == '.') {
                        right++;
                    }
                    if (right < 8 && board[i][right] == 'p') {
                        count++;
                    }
                    return count;
                }
            }
        }
        return 0;
    }
}