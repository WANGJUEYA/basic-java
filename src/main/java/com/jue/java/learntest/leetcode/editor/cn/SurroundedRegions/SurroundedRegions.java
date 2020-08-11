//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 319 👎 0


package com.jue.java.learntest.leetcode.editor.cn.SurroundedRegions;

/**
 * @author JUE
 * @number 130
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        // 将所有边界或者与边界项链的数据翻转成8, 再遍历一次填充
        int row = board.length;
        if (row <= 2) {
            return;
        }
        int col = board[0].length;
        if (col <= 2) {
            return;
        }

        for (int i = 0; i < row; i++) {
            solve(board, i, 0, row, col);
            solve(board, i, col - 1, row, col);
        }
        for (int j = 1; j < col - 1; j++) {
            solve(board, 0, j, row, col);
            solve(board, row - 1, j, row, col);
        }
        // 重新反转
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = board[i][j] == '8' ? 'O' : 'X';
            }
        }
    }

    private final int[][] value = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board, int i, int j, int row, int col) {
        if (i >= 0 && i < row && j >= 0 && j < col && board[i][j] == 'O') {
            board[i][j] = '8';
            for (int[] v : value) {
                solve(board, i + v[0], j + v[1], row, col);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
