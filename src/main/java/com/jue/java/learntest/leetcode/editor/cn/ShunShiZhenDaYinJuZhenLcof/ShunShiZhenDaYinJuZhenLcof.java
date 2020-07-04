//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组


package com.jue.java.learntest.leetcode.editor.cn.ShunShiZhenDaYinJuZhenLcof;

import java.util.Arrays;

/**
 * @author JUE
 * @number 面试题29
 */
public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.toString(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        if (col == 0) {
            return new int[0];
        }
        int len = row * col;
        int[] result = new int[len];
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // i++ j-- i--,j++
        int[] area = {0, col, row, 0};
        int i = 0, j = 0, index = 0, n = 0;
        while (index < len) {
            result[index++] = matrix[i][j];
//            System.out.println("i: " + i + ",j:" + j + ",[i,j]" + matrix[i][j]);
            if (i + next[n][0] < area[0] || i + next[n][0] >= area[2]
                    || j + next[n][1] < area[3] || j + next[n][1] >= area[1]) {
                if (n == 0 || n == 3) {
                    area[n]++;
                } else {
                    area[n]--;
                }
//                System.out.println(Arrays.toString(area));
                n = (n + 1) % 4;
            }
            i += next[n][0];
            j += next[n][1];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
