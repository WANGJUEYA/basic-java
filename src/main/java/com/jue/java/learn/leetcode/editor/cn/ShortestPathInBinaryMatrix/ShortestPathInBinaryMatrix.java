//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//：
//
//
// 路径途经的所有单元格都的值都是 0 。
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
//
//
// 畅通路径的长度 是该路径途经的单元格总数。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,1],[1,0]]
//输出：2
//
//
// 示例 2：
//
//
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
//
//
// 示例 3：
//
//
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
//
//
//
//
// 提示：
//
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 100
// grid[i][j] 为 0 或 1
//
//
// Related Topics 广度优先搜索 数组 矩阵 👍 284 👎 0


package com.jue.java.learn.leetcode.editor.cn.ShortestPathInBinaryMatrix;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author JUE
 * @number 1091
 */
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0, 1, 1, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 0}, {0, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 0}}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        // 0表示未处理(首位为例外), -1表示不可达, 其他表示到达的最短路径
        int[][] count = new int[n][n];
        count[0][0] = 1;
        // 最短路径使用广度优先的处理
        int[][] paths = new int[][]{{0, 1}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}, {0, -1}, {-1, 0}, {-1, -1}};
        Queue<int[]> toArrive = new ArrayDeque<>();
        toArrive.add(new int[]{0, 0});
        while (!toArrive.isEmpty()) {
            int[] current = toArrive.poll();
            int i = current[0];
            int j = current[1];
            for (int[] path : paths) {
                // 可到达的点才推入队列
                int ni = i + path[0];
                int nj = j + path[1];
                // 边界范围内且不为起始位
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !(ni == 0 && nj == 0)) {
                    if (grid[ni][nj] == 1) {
                        count[ni][nj] = -1;
                    } else {
                        int nc = count[i][j] + 1;
                        if (count[ni][nj] == 0 || nc < count[ni][nj]) {
                            count[ni][nj] = nc;
                            toArrive.add(new int[]{ni, nj});
                        }
                    }
                }
            }
        }
        return count[n - 1][n - 1] == 0 ? -1 : count[n - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
