//有 n 名工人。 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i] 
//。 
//
// 现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资： 
//
// 
// 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。 
// 工资组中的每名工人至少应当得到他们的最低期望工资。 
// 
//
// 给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10⁻⁵ 以内的答案将被接受。。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入： quality = [10,20,5], wage = [70,50,30], k = 2
//输出： 105.00000
//解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。 
//
// 示例 2： 
//
// 
//输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
//输出： 30.66667
//解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。 
//
// 
//
// 提示： 
//
// 
// n == quality.length == wage.length 
// 1 <= k <= n <= 10⁴ 
// 1 <= quality[i], wage[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 331 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumCostToHireKWorkers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author JUE
 * @number 857
 */
public class MinimumCostToHireKWorkers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2)); // 105.00000
        System.out.println(solution.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3)); // 30.66667
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // 解析: 按照期望/质量排序从小到大排序，排在后面的一定能够满足最低工资条件
        int len = quality.length;
        Integer[] s = new Integer[len];
        for (int i = 0; i < len; i++) {
            s[i] = i;
        }
        Arrays.sort(s, (a, b) -> quality[b] * wage[a] - quality[a] * wage[b]);

        // 每次移出质量最大的数据
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        double totalQuality = 0;
        double minCost = Double.MAX_VALUE / 2;
        for (int i = 0; i < len; i++) {
            int idx = s[i];
            queue.add(quality[idx]);
            totalQuality += quality[idx];
            if (i >= k && !queue.isEmpty()) {
                // 移除数据
                totalQuality -= queue.poll();
            }

            // 计算花费
            if (i >= k - 1 && !queue.isEmpty()) {
                minCost = Math.min(minCost, totalQuality * wage[idx] * 1D / quality[idx]);
            }
        }
        return minCost;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
