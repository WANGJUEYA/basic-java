//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
// 
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 10⁶ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 二分查找 矩阵 堆（优先队列） 👍 408 👎 0


package com.jue.java.learn.leetcode.editor.cn.PathWithMinimumEffort;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author JUE
 * @number 1631
 */
public class PathWithMinimumEffort {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int[][] STEP = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        // 采用深度遍历，求到达该点的最小消耗。
        int row = heights.length;
        int col = heights[0].length;
        int[][] minCount = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                minCount[i][j] = Integer.MAX_VALUE;
            }
        }
        // 使用队列 先入先出, 索引及当前预计消耗
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            // 如果当前消耗比之前存储的小，才让后续节点进入队列
            int[] cur = queue.poll();
            int curI = cur[0], curJ = cur[1];
            if (cur[2] < minCount[curI][curJ]) {
                minCount[curI][curJ] = cur[2];
                for (int[] step : STEP) {
                    int nextI = curI + step[0];
                    int nextJ = curJ + step[1];
                    if (nextI >= 0 & nextI < row & nextJ >= 0 & nextJ < col) {
                        queue.add(new int[]{nextI, nextJ, cur[2] + Math.abs(heights[nextI][nextJ] - heights[curI][curJ])});
                    }
                }
            }
        }
        return minCount[row - 1][col - 1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
