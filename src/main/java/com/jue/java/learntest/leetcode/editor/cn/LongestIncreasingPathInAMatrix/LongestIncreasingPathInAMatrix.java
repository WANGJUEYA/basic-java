//给定一个整数矩阵，找出最长递增路径的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。 
//
// 示例 1: 
//
// 输入: nums = 
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//] 
//输出: 4 
//解释: 最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2: 
//
// 输入: nums = 
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//] 
//输出: 4 
//解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
// Related Topics 深度优先搜索 拓扑排序 记忆化


package com.jue.java.learntest.leetcode.editor.cn.LongestIncreasingPathInAMatrix;

/**
 * @author JUE
 * @number 329
 */
public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(solution.longestIncreasingPath(nums));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[][] flag;

    // 动态规划
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if (row <= 0) {
            return 0;
        }
        int col = matrix[0].length;
        if (col <= 0) {
            return 0;
        }
        flag = new int[row][col];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, longestIncreasingPath(matrix, i, j, row, col));
            }
        }
        return max;
    }

    public int longestIncreasingPath(int[][] matrix, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return 0;
        }
        if (flag[i][j] <= 0) {
            int max = 0;
            int x = i + 1, y = j;
            if (x < row && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, longestIncreasingPath(matrix, x, y, row, col));
            }
            x = i - 1;
            y = j;
            if (x >= 0 && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, longestIncreasingPath(matrix, x, y, row, col));
            }
            x = i;
            y = j + 1;
            if (y < col && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, longestIncreasingPath(matrix, x, y, row, col));
            }
            x = i;
            y = j - 1;
            if (y >= 0 && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, longestIncreasingPath(matrix, x, y, row, col));
            }
            flag[i][j] = max + 1;
        }
        return flag[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
