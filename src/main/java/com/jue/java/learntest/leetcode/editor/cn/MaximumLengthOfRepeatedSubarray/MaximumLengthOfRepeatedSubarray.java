//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划


package com.jue.java.learntest.leetcode.editor.cn.MaximumLengthOfRepeatedSubarray;

/**
 * @author JUE
 * @number 718
 */
public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLength(new int[]{5, 4, 3, 2, 1}, new int[]{3, 2, 1, 5, 4}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] A, int[] B) {
        // A[i] == B[j], dp[i][j] = dp[i-1][j-1] + 1
        int row = A.length;
        int col = B.length;
        int[][] dp = new int[row][col];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i] == B[j]) {
                    if (i != 0 && j != 0 && A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
