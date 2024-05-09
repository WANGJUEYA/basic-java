//矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2
//][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。 
//
// 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,2
//5,68,4],[84,28,14,11,5,50]]
//输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66]
//,[84,28,75,33,55,68]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 100 
// 1 <= mat[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 排序 👍 119 👎 0


package com.jue.java.learn.leetcode.editor.cn.SortTheMatrixDiagonally;

import java.util.Arrays;

/**
 * @author JUE
 * @number 1329
 */
public class SortTheMatrixDiagonally {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        // 多级选择排序！
        for (int i = 0; i < row; i++) {
            sort(mat, row, col, i, 0);
        }
        for (int j = 1; j < col; j++) {
            sort(mat, row, col, 0, j);
        }
        return mat;
    }

    private void sort(int[][] mat, int row, int col, int ti, int tj) {
        while (has(row, col, ti, tj)) {
            int[] min = minIndex(mat, row, col, ti, tj);
            int temp = mat[ti][tj];
            mat[ti][tj] = mat[min[0]][min[1]];
            mat[min[0]][min[1]] = temp;
            ti++;
            tj++;
        }
    }

    private int[] minIndex(int[][] mat, int row, int col, int i, int j) {
        int min = mat[i][j];
        int[] result = new int[]{i, j};
        while (has(row, col, ++i, ++j)) {
            if (mat[i][j] < min) {
                min = mat[i][j];
                result = new int[]{i, j};
            }
        }
        return result;
    }

    private boolean has(int row, int col, int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
