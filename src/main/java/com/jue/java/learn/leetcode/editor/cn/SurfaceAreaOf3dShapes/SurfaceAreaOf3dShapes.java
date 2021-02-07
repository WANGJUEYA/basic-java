//在 N * N 的网格上，我们放置一些 1 * 1 * 1 的立方体。 
//
// 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。 
//
// 请你返回最终形体的表面积。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[[2]]
//输出：10
// 
//
// 示例 2： 
//
// 输入：[[1,2],[3,4]]
//输出：34
// 
//
// 示例 3： 
//
// 输入：[[1,0],[0,2]]
//输出：16
// 
//
// 示例 4： 
//
// 输入：[[1,1,1],[1,0,1],[1,1,1]]
//输出：32
// 
//
// 示例 5： 
//
// 输入：[[2,2,2],[2,1,2],[2,2,2]]
//输出：46
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 50 
// 0 <= grid[i][j] <= 50 
// 
// Related Topics 几何 数学


package com.jue.java.learn.leetcode.editor.cn.SurfaceAreaOf3dShapes;

/**
 * @author JUE
 * @number 892
 */
public class SurfaceAreaOf3dShapes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] array1 = {{1, 2}, {3, 4}};
        System.out.println(solution.surfaceArea(array1));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int surfaceArea(int[][] grid) {
        int row = grid.length;
        if (row <= 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col <= 0) {
            return 0;
        }

        // 上/下/左/右/前/后
        int total = 0;
        int temp = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 上下
                if (grid[i][j] > 0) {
                    total += 2;
                }
                //左
                if (i == 0) {
                    total += grid[i][j];
                } else {
                    temp = grid[i][j] - grid[i - 1][j];
                    if (temp > 0) {
                        total += temp;
                    }
                }
                //右
                if (i == row - 1) {
                    total += grid[i][j];
                } else {
                    temp = grid[i][j] - grid[i + 1][j];
                    if (temp > 0) {
                        total += temp;
                    }
                }
                //前
                if (j == 0) {
                    total += grid[i][j];
                } else {
                    temp = grid[i][j] - grid[i][j - 1];
                    if (temp > 0) {
                        total += temp;
                    }
                }
                //后
                if (j == col - 1) {
                    total += grid[i][j];
                } else {
                    temp = grid[i][j] - grid[i][j + 1];
                    if (temp > 0) {
                        total += temp;
                    }
                }
            }
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
