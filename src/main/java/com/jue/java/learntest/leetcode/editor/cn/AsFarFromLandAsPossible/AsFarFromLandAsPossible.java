//你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，
//请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。 
//
// 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x
//1| + |y0 - y1| 。 
//
// 如果我们的地图上只有陆地或者海洋，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[1,0,1],[0,0,0],[1,0,1]]
//输出：2
//解释： 
//海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
// 
//
// 示例 2： 
//
// 
//
// 输入：[[1,0,0],[0,0,0],[0,0,0]]
//输出：4
//解释： 
//海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 不是 0 就是 1 
// 
// Related Topics 广度优先搜索 图


package com.jue.java.learntest.leetcode.editor.cn.AsFarFromLandAsPossible;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author JUE
 * @number 1162
 */
public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(int[][] grid) {
        int row = grid.length;
        if (row <= 0) {
            return -1;
        }
        int col = grid[0].length;
        if (col <= 0) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        // 先将所有陆地入栈
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int max = 0;
        int[][] area = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int[] a : area) {
                int i = temp[0] + a[0];
                int j = temp[1] + a[1];
                if (i >= 0 && i < row && j >= 0 && j < col && grid[i][j] == 0) {
                    grid[i][j] = grid[temp[0]][temp[1]] + 1;
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                    }
                    queue.add(new int[]{i, j});
                }
            }
        }
        return max - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
