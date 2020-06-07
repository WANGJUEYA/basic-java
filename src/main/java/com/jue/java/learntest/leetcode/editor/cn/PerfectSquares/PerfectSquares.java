//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划


package com.jue.java.learntest.leetcode.editor.cn.PerfectSquares;

/**
 * @author JUE
 * @number 279
 */
public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(18));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numSquares(int n) {
        int[] num = new int[n + 1];
        for (int index = 0; index <= n; index++) {
            // 最多为 index 个 1相加
            int min = index;
            for (int j = 1; index - j * j >= 0; j++) {
                min = Math.min(min, num[index - j * j] + 1);
            }
            num[index] = min;
        }
        return num[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
