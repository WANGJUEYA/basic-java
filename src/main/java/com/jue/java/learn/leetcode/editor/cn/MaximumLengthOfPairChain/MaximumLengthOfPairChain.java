//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 
//
// 示例： 
//
// 
//输入：[[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4]
// 
//
// 
//
// 提示： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 332 👎 0


package com.jue.java.learn.leetcode.editor.cn.MaximumLengthOfPairChain;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author JUE
 * @number 646
 */
public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLongestChain(int[][] pairs) {
        // 数据进行排序
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int size = pairs.length;
        if (size <= 1) {
            return size;
        }
        // 动态规划, 存储最长的数据(每一个格子存储前面有最长的长度)
        int[] dp = new int[size];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < size; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 可以跟随
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
