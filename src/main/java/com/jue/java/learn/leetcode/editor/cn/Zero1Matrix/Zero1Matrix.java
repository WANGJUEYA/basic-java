//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索


package com.jue.java.learn.leetcode.editor.cn.Zero1Matrix;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author JUE
 * @number 542
 */
public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] memory = new int[row][col];
        int[][] steps = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 采用广度遍历的方式
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int i, j;
        while (queue.size() > 0) {
            int[] item = queue.poll();
            for (int[] step : steps) {
                i = item[0] + step[0];
                j = item[1] + step[1];
                if (i >= 0 && i < row && j >= 0 && j < col && matrix[i][j] != 0 && memory[i][j] == 0) {
                    memory[i][j] = memory[item[0]][item[1]] + 1;
                    queue.add(new int[]{i, j});
                }
            }
        }
        return memory;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
