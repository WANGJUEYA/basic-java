//对一个大小为 n x n 的矩阵而言，如果其每一行和每一列都包含从 1 到 n 的 全部 整数（含 1 和 n），则认为该矩阵是一个 有效 矩阵。 
//
// 给你一个大小为 n x n 的整数矩阵 matrix ，请你判断矩阵是否为一个有效矩阵：如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[1,2,3],[3,1,2],[2,3,1]]
//输出：true
//解释：在此例中，n = 3 ，每一行和每一列都包含数字 1、2、3 。
//因此，返回 true 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[1,1,1],[1,2,3],[1,2,3]]
//输出：false
//解释：在此例中，n = 3 ，但第一行和第一列不包含数字 2 和 3 。
//因此，返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// 1 <= matrix[i][j] <= n 
// 
// 👍 3 👎 0


package com.jue.java.learn.leetcode.editor.cn.CheckIfEveryRowAndColumnContainsAllNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @number 2133
 */
public class CheckIfEveryRowAndColumnContainsAllNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkValid(new int[][]{{1, 2, 3}, {3, 1, 2}, {2, 3, 1}}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValid(int[][] matrix) {
        // 暴力检查法; 时间复杂度位 2n
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0] == 1;
        }
        List<Integer> all = new ArrayList<>();
        for (int index = 1; index <= n; index++) {
            all.add(index);
        }
        for (int index = 0; index < n; index++) {
            List<Integer> row = new ArrayList<>(all);
            List<Integer> col = new ArrayList<>(all);
            for (int temp = 0; temp < n; temp++) {
                if (row.contains(matrix[index][temp])) {
                    row.remove((Object) matrix[index][temp]);
                } else {
                    return false;
                }
                if (col.contains(matrix[temp][index])) {
                    col.remove((Object) matrix[temp][index]);
                } else {
                    return false;
                }
            }
            if (row.size() > 0 || col.size() > 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
