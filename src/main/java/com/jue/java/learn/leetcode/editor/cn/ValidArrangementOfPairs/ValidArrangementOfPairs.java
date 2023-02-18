//给你一个下标从 0 开始的二维整数数组 pairs ，其中 pairs[i] = [starti, endi] 。如果 pairs 的一个重新排列，满足对每
//一个下标 i （ 1 <= i < pairs.length ）都有 endi-1 == starti ，那么我们就认为这个重新排列是 pairs 的一个 合法
//重新排列 。 
//
// 请你返回 任意一个 pairs 的合法重新排列。 
//
// 注意：数据保证至少存在一个 pairs 的合法重新排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：pairs = [[5,1],[4,5],[11,9],[9,4]]
//输出：[[11,9],[9,4],[4,5],[5,1]]
//解释：
//输出的是一个合法重新排列，因为每一个 endi-1 都等于 starti 。
//end0 = 9 == 9 = start1 
//end1 = 4 == 4 = start2
//end2 = 5 == 5 = start3
// 
//
// 示例 2： 
//
// 
//输入：pairs = [[1,3],[3,2],[2,1]]
//输出：[[1,3],[3,2],[2,1]]
//解释：
//输出的是一个合法重新排列，因为每一个 endi-1 都等于 starti 。
//end0 = 3 == 3 = start1
//end1 = 2 == 2 = start2
//重新排列后的数组 [[2,1],[1,3],[3,2]] 和 [[3,2],[2,1],[1,3]] 都是合法的。
// 
//
// 示例 3： 
//
// 
//输入：pairs = [[1,2],[1,3],[2,1]]
//输出：[[1,2],[2,1],[1,3]]
//解释：
//输出的是一个合法重新排列，因为每一个 endi-1 都等于 starti 。
//end0 = 2 == 2 = start1
//end1 = 1 == 1 = start2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pairs.length <= 10⁵ 
// pairs[i].length == 2 
// 0 <= starti, endi <= 10⁹ 
// starti != endi 
// pairs 中不存在一模一样的数对。 
// 至少 存在 一个合法的 pairs 重新排列。 
// 
//
// Related Topics 深度优先搜索 图 欧拉回路 👍 44 👎 0


package com.jue.java.learn.leetcode.editor.cn.ValidArrangementOfPairs;

import java.util.*;

/**
 * @author JUE
 * @number 2097
 */
public class ValidArrangementOfPairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{5, 1}, {4, 5}, {11, 9}, {9, 4}})));
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{1, 3}, {3, 2}, {2, 1}})));
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{1, 2}, {1, 3}, {2, 1}})));
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{17, 18}, {18, 10}, {10, 18}})));
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{8, 5}, {8, 7}, {0, 8}, {0, 5}, {7, 0}, {5, 0}, {0, 7}, {8, 0}, {7, 8}})));
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{5, 13}, {10, 6}, {11, 3}, {15, 19}, {16, 19}, {1, 10}, {19, 11}, {4, 16}, {19, 9}, {5, 11}, {5, 6}, {13, 5}, {13, 9}, {9, 15}, {11, 16}, {6, 9}, {9, 13}, {3, 1}, {16, 5}, {6, 5}})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Map<Integer, Queue<Integer>> edges = new HashMap<>();
    List<int[]> result = new ArrayList<>();

    public int[][] validArrangement(int[][] pairs) {
        // 欧拉联通图 https://oi-wiki.org/graph/euler/ , 出度比入度大1为起点
        // 深度优先队列, 在找不到新的起点继续出栈
        Map<Integer, Integer> outDiff = new HashMap<>();
        for (int[] pair : pairs) {
            edges.putIfAbsent(pair[0], new ArrayDeque<>());
            edges.get(pair[0]).add(pair[1]);
            outDiff.put(pair[0], outDiff.getOrDefault(pair[0], 0) + 1);
            outDiff.put(pair[1], outDiff.getOrDefault(pair[1], 0) - 1);
        }
        int begin = pairs[0][0];
        for (Map.Entry<Integer, Integer> diff : outDiff.entrySet()) {
            if (diff.getValue() == 1) {
                begin = diff.getKey();
                break;
            }
        }
        dfs(begin);
        // 翻转
        int len = pairs.length;
        pairs = new int[len][2];
        for (int index = 0; index < len; index++) {
            pairs[index] = result.get(index);
        }
        return pairs;
    }

    private void dfs(int begin) {
        Queue<Integer> queue = edges.get(begin);
        while (queue != null && !queue.isEmpty()) {
            int next = queue.poll();
            dfs(next);
            // 注意! 如果之前那条路不通, 他将不会写入
            // 在尝试使用新的路的时候 (相当于这个点对外的路径还没有走完, 又来了, 能走完的这个环需要优先走完)
            result.add(0, new int[]{begin, next});
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
