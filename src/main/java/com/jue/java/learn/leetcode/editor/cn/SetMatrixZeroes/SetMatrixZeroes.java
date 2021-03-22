//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2: 
//
// 输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//] 
//
// 进阶: 
//
// 
// 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个常数空间的解决方案吗？ 
// 
// Related Topics 数组 
// 👍 395 👎 0


package com.jue.java.learn.leetcode.editor.cn.SetMatrixZeroes;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JUE
 * @number 73
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        // 方案一 使用两个数组分别存储行列中为0元素的索引值(此时空间复杂度为 O(m+n), 时间复杂度为O(mn+m+n))
        // 方案二 常数空间， 时间复杂度会增大，先遍历一遍找到所有为0元素，并将同行同列的数据修改为负数(前提是保证矩阵全为正数) pass 不能保证!!
        // 方案三 原地算法？
        int row = matrix.length, col = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Integer i : rows) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer j : cols) {
            for (int i = 0; i < row; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
// 方案二 常数空间， 时间复杂度会增大，先遍历一遍找到所有为0元素，并将同行同列的数据修改为负数(前提是保证矩阵全为正数) pass 不能保证!!
class Solution_Wrong {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    for (int tempi = 0; tempi < row; tempi++) {
                        if (matrix[tempi][j] != 0 && matrix[tempi][j] != -1) {
                            matrix[tempi][j] = -1;
                        }
                    }
                    for (int tempj = 0; tempj < col; tempj++) {
                        if (matrix[i][tempj] != 0 && matrix[i][tempj] != -1) {
                            matrix[i][tempj] = -1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
