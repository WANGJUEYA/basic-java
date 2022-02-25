//用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。 
//
// 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。 
//
// 
// 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。 
// 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。 
// 
//
// 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就
//会卡住。 
//
// 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 
//-1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-
//1,-1]]
//输出：[1,-1,-1,-1,-1]
//解释：示例如图：
//b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
//b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
//b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
//b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
//b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[-1]]
//输出：[-1]
//解释：球被卡在箱子左侧边上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]
//]
//输出：[0,1,2,3,4,-1]
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// grid[i][j] 为 1 或 -1 
// 
// Related Topics 深度优先搜索 数组 动态规划 矩阵 模拟 👍 101 👎 0


package com.jue.java.learn.leetcode.editor.cn.WhereWillTheBallFall;

import java.util.Arrays;

/**
 * @author JUE
 * @number 1706
 */
public class WhereWillTheBallFall {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(new int[]{1, -1, -1, -1, -1}, solution.findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}})));
        System.out.println(Arrays.equals(new int[]{-1}, solution.findBall(new int[][]{{-1}})));
        System.out.println(Arrays.equals(new int[]{0, 1, 2, 3, 4, -1}, solution.findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}})));
        System.out.println(Arrays.equals(new int[]{-1}, solution.findBall(new int[][]{{1}, {-1}, {1}})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findBall(int[][] grid) {
        int col = grid[0].length;
        // ps[过期想法]: 使用索引指向同样结果的位置 正数表示结果; 负数表示索引; len表示卡住!
        int[] result = new int[col];
        for (int idx = 0; idx < col; idx++) {
            result[idx] = idx;
        }
        // 使用模拟法最傻的一层层下落
        for (int[] ints : grid) {
            for (int j = 0; j < col; j++) {
                int crtIdx = result[j];
                if (-1 < crtIdx && crtIdx < col) {
                    // 当前能正常掉下去
                    int nextIdx = crtIdx + ints[crtIdx];
                    if (-1 < nextIdx && nextIdx < col && ints[nextIdx] + ints[crtIdx] != 0) {
                        result[j] = nextIdx;
                    } else {
                        result[j] = -1;
                    }
                }
            }
        }
        for (int idx = 0; idx < col; idx++) {
            if (col == result[idx]) {
                result[idx] = -1;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
