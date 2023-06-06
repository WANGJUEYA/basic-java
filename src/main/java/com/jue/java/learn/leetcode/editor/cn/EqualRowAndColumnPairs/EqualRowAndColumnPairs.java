//给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。 
//
// 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
//输出：1
//解释：存在一对相等行列对：
//- (第 2 行，第 1 列)：[2,7,7]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
//输出：3
//解释：存在三对相等行列对：
//- (第 0 行，第 0 列)：[3,1,2,2]
//- (第 2 行, 第 2 列)：[2,4,2,2]
//- (第 3 行, 第 2 列)：[2,4,2,2]
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 矩阵 模拟 👍 68 👎 0


package com.jue.java.learn.leetcode.editor.cn.EqualRowAndColumnPairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author JUE
 * @number 2352
 */
public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equalPairs(new int[][]{{11, 1}, {1, 11}}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> store = new HashMap<>();
        for (int[] g : grid) {
            String key = Arrays.stream(g).mapToObj(String::valueOf).collect(Collectors.joining(","));
            store.put(key, store.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (int index = 0, len = grid.length; index < len; index++) {
            int i = index;
            String key = IntStream.range(0, len).mapToObj(j -> String.valueOf(grid[j][i])).collect(Collectors.joining(","));
            count += store.getOrDefault(key, 0);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
