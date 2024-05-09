//你打算利用空闲时间来做兼职工作赚些零花钱。 
//
// 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。 
//
// 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。 
//
// 注意，时间上出现重叠的 2 份工作不能同时进行。 
//
// 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//输出：120
//解释：
//我们选出第 1 份和第 4 份工作， 
//时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
// 
//
// 示例 2： 
//
// 
//
// 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60
//]
//输出：150
//解释：
//我们选择第 1，4，5 份工作。 
//共获得报酬 150 = 20 + 70 + 60。
// 
//
// 示例 3： 
//
// 
//
// 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4 
// 1 <= startTime[i] < endTime[i] <= 10^9 
// 1 <= profit[i] <= 10^4 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 448 👎 0


package com.jue.java.learn.leetcode.editor.cn.MaximumProfitInJobScheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JUE
 * @number 1235
 */
public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70})); // 120
        System.out.println(solution.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60})); // 150
        System.out.println(solution.jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4})); // 6
        System.out.println(solution.jobScheduling(new int[]{341, 22, 175, 424, 574, 687, 952, 439, 51, 562, 962, 890, 250, 47, 945, 914, 835, 937, 419, 343, 125, 809, 807, 959, 403, 861, 296, 39, 802, 562, 811, 991, 209, 375, 78, 685, 592, 409, 369, 478, 417, 162, 938, 298, 618, 745, 888, 463, 213, 351, 406, 840, 779, 299, 90, 846, 58, 235, 725, 676, 239, 256, 996, 362, 819, 622, 449, 880, 951, 314, 425, 127, 299, 326, 576, 743, 740, 604, 151, 391, 925, 605, 770, 253, 670, 507, 306, 294, 519, 184, 848, 586, 593, 909, 163, 129, 685, 481, 258, 764},
                new int[]{462, 101, 820, 999, 900, 692, 991, 512, 655, 578, 996, 979, 425, 893, 975, 960, 930, 991, 987, 524, 208, 901, 841, 961, 878, 882, 412, 795, 937, 807, 957, 994, 963, 716, 608, 774, 681, 637, 635, 660, 750, 632, 948, 771, 943, 801, 985, 476, 532, 535, 929, 943, 837, 565, 375, 854, 174, 698, 820, 710, 566, 464, 997, 551, 884, 844, 830, 916, 970, 965, 585, 631, 785, 632, 892, 954, 803, 764, 283, 477, 970, 616, 794, 911, 771, 797, 776, 686, 895, 721, 917, 920, 975, 984, 996, 471, 770, 656, 977, 922},
                new int[]{85, 95, 14, 72, 17, 3, 86, 65, 50, 50, 42, 75, 40, 87, 35, 78, 47, 74, 92, 10, 100, 29, 55, 57, 51, 34, 10, 96, 14, 71, 63, 99, 8, 37, 16, 71, 10, 71, 83, 88, 68, 79, 27, 87, 3, 58, 56, 43, 89, 31, 16, 9, 49, 84, 62, 30, 35, 7, 27, 34, 24, 33, 100, 25, 90, 79, 58, 21, 31, 30, 61, 46, 36, 45, 85, 62, 91, 54, 28, 63, 50, 69, 48, 36, 77, 39, 19, 97, 20, 39, 48, 72, 37, 67, 72, 46, 54, 37, 53, 30})); // 998

        System.out.println(solution.jobScheduling(new int[]{11, 13, 2, 40, 26, 6, 25, 21, 62, 45}, new int[]{91, 76, 45, 56, 27, 99, 26, 26, 93, 52}, new int[]{80, 31, 56, 80, 52, 57, 12, 59, 70, 4})); // 261
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 这道题似乎见过很多次了，动态规划；状态转移方程式 dp[i] = max(dp[i-x], dp[max[i-len] + len ])
        // 总长度未知
        int len = startTime.length;
        int[][] store = new int[len][2];
        for (int i = 0; i < len; i++) {
            store[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        // 开始时间短的先放在前面
        Arrays.sort(store, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int max = 0;
        // 超过容量限制 int[] dp = new int[store[len - 1][1] + 1]; 使用list查找第一个给定数的值
        List<int[]> dp = new ArrayList<>();
        dp.add(new int[]{-1, 0});
        for (int[] i : store) {
            max = Math.max(max, find(dp, i[0]) + i[2]);
            // 需要删除重复数据
            if (dp.get(dp.size() - 1)[0] == i[1]) {
                dp.remove(dp.size() - 1);
            }
            dp.add(new int[]{i[1], max});
        }
        return max;
    }

    private int find(List<int[]> dp, int idx) {
        // 找到小于等于给定索引的第一个数
        int l = 0, r = dp.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            int ci = dp.get(mid)[0];
            if (ci == idx) {
                l = mid;
                break;
            } else if (ci > idx) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return dp.get(l)[1];
    }

}

//leetcode submit region end(Prohibit modification and deletion)
class Solution_MemoryLimit {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 这道题似乎见过很多次了，动态规划；状态转移方程式 dp[i] = max(dp[i-x], dp[max[i-len] + len ])
        // 总长度未知
        int len = startTime.length;
        int[][] store = new int[len][2];
        for (int i = 0; i < len; i++) {
            store[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        // 开始时间短的先放在前面
        Arrays.sort(store, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int max = 0;
        int[] dp = new int[store[len - 1][1] + 1];
        int last = 0;
        for (int[] i : store) {
            while (last < i[1]) {
                // 更新中间阶段的最大数
                dp[++last] = max;
            }
            max = Math.max(max, dp[i[0]] + i[2]);
            dp[i[1]] = max;
        }
        return max;
    }
}
