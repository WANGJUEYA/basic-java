//这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
//
// 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
//
// 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
//
//
//
// 示例 1：
//
//
//
// 输入：grid = [[1,0],[0,1]]
//输出：0
//解释：没有一台服务器能与其他服务器进行通信。
//
// 示例 2：
//
//
//
// 输入：grid = [[1,0],[1,1]]
//输出：3
//解释：所有这些服务器都至少可以与一台别的服务器进行通信。
//
//
// 示例 3：
//
//
//
// 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
//输出：4
//解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m <= 250
// 1 <= n <= 250
// grid[i][j] == 0 or 1
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 计数 矩阵 👍 99 👎 0


package com.jue.java.learn.leetcode.editor.cn.CountServersThatCommunicate;

import java.util.*;

/**
 * @author JUE
 * @number 1267
 */
public class CountServersThatCommunicate {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countServers(new int[][]{{1, 0}, {0, 1}})); // 0
        System.out.println(solution.countServers(new int[][]{{1, 0}, {1, 1}})); // 3
        System.out.println(solution.countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}})); // 4
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 每一行的数据信息
        Map<Integer, List<Integer>> row = new HashMap<>(m);
        // 每一列的数据信息
        Map<Integer, List<Integer>> col = new HashMap<>(n);
        // 存储每行最新的数据
        Set<String> newest = new HashSet<>();
        // 所有服务器数量
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    if (!row.containsKey(i)) {
                        row.put(i, new ArrayList<>());
                        // 如果不包含, 将第一位推入，有可能是不重复
                        newest.add(i + "," + j);
                    }
                    row.get(i).add(j);

                    if (!col.containsKey(j)) {
                        col.put(j, new ArrayList<>());
                        // 如果不包含, 将第一位推入，有可能是不重复
                        newest.add(i + "," + j);
                    }
                    col.get(j).add(i);
                }
            }
        }
        // 移除可能重复的数据
        newest.removeIf(s -> {
            String[] num = s.split(",");
            return row.get(Integer.parseInt(num[0])).size() > 1 || col.get(Integer.parseInt(num[1])).size() > 1;
        });
        // 返回最新的数量
        return count - newest.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
