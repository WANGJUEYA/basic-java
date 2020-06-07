//给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则： 
//
// 
// 给你一个有效的甲板，仅由战舰或者空位组成。 
// 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。 
// 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。 
// 
//
// 示例 : 
//
// 
//X..X
//...X
//...X
// 
//
// 在上面的甲板中有2艘战舰。 
//
// 无效样例 : 
//
// 
//...X
//XXXX
//...X
// 
//
// 你不会收到这样的无效甲板 - 因为战舰之间至少会有一个空位将它们分开。 
//
// 进阶: 
//
// 你可以用一次扫描算法，只使用O(1)额外空间，并且不修改甲板的值来解决这个问题吗？ 
//


package com.jue.java.learntest.leetcode.editor.cn.BattleshipsInABoard;

/**
 * @author JUE
 * @number 419
 */
public class BattleshipsInABoard {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
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
//leetcode submit region end(Prohibit modification and deletion)

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