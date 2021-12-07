//给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
//。 
//
// 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。 
//
// 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。 
//
// 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//输出：[[3,3],[3,2]] 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//输出：[[1,3,3],[2,3,3]] 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//输出：[[2,2,2],[2,1,2],[2,2,2]] 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 50 👎 0


package com.jue.java.learn.leetcode.editor.cn.ColoringABorder;

import java.util.Arrays;

/**
 * @author JUE
 * @number 1034
 */
public class ColoringABorder {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.colorBorder(new int[][]{{1, 1}, {1, 2}}, 0, 0, 3)));
        System.out.println(Arrays.deepToString(solution.colorBorder(new int[][]{{1, 2, 2}, {2, 3, 2}}, 0, 1, 3)));
        System.out.println(Arrays.deepToString(solution.colorBorder(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 1, 1, 2)));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int[][] POS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int sizeRow = grid.length, sizeCol = grid[0].length;
        colorBorder(grid, new int[sizeRow][sizeCol], row, col);
        // 反转颜色
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeCol; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    /**
     * 标记所有边界; 新增一个数组表示该点已经遍历过了
     */
    public void colorBorder(int[][] grid, int[][] flag, int row, int col) {
        // 标记来过
        flag[row][col] = -1;
        // 网格着色问题; 普遍的递归处理数据(注意修改的值之前和之后)
        int sizeRow = grid.length, sizeCol = grid[0].length;
        int tempColor = grid[row][col];
        // 什么时候上色是一个问题; 晚了会导致一直循环 (由于本次只给边界上色; 故考虑之后进行上色)
        // 标记一下边界
        if (row == 0 || row == sizeRow - 1 || col == 0 || col == sizeCol - 1
                || tempColor != Math.abs(grid[row - 1][col])
                || tempColor != Math.abs(grid[row + 1][col])
                || tempColor != Math.abs(grid[row][col - 1])
                || tempColor != Math.abs(grid[row][col + 1])) {
            grid[row][col] = -tempColor;
        }
        for (int[] p : POS) {
            int tempRow = row + p[0];
            int tempCol = col + p[1];
            if (tempRow >= 0 && tempRow < sizeRow && tempCol >= 0 && tempCol < sizeCol
                    && flag[tempRow][tempCol] == 0 && grid[tempRow][tempCol] == tempColor) {
                colorBorder(grid, flag, tempRow, tempCol);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


