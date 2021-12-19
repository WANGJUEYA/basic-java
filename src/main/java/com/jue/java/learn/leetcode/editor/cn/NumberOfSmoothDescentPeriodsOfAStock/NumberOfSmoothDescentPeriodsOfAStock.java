//给你一个整数数组 prices ，表示一支股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格。 
//
// 一个 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制。 
//
// 请你返回 平滑下降阶段 的数目。 
//
// 
//
// 示例 1： 
//
// 输入：prices = [3,2,1,4]
//输出：7
//解释：总共有 7 个平滑下降阶段：
//[3], [2], [1], [4], [3,2], [2,1] 和 [3,2,1]
//注意，仅一天按照定义也是平滑下降阶段。
// 
//
// 示例 2： 
//
// 输入：prices = [8,6,7,7]
//输出：4
//解释：总共有 4 个连续平滑下降阶段：[8], [6], [7] 和 [7]
//由于 8 - 6 ≠ 1 ，所以 [8,6] 不是平滑下降阶段。
// 
//
// 示例 3： 
//
// 输入：prices = [1]
//输出：1
//解释：总共有 1 个平滑下降阶段：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 1 <= prices[i] <= 10⁵ 
// 
// 👍 1 👎 0


package com.jue.java.learn.leetcode.editor.cn.NumberOfSmoothDescentPeriodsOfAStock;

/**
 * @author JUE
 * @number 5958
 */
public class NumberOfSmoothDescentPeriodsOfAStock {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getDescentPeriods(new int[]{3, 2, 1, 4}));
        System.out.println(solution.getDescentPeriods(new int[]{8, 6, 7, 7}));
        System.out.println(solution.getDescentPeriods(new int[]{1}));
        System.out.println(solution.getDescentPeriods(new int[]{}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long getDescentPeriods(int[] prices) {
        // 连续n天的数据: (1,1),(2,3),(3,6),...,(n,n*(n+1)/2)
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        long result = 0;
        long count = 1;
        for (int index = 1; index < len; index++) {
            if (prices[index] + 1 == prices[index - 1]) {
                count++;
            } else {
                result += count % 2 == 0 ? ((count / 2) * (count + 1)) : (count * ((count + 1) / 2));
                count = 1;
            }
        }
        result += count % 2 == 0 ? ((count / 2) * (count + 1)) : (count * ((count + 1) / 2));
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


