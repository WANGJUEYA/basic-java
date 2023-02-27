//给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。一只青蛙从 0 号点第二条跑道 出发 ，它想要跳到点 n 处
//。然而道路上可能有一些障碍。
//
// 给你一个长度为 n + 1 的数组 obstacles ，其中 obstacles[i] （取值范围从 0 到 3）表示在点 i 处的
//obstacles[i] 跑道上有一个障碍。如果 obstacles[i] == 0 ，那么点 i 处没有障碍。任何一个点的三条跑道中 最多有一个 障碍。
//
//
// 比方说，如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。
//
//
// 这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍。为了躲避障碍，这只青蛙也可以在 同一个 点处 侧跳 到 另外
//一条 跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。
//
//
// 比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。
//
//
// 这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数 。
//
// 注意：点 0 处和点 n 处的任一跑道都不会有障碍。
//
//
//
// 示例 1：
//
//
//输入：obstacles = [0,1,2,3,0]
//输出：2
//解释：最优方案如上图箭头所示。总共有 2 次侧跳（红色箭头）。
//注意，这只青蛙只有当侧跳时才可以跳过障碍（如上图点 2 处所示）。
//
//
// 示例 2：
//
//
//输入：obstacles = [0,1,1,3,3,0]
//输出：0
//解释：跑道 2 没有任何障碍，所以不需要任何侧跳。
//
//
// 示例 3：
//
//
//输入：obstacles = [0,2,1,0,3,0]
//输出：2
//解释：最优方案如上图所示。总共有 2 次侧跳。
//
//
//
//
// 提示：
//
//
// obstacles.length == n + 1
// 1 <= n <= 5 * 10⁵
// 0 <= obstacles[i] <= 3
// obstacles[0] == obstacles[n] == 0
//
//
// Related Topics 贪心 数组 动态规划 👍 112 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumSidewayJumps;

/**
 * @author JUE
 * @number 1824
 */
public class MinimumSidewayJumps {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSideJumps(new int[]{0, 1, 2, 3, 0}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final Integer NEVER_ARRIVE = Integer.MAX_VALUE / 2;

    public int minSideJumps(int[] obstacles) {
        // 最少侧跳几个点, 动态规划?
        // 记录到达每个点最短需要跳的次数 NEVER_ARRIVE表示无法到达 状态转移方程 -> (dp[n-1][l]) + dp[n-1][c]
        // 注意: 侧跳跑道可以不相邻; 往前跳不计数, 测跳需要消耗一次 返回 最少侧跳次数
        int len = obstacles.length;
        int[][] dp = new int[len + 1][3];
        dp[0][1] = 0;
        dp[0][0] = NEVER_ARRIVE;
        dp[0][2] = NEVER_ARRIVE;
        for (int index = 1; index <= len; index++) {
            int obstacle = obstacles[index - 1] - 1;
            // 没有障碍的第一个点
            for (int run = 0; run < 3; run++) {
                if (obstacle < 0) {
                    // 没有障碍不用跳跃(只会优化前一个点一次)
                    int min = Math.min(dp[index - 1][(run + 1) % 3] + 1, dp[index - 1][(run + 2) % 3] + 1);
                    dp[index][run] = Math.min(min, dp[index - 1][run]);
                } else {
                    if (run == obstacle) {
                        // 有障碍的一个点
                        dp[index][run] = NEVER_ARRIVE;
                    } else {
                        int otherIndex = (run + 1) % 3 != obstacle ? ((run + 1) % 3) : (run + 2) % 3;
                        dp[index][run] = Math.min(dp[index - 1][run], dp[index - 1][otherIndex] + 1);
                    }
                }
            }
        }
        int result = Math.min(dp[len][0], dp[len][1]);
        return Math.min(result, dp[len][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
