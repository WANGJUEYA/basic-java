//给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n² 分钟内修好
// n 辆车。
//
// 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
//
// 请你返回修理所有汽车 最少 需要多少时间。
//
// 注意：所有机械工可以同时修理汽车。
//
//
//
// 示例 1：
//
//
//输入：ranks = [4,2,3,1], cars = 10
//输出：16
//解释：
//- 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
//- 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
//- 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
//- 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//16 分钟是修理完所有车需要的最少时间。
//
//
// 示例 2：
//
//
//输入：ranks = [5,1,8], cars = 6
//输出：16
//解释：
//- 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
//- 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//- 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
//16 分钟时修理完所有车需要的最少时间。
//
//
//
//
// 提示：
//
//
// 1 <= ranks.length <= 10⁵
// 1 <= ranks[i] <= 100
// 1 <= cars <= 10⁶
//
//
// Related Topics 数组 二分查找 👍 69 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumTimeToRepairCars;

/**
 * @author JUE
 * @number 2594
 */
public class MinimumTimeToRepairCars {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repairCars(new int[]{4, 2, 3, 1}, 10)); // 16
        System.out.println(solution.repairCars(new int[]{5, 1, 8}, 6)); // 16
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long repairCars(int[] ranks, int cars) {
        // 这道题不是线性增长 是指数增长；且系数有差异；预计不能使用动态规划，前一个结果并不能必然导致后一个结果？
        // answer 二分查找法，反向找出 第 n 分钟供修理了多少汽车[随时间增长修理车数量递增，可以使用二分查找法]
        long low = 0, high = (long) ranks[0] * cars * cars; // 汽车数量过大时会超出范围
        while (low < high) {
            long mid = low + high >> 1;
            if (fixAll(ranks, cars, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean fixAll(int[] ranks, int cars, long time) {
        long fix = 0;
        for (int rank : ranks) {
            fix += (long) Math.sqrt((time * 1.0) / rank);
        }
        return fix >= cars;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
