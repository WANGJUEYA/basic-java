//有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中
//edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
//
// 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。
//
// 给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回
//true，否则返回 false 。
//
//
//
// 示例 1：
//
//
//输入：n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
//输出：true
//解释：存在由顶点 0 到顶点 2 的路径:
//- 0 → 1 → 2
//- 0 → 2
//
//
// 示例 2：
//
//
//输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
//
//输出：false
//解释：不存在由顶点 0 到顶点 5 的路径.
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2 * 10⁵
// 0 <= edges.length <= 2 * 10⁵
// edges[i].length == 2
// 0 <= ui, vi <= n - 1
// ui != vi
// 0 <= source, destination <= n - 1
// 不存在重复边
// 不存在指向顶点自身的边
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 66 👎 0


package com.jue.java.learn.leetcode.editor.cn.FindIfPathExistsInGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author JUE
 * @number 1971
 */
public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        // TODO 并查集
        Solution solution = new Solution();
        System.out.println(solution.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2)); // true
        System.out.println(solution.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5)); // false
        System.out.println(solution.validPath(1, new int[0][0], 0, 0)); // true
        System.out.println(solution.validPath(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5)); // true
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        Map<Integer, Set<Integer>> pointWithNext = new HashMap<>();
        for (int[] edge : edges) {
            // 双向边
            Set<Integer> next = pointWithNext.getOrDefault(edge[0], new HashSet<>());
            next.add(edge[1]);
            pointWithNext.put(edge[0], next);
            next = pointWithNext.getOrDefault(edge[1], new HashSet<>());
            next.add(edge[0]);
            pointWithNext.put(edge[1], next);
        }
        if (pointWithNext.containsKey(source)) {
            Set<Integer> toPost = pointWithNext.get(source);
            Set<Integer> posted = new HashSet<>();
            while (!toPost.isEmpty()) {
                Set<Integer> newToPost = new HashSet<>();
                for (int post : toPost) {
                    if (post == destination) {
                        return true;
                    }
                    if (!posted.contains(post) && pointWithNext.containsKey(post)) {
                        newToPost.addAll(pointWithNext.get(post));
                    }
                    posted.add(post);
                }
                toPost = newToPost;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
