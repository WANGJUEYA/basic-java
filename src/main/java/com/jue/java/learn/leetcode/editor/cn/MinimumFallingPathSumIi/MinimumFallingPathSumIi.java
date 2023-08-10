//给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
//
// 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
//
//
// 示例 2：
//
//
//输入：grid = [[7]]
//输出：7
//
//
//
//
// 提示：
//
//
// n == grid.length == grid[i].length
// 1 <= n <= 200
// -99 <= grid[i][j] <= 99
//
//
// Related Topics 数组 动态规划 矩阵 👍 120 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumFallingPathSumIi;

/**
 * @author JUE
 * @number 1289
 */
public class MinimumFallingPathSumIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int minFallingPathSum(int[][] grid) {
        // 使用动态规划快速计算
        int len = grid.length;
        // 存储最小索引及第二小索引
        int[] min = new int[]{Integer.MAX_VALUE, -1};
        int[] minBigger = new int[]{Integer.MAX_VALUE, -1};
        for (int i = 0; i < len; i++) {
            int[] minTmp = new int[]{Integer.MAX_VALUE, -1};
            int[] minBiggerTmp = new int[]{Integer.MAX_VALUE, -1};
            for (int j = 0; j < len; j++) {
                int current = grid[i][j];
                if (i > 0) {
                    int lastRow = j == min[1] ? minBigger[0] : min[0];
                    current += lastRow;
                }
                if (current < minTmp[0]) {
                    minBiggerTmp = minTmp;
                    minTmp = new int[]{current, j};
                } else if (current < minBiggerTmp[0]) {
                    minBiggerTmp = new int[]{current, j};
                }
            }
            min = minTmp;
            minBigger = minBiggerTmp;
        }
        return min[0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
