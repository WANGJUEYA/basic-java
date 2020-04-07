package com.jue.java.learntest.leetcode.solution_m_01_07;

/**
 * @author JUE
 * @date 2020/4/7
 * @note 0 error(s), 0 warning(s)
 **/
class Solution {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        (new Solution()).rotate(array);
    }

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