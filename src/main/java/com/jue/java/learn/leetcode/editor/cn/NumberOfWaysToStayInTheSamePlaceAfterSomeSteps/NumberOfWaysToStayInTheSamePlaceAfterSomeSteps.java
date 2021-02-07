//有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。 
//
// 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。 
//
// 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。 
//
// 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：steps = 3, arrLen = 2
//输出：4
//解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
//向右，向左，不动
//不动，向右，向左
//向右，不动，向左
//不动，不动，不动
// 
//
// 示例 2： 
//
// 输入：steps = 2, arrLen = 4
//输出：2
//解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
//向右，向左
//不动，不动
// 
//
// 示例 3： 
//
// 输入：steps = 4, arrLen = 2
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= steps <= 500 
// 1 <= arrLen <= 10^6 
// 
// Related Topics 动态规划


package com.jue.java.learn.leetcode.editor.cn.NumberOfWaysToStayInTheSamePlaceAfterSomeSteps;

/**
 * @author JUE
 * @number 1269
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(3, 2));
        System.out.println(solution.numWays(47, 38));
        System.out.println(solution.numWays(438, 3159));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int steps, int arrLen) {
        int len = Math.min(steps + 1, arrLen);
        int[] base = new int[len];
        int[] newest;
        base[0] = 1;
        base[1] = 1;
        for (int i = 1; i < steps - 1; i++) {
            newest = new int[len];
            for (int j = 0; j < len; j++) {
                long temp = base[j];
                if (j - 1 >= 0) {
                    temp += base[j - 1];
                }
                if (j + 1 < len) {
                    temp += base[j + 1];
                }
                newest[j] = (int) (temp % (1E9 + 7));
            }
            base = newest;
        }
        return (int) ((base[0] + base[1]) % (1E9 + 7));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
