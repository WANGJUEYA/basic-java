//给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。 
//
// 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下
//标从 0 开始计数）执行异或运算得到。 
//
// 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[5,2],[1,6]], k = 1
//输出：7
//解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。 
//
// 示例 2： 
//
// 输入：matrix = [[5,2],[1,6]], k = 2
//输出：5
//解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。 
//
// 示例 3： 
//
// 输入：matrix = [[5,2],[1,6]], k = 3
//输出：4
//解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。 
//
// 示例 4： 
//
// 输入：matrix = [[5,2],[1,6]], k = 4
//输出：0
//解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 1000 
// 0 <= matrix[i][j] <= 10⁶ 
// 1 <= k <= m * n 
// 
//
// Related Topics 位运算 数组 分治 矩阵 前缀和 快速选择 排序 堆（优先队列） 👍 121 👎 0


package com.jue.java.learn.leetcode.editor.cn.FindKthLargestXorCoordinateValue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author JUE
 * @number 1738
 */
public class FindKthLargestXorCoordinateValue {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        List<Integer> queue = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = matrix[i][j];
                if (i > 0) {
                    count = count ^ matrix[i - 1][j];
                }
                if (j > 0) {
                    count = count ^ matrix[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    count = count ^ matrix[i - 1][j - 1];
                }
                matrix[i][j] = count;
                queue.add(count);
            }
        }
        queue.sort(Comparator.comparingInt(a -> -a));
        return queue.get(k - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
