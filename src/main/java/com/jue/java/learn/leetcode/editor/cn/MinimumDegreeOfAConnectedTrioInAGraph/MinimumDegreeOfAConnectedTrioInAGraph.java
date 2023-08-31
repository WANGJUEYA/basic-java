//给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条
//无向边。
//
// 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
//
// 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
//
// 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
//输出：3
//解释：只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。
//
//
// 示例 2：
//
//
//输入：n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
//输出：0
//解释：有 3 个三元组：
//1) [1,4,3]，度数为 0 。
//2) [2,5,6]，度数为 2 。
//3) [5,6,7]，度数为 2 。
//
//
//
//
// 提示：
//
//
// 2 <= n <= 400
// edges[i].length == 2
// 1 <= edges.length <= n * (n-1) / 2
// 1 <= ui, vi <= n
// ui != vi
// 图中没有重复的边。
//
//
// Related Topics 图 👍 47 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumDegreeOfAConnectedTrioInAGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 1761
 */
public class MinimumDegreeOfAConnectedTrioInAGraph {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minTrioDegree(6, new int[][]{{1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6}})); // 3
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        // 存储所有的边；没有自己到自己的边
        Map<Integer, List<Integer>> pointOfEdges = new HashMap<>(edges.length);
        for (int[] edge : edges) {
            pointOfEdges.putIfAbsent(edge[0], new ArrayList<>());
            pointOfEdges.putIfAbsent(edge[1], new ArrayList<>());
            pointOfEdges.get(edge[0]).add(edge[1]);
            pointOfEdges.get(edge[1]).add(edge[0]);
        }
        // 遍历所有点判断有没有三元组
        Integer[] points = pointOfEdges.keySet().toArray(new Integer[0]);
        int len = points.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (pointOfEdges.get(points[i]).contains(points[j])
                            && pointOfEdges.get(points[i]).contains(points[k])
                            && pointOfEdges.get(points[j]).contains(points[k])) {
                        int current = pointOfEdges.get(points[i]).size()
                                + pointOfEdges.get(points[j]).size()
                                + pointOfEdges.get(points[k]).size()
                                // 没有重复边，减去两个顶点都在联通图的数据
                                - 6;
                        if (current == 0) {
                            return 0;
                        }
                        min = Math.min(min, current);
                    }
                }
            }
        }
        return min > edges.length ? -1 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
