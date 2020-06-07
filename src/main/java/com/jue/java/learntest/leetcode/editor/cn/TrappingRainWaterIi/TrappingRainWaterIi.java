//给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。 
//
// 
//
// 示例： 
//
// 给出如下 3x6 的高度图:
//[
//  [1,4,3,1,3,2],
//  [3,2,1,3,2,4],
//  [2,3,3,2,3,1]
//]
//
//返回 4 。
// 
//
// 
//
// 如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。 
//
// 
//
// 
//
// 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 110 
// 0 <= heightMap[i][j] <= 20000 
// 
// Related Topics 堆 广度优先搜索


package com.jue.java.learntest.leetcode.editor.cn.TrappingRainWaterIi;

/**
 * @author JUE
 * @number 407
 */
public class TrappingRainWaterIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        int[][] array1 = {{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}};
        int[][] array2 = {{5, 5, 5, 1}, {5, 1, 1, 5}, {5, 1, 5, 5}, {5, 2, 5, 8}};
        int[][] array3 = {{78, 16, 94, 36}, {87, 93, 50, 22}, {63, 28, 91, 60}, {64, 27, 41, 27}, {73, 37, 12, 69}, {68, 30, 83, 31}, {63, 24, 68, 36}};
        System.out.println(solution.trapRainWater(array3));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 1. 将边界初始成-1
    // 2. 给定一个能用的方块, 其最小可用高度为边界最小值(可接雨水置为1，不可接置为-1)
    // 3. 扩展，如果给定扩展是边界,比较更小, 如果非边界且相等，状态更新为 1，更高或更矮更新为2
    // 4. 根据最小边界值 为无限大或零, 开始填高
    public int trapRainWater(int[][] heightMap) {
        // 初始化第一张状态图
        int row = heightMap.length;
        int col = heightMap[0].length;
        int[][] statusMap = new int[row][col];
        int total = 0;
        for (int index = 0; index < col; index++) {
            statusMap[0][index] = -1;
            statusMap[row - 1][index] = -1;
        }
        for (int index = 1; index < row - 1; index++) {
            statusMap[index][0] = -1;
            statusMap[index][col - 1] = -1;
        }
        while (!full(statusMap, row, col)) {
            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    if (statusMap[i][j] != -1) {
                        int min = trapRainWater(heightMap, statusMap, i, j, row, col, heightMap[i][j]);
                        // System.out.println("min: ==> " + min);
                        total += change(heightMap, statusMap, row, col, min >= heightMap[i][j] ? min : 0);
                        // System.out.println("total: " + total);
                    }
                }
            }
        }
        return total;
    }

    //返回可填充的最小高度
    public int trapRainWater(int[][] heightMap, int[][] statusMap, int i, int j, int row, int col, int val) {
        // System.out.println("(i,j)  ==> (" + i + "," + j + ")");
        if (i < 0 || i >= row || j < 0 || j >= col || statusMap[i][j] == 1 || statusMap[i][j] == 2) {
            return Integer.MAX_VALUE;
        }
        if (statusMap[i][j] == -1) {
            return heightMap[i][j];
        }
        if (statusMap[i][j] == 0) {
            if (heightMap[i][j] <= val) {
                statusMap[i][j] = heightMap[i][j] == val ? 1 : 2;
                int min1 = trapRainWater(heightMap, statusMap, i - 1, j, row, col, val);
                // System.out.println("min1: " + min1);
                int min2 = trapRainWater(heightMap, statusMap, i + 1, j, row, col, val);
                // System.out.println("min2: " + min2);
                int min3 = trapRainWater(heightMap, statusMap, i, j - 1, row, col, val);
                // System.out.println("min3: " + min3);
                int min4 = trapRainWater(heightMap, statusMap, i, j + 1, row, col, val);
                // System.out.println("min4: " + min4);
                int min = min(min1, min2, min3, min4);
                // System.out.println("min1-4: " + min1 + " " + min2 + " " + min3 + " " + min4);
                // System.out.println("min: " + min);
                // System.out.println();
                return min;
            } else {
                statusMap[i][j] = 2;
                return heightMap[i][j];
            }
        }
        return Integer.MAX_VALUE;
    }

    public int change(int[][] heightMap, int[][] statusMap, int row, int col, int minHeight) {
        int total = 0;
        boolean status = (minHeight > 0 && minHeight < Integer.MAX_VALUE);
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (statusMap[i][j] == 1) {
                    boolean flag = (statusMap[i - 1][j] == -1 && heightMap[i - 1][j] <= heightMap[i][j])
                            || (statusMap[i + 1][j] == -1 && heightMap[i + 1][j] <= heightMap[i][j])
                            || (statusMap[i][j - 1] == -1 && heightMap[i][j - 1] <= heightMap[i][j])
                            || (statusMap[i][j + 1] == -1 && heightMap[i][j + 1] <= heightMap[i][j]);
                    statusMap[i][j] = flag || !status ? -1 : 0;
                    if (status) {
                        total += minHeight - heightMap[i][j];
                        heightMap[i][j] = minHeight;
                    }
                } else if (statusMap[i][j] == 2) {
                    statusMap[i][j] = 0;
                }
            }
        }
        return total;
    }

    public boolean full(int[][] statusMap, int row, int col) {
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (statusMap[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int min(int... val) {
        int min = Integer.MAX_VALUE;
        for (int v : val) {
            min = Math.min(v, min);
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
