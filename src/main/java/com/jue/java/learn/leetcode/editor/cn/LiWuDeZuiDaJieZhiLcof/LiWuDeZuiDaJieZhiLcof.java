//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
//
//
//
// 示例 1:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
//
//
//
// 提示：
//
//
// 0 < grid.length <= 200
// 0 < grid[0].length <= 200
//
//
// Related Topics 数组 动态规划 矩阵 👍 400 👎 0


package com.jue.java.learn.leetcode.editor.cn.LiWuDeZuiDaJieZhiLcof;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author JUE
 * @number 剑指 Offer 47
 */
public class LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max[][] = new int[row][col];
        // 广度遍历; 队列, 先入先出
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            if (max[c[0]][c[1]] > 0) {
                continue;
            }
            // 计算左和上的最大值
            int maxLast = 0;
            if (c[0] > 0) {
                maxLast = Math.max(maxLast, max[c[0] - 1][c[1]]);
            }
            if (c[1] > 0) {
                maxLast = Math.max(maxLast, max[c[0]][c[1] - 1]);
            }
            max[c[0]][c[1]] = grid[c[0]][c[1]] + maxLast;
            // 前往右和下
            if (c[0] < row - 1) {
                queue.add(new int[]{c[0] + 1, c[1]});
            }
            if (c[1] < col - 1) {
                queue.add(new int[]{c[0], c[1] + 1});
            }
        }
        return max[row - 1][col - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
