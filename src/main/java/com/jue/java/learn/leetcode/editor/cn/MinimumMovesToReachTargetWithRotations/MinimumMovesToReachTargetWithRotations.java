//你还记得那条风靡全球的贪吃蛇吗？ 
//
// 我们在一个 n*n 的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。蛇会从左上角（(0, 0) 和 (0, 1)）开始移动。我们用
// 0 表示空单元格，用 1 表示障碍物。蛇需要移动到迷宫的右下角（(n-1, n-2) 和 (n-1, n-1)）。 
//
// 每次移动，蛇可以这样走： 
//
// 
// 如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。 
// 如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。 
// 如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。
// 
// 如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。 
//
// 
//
// 返回蛇抵达目的地所需的最少移动次数。 
//
// 如果无法到达目的地，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[0,0,0,0,0,1],
//               [1,1,0,0,1,0],
//               [0,0,0,0,1,1],
//               [0,0,1,0,1,0],
//               [0,1,1,0,0,0],
//               [0,1,1,0,0,0]]
//输出：11
//解释：
//一种可能的解决方案是 [右, 右, 顺时针旋转, 右, 下, 下, 下, 下, 逆时针旋转, 右, 下]。
// 
//
// 示例 2： 
//
// 输入：grid = [[0,0,1,1,1,1],
//               [0,0,0,0,1,1],
//               [1,1,0,0,0,1],
//               [1,1,1,0,0,1],
//               [1,1,1,0,0,1],
//               [1,1,1,0,0,0]]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 0 <= grid[i][j] <= 1 
// 蛇保证从空单元格开始出发。 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 66 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumMovesToReachTargetWithRotations;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author JUE
 * @number 1210
 */
public class MinimumMovesToReachTargetWithRotations {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final String[] POSITION = {"→", "↓", "←", "↑"};

    public int minimumMoves(int[][] grid) {
        // 开始距离 [0,0][0,1]; 有序数组, 右边是头, 旋转的时候尾部不动，头部换位
        // 初始位置是 [0][1][0] = 0; 其他位置必须大于零
        // int row = grid.length, col = grid[0].length;
        // 题目给定 n * n; 不会出现row != col， 不会出现出口等于入口的情况。
        int n = grid.length;
        // 记录走到当前状态需要的步数, 尾巴有左上右下四个方向[0,1,2,3]每个记录为不同的方向
        int[][][] countMove = new int[n][n][4];
        // 四个方向尝试走过, 等于0时写入, 注意: 我们使用广度遍历的方式, 先入先出, 这样只要写过数据便是最短的
        Queue<int[]> queue = new ArrayDeque<>();
        // row, col, end, count
        queue.add(new int[]{0, 1, 0, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], end = current[2], count = current[3];
            System.out.printf("[%s,%s]: %s; %s%n", row, col, POSITION[end], count);
            if (row == 0 && col == 1 && end == 0) {
                countMove[0][1][0] = 1; // 首位是特例!
            } else {
                countMove[row][col][end] = count;
            }
            // 问题: 会倒退一步吗? 暂定不计算倒退一步; 暂定头和尾可以同时垂直平移
            // 删除了向左和向上的处理
            // 四个位置展开
            switch (end) {
                case 0:
                    // 如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。
                    if (col < n - 1 && grid[row][col + 1] == 0) {
                        // System.out.printf("next [%s,%s]: %s; %s%n", row, col + 1, POSITION[end], countMove[row][col + 1][end]);
                        if (countMove[row][col + 1][end] == 0) {
                            queue.add(new int[]{row, col + 1, end, count + 1});
                        }
                    }
//                    // 如果没有障碍，则向`上`移动一个单元格。并仍然保持身体的水平／竖直状态。
//                    if (row > 0 && grid[row - 1][col] == 0 && grid[row - 1][col - 1] == 0) {
//                        if (countMove[row - 1][col][end] == 0) {
//                            queue.add(new int[]{row - 1, col, end, count + 1});
//                        }
//                    }
                    // 如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。
                    if (row < n - 1 && grid[row + 1][col] == 0 && grid[row + 1][col - 1] == 0) {
                        if (countMove[row + 1][col][end] == 0) {
                            queue.add(new int[]{row + 1, col, end, count + 1});
                        }
                    }
                    // 如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。
                    if (row < n - 1 && grid[row + 1][col] == 0 && grid[row + 1][col - 1] == 0) {
                        if (countMove[row + 1][col - 1][1] == 0) {
                            queue.add(new int[]{row + 1, col - 1, 1, count + 1});
                        }
                    }
                    break;
                case 1:
                    // 如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。
                    if (row < n - 1 && grid[row + 1][col] == 0) {
                        if (countMove[row + 1][col][end] == 0) {
                            queue.add(new int[]{row + 1, col, end, count + 1});
                        }
                    }
                    // 如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。
                    if (col < n - 1 && grid[row][col + 1] == 0 && grid[row - 1][col + 1] == 0) {
                        if (countMove[row][col + 1][end] == 0) {
                            queue.add(new int[]{row, col + 1, end, count + 1});
                        }
                    }
//                    // 如果没有障碍，则向`左`移动一个单元格。并仍然保持身体的水平／竖直状态。
//                    if (col > 0 && grid[row][col - 1] == 0 && grid[row - 1][col - 1] == 0) {
//                        if (countMove[row][col - 1][end] == 0) {
//                            queue.add(new int[]{row, col - 1, end, count + 1});
//                        }
//                    }
                    // 如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。
                    if (col < n - 1 && grid[row][col + 1] == 0 && grid[row - 1][col + 1] == 0) {
                        if (countMove[row - 1][col + 1][0] == 0) {
                            queue.add(new int[]{row - 1, col + 1, 0, count + 1});
                        }
                    }
                    break;
                case 2:
//                    // 如果没有障碍，则向`上`移动一个单元格。并仍然保持身体的水平／竖直状态。
//                    if (row > 0 && grid[row - 1][col] == 0 && grid[row - 1][col + 1] == 0) {
//                        if (countMove[row - 1][col][end] == 0) {
//                            queue.add(new int[]{row - 1, col, end, count + 1});
//                        }
//                    }
                    // 如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。
                    if (row < n - 1 && grid[row + 1][col] == 0 && grid[row + 1][col + 1] == 0) {
                        if (countMove[row + 1][col][end] == 0) {
                            queue.add(new int[]{row + 1, col, end, count + 1});
                        }
                    }
//                    // 如果没有障碍，则向`左`移动一个单元格。并仍然保持身体的水平／竖直状态。
//                    if (col > 0 && grid[row][col - 1] == 0) {
//                        if (countMove[row][col - 1][end] == 0) {
//                            queue.add(new int[]{row, col - 1, end, count + 1});
//                        }
//                    }
//                    // 如果它处于水平状态并且其`上`面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。
//                    if (row < n - 1 && grid[row + 1][col] == 0 && grid[row + 1][col - 1] == 0) {
//                        if (countMove[row - 1][col - 1][3] == 0) {
//                            queue.add(new int[]{row - 1, col - 1, 3, count + 1});
//                        }
//                    }
                    break;
                case 3:
//                    // 如果没有障碍，则向`上`移动一个单元格。并仍然保持身体的水平／竖直状态。
//                    if (row > 0 && grid[row - 1][col] == 0) {
//                        if (countMove[row - 1][col][end] == 0) {
//                            queue.add(new int[]{row - 1, col, end, count + 1});
//                        }
//                    }
                    // 如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。
                    if (col < n - 1 && grid[row][col + 1] == 0 && grid[row + 1][col + 1] == 0) {
                        if (countMove[row][col + 1][end] == 0) {
                            queue.add(new int[]{row, col + 1, end, count + 1});
                        }
                    }
//                    // 如果没有障碍，则向`左`移动一个单元格。并仍然保持身体的水平／竖直状态。
//                    if (col > 0 && grid[row][col - 1] == 0 && grid[row + 1][col - 1] == 0) {
//                        if (countMove[row][col - 1][end] == 0) {
//                            queue.add(new int[]{row, col - 1, end, count + 1});
//                        }
//                    }
                    // 如果它处于竖直状态并且其`左`面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。
                    if (col > 0 && grid[row][col - 1] == 0 && grid[row + 1][col - 1] == 0) {
                        if (countMove[row + 1][col - 1][2] == 0) {
                            queue.add(new int[]{row + 1, col - 1, 2, count + 1});
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        // 移动到 (n-1, n-2) 和 (n-1, n-1) count[n-1][n-1][0];
        int result = countMove[n - 1][n - 1][0];
        return result == 0 ? -1 : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
