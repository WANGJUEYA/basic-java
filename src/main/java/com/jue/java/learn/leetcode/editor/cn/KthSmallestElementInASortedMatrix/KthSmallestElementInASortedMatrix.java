//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
//
//
//
// 示例：
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
//
//
//
//
// 提示：
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
// Related Topics 堆 二分查找


package com.jue.java.learn.leetcode.editor.cn.KthSmallestElementInASortedMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @number 378
 */
public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(new int[][]{{1, 2}, {3, 3}}, 2));
        System.out.println(solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println(solution.kthSmallest(new int[][]{{1, 3, 5}, {6, 7, 12}, {11, 14, 14}}, 6));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int count = 0, i = 0, j = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] flag = new boolean[row][col];
        List<int[]> array = new ArrayList<>();
        array.add(new int[]{i, j});
        flag[i][j] = true;

        while (count++ < k) {
            i = array.get(0)[0];
            j = array.get(0)[1];
            int remove = 0;
            for (int index = 0, len = array.size(); index < len; index++) {
                int[] item = array.get(index);
                if (matrix[item[0]][item[1]] < matrix[i][j]) {
                    i = item[0];
                    j = item[1];
                    remove = index;
                }
            }
            array.remove(remove);
//            System.out.println(matrix[i][j]);
            if (i < row - 1 && !flag[i + 1][j]) {
                int[] next = {i + 1, j};
                array.add(next);
                flag[i + 1][j] = true;
            }
            if (j < col - 1 && !flag[i][j + 1]) {
                int[] next = {i, j + 1};
                array.add(next);
                flag[i][j + 1] = true;
            }
        }
        return matrix[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
