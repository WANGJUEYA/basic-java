//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。 
//
// 不占用额外内存空间能否做到？ 
//
// 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组


package com.jue.java.learn.leetcode.editor.cn.RotateMatrixLcci;

/**
 * @author JUE
 * @number 面试题 01.07
 */
public class RotateMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(array);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        if (N > 1) {
            int temp, len, top, begin, end;
            for (int index = 0, count = N / 2; index < count; index++) {
                len = N - 2 * index - 1;
                top = 0;
                begin = index;
                end = N - index - 1;
                while (top < len) {
                    temp = matrix[begin][end - top];
                    matrix[begin][end - top] = matrix[begin + top][begin];
                    matrix[begin + top][begin] = matrix[end][begin + top];
                    matrix[end][begin + top] = matrix[end - top][end];
                    matrix[end - top][end] = temp;
                    top++;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
