//给你一个 n 个节点的无向带权图，节点编号为 0 到 n - 1 。图中总共有 m 条边，用二维数组 edges 表示，其中 edges[i] = [ai,
// bi, wi] 表示节点 ai 和 bi 之间有一条边权为 wi 的边。 
//
// 对于节点 0 为出发点，节点 n - 1 为结束点的所有最短路，你需要返回一个长度为 m 的 boolean 数组 answer ，如果 edges[i]
// 至少 在其中一条最短路上，那么 answer[i] 为 true ，否则 answer[i] 为 false 。 
//
// 请你返回数组 answer 。 
//
// 注意，图可能不连通。 
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入：n = 6, edges = [[0,1,4],[0,2,1],[1,3,2],[1,4,3],[1,5,1],[2,3,1],[3,5,3],[4
//,5,2]] 
// 
//
// 输出：[true,true,true,false,true,true,true,false] 
//
// 解释： 
//
// 以下为节点 0 出发到达节点 5 的 所有 最短路： 
//
// 
// 路径 0 -> 1 -> 5 ：边权和为 4 + 1 = 5 。 
// 路径 0 -> 2 -> 3 -> 5 ：边权和为 1 + 1 + 3 = 5 。 
// 路径 0 -> 2 -> 3 -> 1 -> 5 ：边权和为 1 + 1 + 2 + 1 = 5 。 
// 
//
// 示例 2： 
//
// 
//
// 
// 输入：n = 4, edges = [[2,0,1],[0,1,1],[0,3,4],[3,2,2]] 
// 
//
// 输出：[true,false,false,true] 
//
// 解释： 
//
// 只有一条从节点 0 出发到达节点 3 的最短路 0 -> 2 -> 3 ，边权和为 1 + 2 = 3 。 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 5 * 10⁴ 
// m == edges.length 
// 1 <= m <= min(5 * 10⁴, n * (n - 1) / 2) 
// 0 <= ai, bi < n 
// ai != bi 
// 1 <= wi <= 10⁵ 
// 图中没有重边。 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 👍 6 👎 0


package com.jue.java.learn.leetcode.editor.cn.FindEdgesInShortestPaths;

import java.util.*;

/**
 * @author JUE
 * @number 3123
 */
public class FindEdgesInShortestPaths {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findAnswer(6, new int[][]{{0, 1, 4}, {0, 2, 1}, {1, 3, 2}, {1, 4, 3}, {1, 5, 1}, {2, 3, 1}, {3, 5, 3}, {4, 5, 2}})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {

    Map<Integer, List<int[]>> weight;

    public boolean[] findAnswer(int n, int[][] edges) {
        // Dijskstra 算法: 计算某个点到其他所有点的最短路径；+ dfs： 计算最短路径之后
        int max = Integer.MAX_VALUE / 2; // 防止溢出
        weight = new HashMap<>();
        for (int[] edge : edges) {
            weight.putIfAbsent(edge[0], new ArrayList<>());
            weight.putIfAbsent(edge[1], new ArrayList<>());
            weight.get(edge[0]).add(new int[]{edge[1], edge[2]});
            weight.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] dist_0 = new int[n];
        int[] dist_n = new int[n];
        for (int i = 0; i < n; i++) {
            dist_0[i] = max;
            dist_n[i] = max;
        }
        dijkstra(dist_0, 0);
        dijkstra(dist_n, n - 1);

        boolean[] result = new boolean[edges.length];
        if (dist_0[n - 1] == max) {
            return result;
        }

        // 防止超时，从最后一个广度遍历
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(n - 1);
        int min = dist_0[n - 1];
        int index = -1;
        for (int[] edge : edges) {
            result[++index] = Math.min(dist_0[edge[0]] + dist_n[edge[1]], dist_0[edge[1]] + dist_n[edge[0]]) == min - edge[2];
        }
        return result;
    }

    protected void dijkstra(int[] dist, int point) {
        // dijkstra 优先队列
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int[]{0, point});
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int i = next[1];
            if (next[0] < dist[i]) {
                dist[i] = next[0];
                if (weight.containsKey(i)) {
                    // 用邻接表超出内存限制
                    for (int[] edge : weight.get(i)) {
                        queue.add(new int[]{next[0] + edge[1], edge[0]});
                    }
                }
            }
        }
    }
}

class Solution_Timeout {

    int total;
    int[][] weight;
    int[] count;
    Set<String> all;

    public boolean[] findAnswer(int n, int[][] edges) {
        all = new HashSet<>();
        total = n;
        weight = new int[n][n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = Integer.MAX_VALUE;
        }
        for (int[] path : edges) {
            weight[path[0]][path[1]] = path[2];
            weight[path[1]][path[0]] = path[2];
        }
        List<Integer> begin = new ArrayList<>();
        begin.add(0);
        dfs(begin, 0, 0);
        boolean[] result = new boolean[edges.length];
        for (int i = 0, len = edges.length; i < len; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            String flag = Math.min(a, b) + "," + Math.max(a, b);
            if (all.contains(flag)) {
                result[i] = true;
            }
        }
        return result;
    }

    // 深度遍历
    protected void dfs(List<Integer> path, int point, int preCount) {
        System.out.println("point >> " + point + "; path >> " + path);
        for (int j = 0; j < total; j++) {
            // 如果有下一个通路
            if (weight[point][j] > 0) {
                int nextCount = preCount + weight[point][j];
                // 减枝，判断已经走过的
                if (nextCount < count[j]) {
                    count[j] = preCount + weight[point][j];
                    if (j == total - 1) {
                        all = new HashSet<>();
                    }
                }
                if (nextCount <= count[j]) {
                    if (j == total - 1) {
                        for (int i = 0, len = path.size(); i < len; i++) {
                            int a = path.get(i);
                            int b = i == 0 ? j : path.get(i - 1);
                            all.add(Math.min(a, b) + "," + Math.max(a, b));
                        }
                        System.out.println("j >> " + j + "; all >> " + all);
                    } else {
                        path.add(0, j);
                        dfs(path, j, nextCount);
                        path.remove(0);
                    }
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
