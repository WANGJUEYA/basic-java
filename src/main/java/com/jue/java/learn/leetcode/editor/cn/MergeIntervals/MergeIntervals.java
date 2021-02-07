//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


package com.jue.java.learn.leetcode.editor.cn.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author JUE
 * @number 56
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 17}})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
        int len = 0;
        int[][] result = new int[len][2];
        for (int[] ints : intervals) {
            if (len == 0 || ints[0] > result[len - 1][1]) {
                result = Arrays.copyOf(result, ++len);
                result[len - 1] = new int[]{ints[0], ints[1]};
            } else {
                result[len - 1][1] = Math.max(result[len - 1][1], ints[1]);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
