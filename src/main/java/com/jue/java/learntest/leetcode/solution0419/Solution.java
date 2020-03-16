package com.jue.java.learntest.leetcode.solution0419;

class Solution {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int total = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') {
                    total++;
                    countBattleships(board, i, j, row, col);
                }
            }
        }
        return total;
    }

    public void countBattleships(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        countBattleships(board, i - 1, j, row, col);
        countBattleships(board, i + 1, j, row, col);
        countBattleships(board, i, j - 1, row, col);
        countBattleships(board, i, j + 1, row, col);
    }

}

class Solution_Perfect {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int sum = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                // ps: 当一只战舰的左边或上边为'X' 表示该点所在的战舰已经计数
                if (board[i][j] == 'X') {
                    sum++;
                    if (j - 1 >= 0 && board[i][j - 1] == 'X') {
                        sum--;
                    }
                    if (i - 1 >= 0 && board[i - 1][j] == 'X') {
                        sum--;
                    }
                }
            }
        return sum;
    }
}