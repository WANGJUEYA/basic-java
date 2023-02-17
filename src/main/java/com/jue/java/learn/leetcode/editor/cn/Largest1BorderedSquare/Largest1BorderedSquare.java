//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 185 👎 0


package com.jue.java.learn.leetcode.editor.cn.Largest1BorderedSquare;

import java.util.*;

/**
 * @author JUE
 * @number 1139
 */
public class Largest1BorderedSquare {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largest1BorderedSquare(new int[][]{{1, 1}, {1, 0}})); // 1
        System.out.println(solution.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})); // 9
        System.out.println(solution.largest1BorderedSquare(new int[][]{{1, 1, 0, 0}})); // 1
        System.out.println(solution.largest1BorderedSquare(new int[][]{{0, 0, 0, 1}})); // 1
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int result = 0;
        // 先把数组按照行列归纳
        Set<String> point = new HashSet<>();
        // 存储每一行的连续数字
        Map<Integer, List<List<Integer>>> rowMap = new HashMap<>();
        int rowSize = grid.length;
        int colSize = grid[0].length;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 1) {
                    result = 1;
                    List<List<Integer>> current = rowMap.getOrDefault(i, new ArrayList<>());
                    List<Integer> item = new ArrayList<>();
                    // 每次放在队首
                    if (!current.isEmpty() && current.get(0).get(0) == j - 1) {
                        item = current.get(0);
                    } else {
                        current.add(0, item);
                    }
                    item.add(0, j);
                    rowMap.put(i, current);
                    point.add(i + "," + j);
                }
            }
        }
        // 找每行的最大连续列数, 尝试拼接(每次只向下且向右拼接, 即 row+x,col+x)
        for (Map.Entry<Integer, List<List<Integer>>> item : rowMap.entrySet()) {
            // 开始遍历每个数组
            int rowBegin = item.getKey();
            for (List<Integer> sub : item.getValue()) {
                // 开始暴力求解, 应当有最优解
                int len = sub.size();
                int test = len + 1;
                int colBegin = sub.get(len - 1);
                while (--test > result) {
                    for (int colEnd : sub) {
                        if (colEnd + 1 - test < colBegin || rowBegin + test - 1 > rowSize) {
                            // 如果超出线了
                            break;
                        }
                        int thisColBegin = colEnd + 1 - test;
                        // 上边已经满了
                        boolean success = true;
                        for (int add = 0; add < test; add++) {
                            // 查询下边
                            success = point.contains((rowBegin + test - 1) + "," + (thisColBegin + add));
                            // 查询左边
                            success = success && point.contains((rowBegin + add) + "," + thisColBegin);
                            // 查询右边
                            success = success && point.contains((rowBegin + add) + "," + colEnd);
                            if (!success) {
                                break;
                            }
                        }
                        if (success) {
                            result = test;
                            break;
                        }
                    }
                }
            }
        }
        return result == 0 ? 0 : result * result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
