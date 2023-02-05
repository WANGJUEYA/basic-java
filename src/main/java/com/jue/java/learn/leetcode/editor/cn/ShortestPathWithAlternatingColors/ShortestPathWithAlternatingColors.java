//在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。 
//
// red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从
//节点 i 到节点 j 的蓝色有向边。 
//
// 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，
//那么 answer[x] = -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//输出：[0,1,-1]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//输出：[0,1,-1]
// 
//
// 示例 3： 
//
// 
//输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//输出：[0,-1,-1]
// 
//
// 示例 4： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//输出：[0,1,2]
// 
//
// 示例 5： 
//
// 
//输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//输出：[0,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// red_edges.length <= 400 
// blue_edges.length <= 400 
// red_edges[i].length == blue_edges[i].length == 2 
// 0 <= red_edges[i][j], blue_edges[i][j] < n 
// 
//
// Related Topics 广度优先搜索 图 👍 220 👎 0


package com.jue.java.learn.leetcode.editor.cn.ShortestPathWithAlternatingColors;

import java.util.*;

/**
 * @author JUE
 * @number 1129
 */
public class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // [0,1,2,1,1]
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(5, new int[][]{{2, 2}, {0, 1}, {0, 3}, {0, 0}, {0, 4}, {2, 1}, {2, 0}, {1, 4}, {3, 4}}, new int[][]{{1, 3}, {0, 0}, {0, 3}, {4, 2}, {1, 0}})));
        // 0,1,2,3,7
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{1, 2}, {2, 3}, {3, 1}})));
        //
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[n];
        for (int index = 1; index < n; index++) {
            result[index] = -1;
        }
        // 未处理的数据, 第二位为正表示红色, 下一条有向路径在蓝色种寻找
        Queue<int[]> queue = new ArrayDeque<>();
        // 处理有向路径
        for (int[] red : redEdges) {
            if (red[0] == 0 && red[1] == 0) {
                continue;
            }
            int start = red[0] == 0 ? Integer.MAX_VALUE : red[0];
            int end = red[1] == 0 ? Integer.MAX_VALUE : red[1];
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(end);
            if (red[0] == 0) {
                queue.add(new int[]{end, 1});
            }
        }
        for (int[] blue : blueEdges) {
            int start = blue[0] == 0 ? Integer.MAX_VALUE : blue[0];
            int end = blue[1] == 0 ? Integer.MAX_VALUE : blue[1];
            map.putIfAbsent(-start, new ArrayList<>());
            map.get(-start).add(-end);
            if (blue[0] == 0) {
                queue.add(new int[]{-end, 1});
            }
        }
        Set<Integer> found = new HashSet<>();
        // 开始寻找
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int count = temp[1];
            int next = temp[0];
            int index = Math.abs(next);
            // 如果原不可达或路径更短, 更新路径
            if (index < n && (result[index] == -1 || count < result[index])) {
                result[index] = count;
            }

            // 取相反的颜色
            for (int item : map.getOrDefault(-next, new ArrayList<>())) {
                int itemAbs = Math.abs(item);
                itemAbs = itemAbs >= n ? 0 : itemAbs;
                if (!found.contains(item) || result[itemAbs] == -1 || result[itemAbs] > count + 1) {
                    queue.add(new int[]{item, count + 1});
                }
            }
            found.add(next);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
