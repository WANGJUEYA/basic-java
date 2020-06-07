//给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。 
//
// 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。 
//
// 
//
// 示例： 
//
// 输入：[[1,2,3],[4,5,6],[7,8,9]]
//输出：12
//解释：
//可能的下降路径有：
// 
//
// 
// [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9] 
// [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9] 
// [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9] 
// 
//
// 和最小的下降路径是 [1,4,7]，所以答案是 12。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length == A[0].length <= 100 
// -100 <= A[i][j] <= 100 
// 
// Related Topics 动态规划


package com.jue.java.learntest.leetcode.editor.cn.MinimumFallingPathSum;

/**
 * @author JUE
 * @number 931
 */
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        if (row <= 0) {
            return 0;
        }
        int col = A[0].length;
        if (col <= 0) {
            return 0;
        }
        int[] pre = new int[col], current;
        int result = 0;
        for (int[] ints : A) {
            current = new int[col];
            result = Integer.MAX_VALUE;
            for (int j = 0; j < row; j++) {
                int min = pre[j];
                if (j - 1 >= 0) {
                    min = Math.min(min, pre[j - 1]);
                }
                if (j + 1 < col) {
                    min = Math.min(min, pre[j + 1]);
                }
                result = Math.min(result, (current[j] = min + ints[j]));
            }
            pre = current;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
