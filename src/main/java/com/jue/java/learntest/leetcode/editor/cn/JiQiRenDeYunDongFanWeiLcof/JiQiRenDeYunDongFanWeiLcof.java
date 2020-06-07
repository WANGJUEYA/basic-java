//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
//


package com.jue.java.learntest.leetcode.editor.cn.JiQiRenDeYunDongFanWeiLcof;

/**
 * @author JUE
 * @number 面试题13
 */
public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(16, 8, 4));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] gird = new boolean[m][n];
        return movingCount(gird, 0, 0, m, n, k);
    }

    int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int movingCount(boolean[][] grid, int i, int j, int m, int n, int k) {
        int sum = 0;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j]) {
            return 0;
        }
        // 标记该格子已经到达过了
        grid[i][j] = true;
        int tempI = i, tempJ = j, tempK = 0;
        while (tempI > 0) {
            tempK += tempI % 10;
            tempI /= 10;
        }
        while (tempJ > 0) {
            tempK += tempJ % 10;
            tempJ /= 10;
        }
        if (tempK <= k) {
            sum++;
            for (int[] d : dir) {
                sum += movingCount(grid, i + d[0], j + d[1], m, n, k);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
