//给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是： 
//
// 
// 1 表示连接左单元格和右单元格的街道。 
// 2 表示连接上单元格和下单元格的街道。 
// 3 表示连接左单元格和下单元格的街道。 
// 4 表示连接右单元格和下单元格的街道。 
// 5 表示连接左单元格和上单元格的街道。 
// 6 表示连接右单元格和上单元格的街道。 
// 
//
// 
//
// 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径
//。该路径必须只沿着街道走。 
//
// 注意：你 不能 变更街道。 
//
// 如果网格中存在有效的路径，则返回 true，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[2,4,3],[6,5,2]]
//输出：true
//解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[1,2,1],[1,2,1]]
//输出：false
//解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
// 
//
// 示例 3： 
//
// 输入：grid = [[1,1,2]]
//输出：false
//解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
// 
//
// 示例 4： 
//
// 输入：grid = [[1,1,1,1,1,1,3]]
//输出：true
// 
//
// 示例 5： 
//
// 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// 1 <= grid[i][j] <= 6 
// 
// Related Topics 深度优先搜索 广度优先搜索


package com.jue.java.learntest.leetcode.editor.cn.CheckIfThereIsAValidPathInAGrid;

import java.util.Arrays;

/**
 * @author JUE
 * @number 1391
 */
public class CheckIfThereIsAValidPathInAGrid {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {{1, 1, 2}};
        int[][] array1 = {{2, 4, 3}, {6, 5, 2}};
        int[][] array2 = {{4, 1}, {6, 1}};
        int[][] array3 = {{2, 6}};
//        System.out.println(solution.hasValidPath(array));
//        System.out.println(solution.hasValidPath(array2));
        System.out.println(solution.hasValidPath(array3));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
